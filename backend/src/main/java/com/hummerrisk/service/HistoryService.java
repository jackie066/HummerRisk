package com.hummerrisk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hummerrisk.base.domain.Package;
import com.hummerrisk.base.domain.*;
import com.hummerrisk.base.mapper.*;
import com.hummerrisk.base.mapper.ext.ExtResourceMapper;
import com.hummerrisk.commons.constants.TaskConstants;
import com.hummerrisk.commons.constants.TaskEnum;
import com.hummerrisk.commons.utils.PlatformUtils;
import com.hummerrisk.commons.utils.SessionUtils;
import com.hummerrisk.commons.utils.UUIDUtil;
import com.hummerrisk.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author harris
 */
@Service
public class HistoryService {

    @Resource @Lazy
    private ExtResourceMapper extResourceMapper;
    @Resource @Lazy
    private HistoryScanMapper historyScanMapper;
    @Resource @Lazy
    private HistoryScanTaskMapper historyScanTaskMapper;
    @Resource @Lazy
    private HistoryCloudTaskMapper historyCloudTaskMapper;
    @Resource @Lazy
    private HistoryCloudTaskItemMapper historyCloudTaskItemMapper;
    @Resource @Lazy
    private HistoryCloudTaskLogMapper historyCloudTaskLogMapper;
    @Resource @Lazy
    private HistoryCloudTaskResourceMapper historyCloudTaskResourceMapper;
    @Resource @Lazy
    private HistoryVulnTaskMapper historyVulnTaskMapper;
    @Resource @Lazy
    private HistoryVulnTaskItemMapper historyVulnTaskItemMapper;
    @Resource @Lazy
    private HistoryVulnTaskLogMapper historyVulnTaskLogMapper;
    @Resource @Lazy
    private HistoryVulnTaskResourceMapper historyVulnTaskResourceMapper;
    @Resource @Lazy
    private HistoryServerTaskMapper historyServerTaskMapper;
    @Resource @Lazy
    private HistoryServerTaskLogMapper historyServerTaskLogMapper;
    @Resource @Lazy
    private HistoryPackageTaskMapper historyPackageTaskMapper;
    @Resource @Lazy
    private HistoryPackageTaskLogMapper historyPackageTaskLogMapper;
    @Resource @Lazy
    private HistoryImageTaskMapper historyImageTaskMapper;
    @Resource @Lazy
    private HistoryImageTaskLogMapper historyImageTaskLogMapper;

    public Integer insertScanHistory (Object obj) throws Exception {

        String accountId = obj2Account(obj).get("accountId").toString();
        String accountType = obj2Account(obj).get("accountType").toString();

        HistoryScan history = new HistoryScan();
        history.setOperator(SessionUtils.getUserId());
        history.setAccountId(accountId);
        history.setAccountType(accountType);
        history.setStatus(TaskConstants.TASK_STATUS.APPROVED.name());
        history.setCreateTime(System.currentTimeMillis());
        historyScanMapper.insertSelective(history);
        return history.getId();
    }

    public Integer updateScanHistory (HistoryScan historyScan) throws Exception {

        HistoryScanTaskExample historyScanTaskExample = new HistoryScanTaskExample();
        historyScanTaskExample.createCriteria().andScanIdEqualTo(historyScan.getId());
        List<HistoryScanTask> historyScanTasks = historyScanTaskMapper.selectByExampleWithBLOBs(historyScanTaskExample);
        JSONArray jsonArray = new JSONArray();
        historyScanTasks.forEach(item ->{
            if(item.getOutput()!=null) jsonArray.addAll(JSON.parseArray(item.getOutput()));
        });
        historyScan.setOutput(jsonArray.toJSONString());
        historyScan.setResourcesSum(Long.valueOf(extResourceMapper.sumResourcesSum(historyScan.getId())));
        historyScan.setReturnSum(Long.valueOf(extResourceMapper.sumReturnSum(historyScan.getId())));
        historyScan.setScanScore(extResourceMapper.sumScanScore(historyScan.getId()));
        historyScanMapper.updateByPrimaryKeySelective(historyScan);
        return historyScan.getId();
    }

    public void insertScanTaskHistory (Object obj, Integer scanId, String accountId, String accountType) throws Exception {
        HistoryScanTask historyScanTask = new HistoryScanTask();
        historyScanTask.setScanId(scanId);
        historyScanTask.setTaskId(obj2Result(obj));
        historyScanTask.setAccountId(accountId);
        historyScanTask.setAccountType(accountType);
        historyScanTask.setStatus(TaskConstants.TASK_STATUS.APPROVED.name());
        historyScanTask.setOperation("i18n_create_scan_history");
        historyScanTaskMapper.insertSelective(historyScanTask);
    }

    public void updateScanTaskHistory (HistoryScanTask historyScanTask) throws Exception {
        try{
            historyScanTaskMapper.updateByPrimaryKeySelective(historyScanTask);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    private boolean isJson(String str){
        try {
            JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //通过对象获取资源ID
    public Map obj2Account(Object obj) throws Exception{
        Map map = new HashMap<>();
        try {
            String accountId = "";
            if (obj.getClass() == Account.class || obj.getClass() == AccountWithBLOBs.class) {
                accountId = ((Account) obj).getId();
                if (PlatformUtils.isSupportCloudAccount(((Account) obj).getPluginId())) {
                    map.put("accountType", TaskEnum.cloudAccount.getType());
                } else {
                    map.put("accountType", TaskEnum.vulnAccount.getType());
                }
            } else if(obj.getClass() == Server.class || obj.getClass() == ServerDTO.class) {
                accountId = ((Server) obj).getId();
                map.put("accountType", TaskEnum.serverAccount.getType());
            } else if(obj.getClass() == Image.class || obj.getClass() == ImageDTO.class) {
                accountId = ((Image) obj).getId();
                map.put("accountType", TaskEnum.imageAccount.getType());
            } else if(obj.getClass() == Package.class || obj.getClass() == PackageDTO.class) {
                accountId = ((Package) obj).getId();
                map.put("accountType", TaskEnum.packageAccount.getType());
            }
            map.put("accountId", accountId);
            return map;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //通过对象获取资源ID
    public String obj2Result(Object obj) throws Exception{
        try {
            String resultId = "";
            if (obj.getClass() == CloudTask.class || obj.getClass() == CloudTaskDTO.class) {
                resultId = ((CloudTask) obj).getId();
            } else if(obj.getClass() == ServerResult.class || obj.getClass() == ServerResultDTO.class) {
                resultId = ((ServerResult) obj).getId();
            } else if(obj.getClass() == ImageResult.class || obj.getClass() == ImageResultWithBLOBs.class || obj.getClass() == ImageResultDTO.class) {
                resultId = ((ImageResult) obj).getId();
            } else if(obj.getClass() == PackageResult.class || obj.getClass() == PackageResultWithBLOBs.class || obj.getClass() == PackageResultDTO.class) {
                resultId = ((PackageResult) obj).getId();
            }
            return resultId;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 计算安全检测评分
     * 高：中：低 = 5 ： 3 ： 2
     * @param accountId
     * @return
     */
    public Integer calculateScore (String accountId, Object task, String accountType) {

        Integer score = 100;
        if(task == null) {
            return score;
        }
        if (StringUtils.equalsIgnoreCase(accountType, TaskEnum.cloudAccount.getType())) {

            CloudTask cloudTask = (CloudTask) task;
            Double highResultPercent = Double.valueOf(extResourceMapper.resultPercentByCloud(accountId, "HighRisk", cloudTask ==null?null: cloudTask.getId())!=null?extResourceMapper.resultPercentByCloud(accountId, "HighRisk", cloudTask ==null?null: cloudTask.getId()):"0.0");
            Double mediumlResultPercent = Double.valueOf(extResourceMapper.resultPercentByCloud(accountId, "MediumRisk", cloudTask ==null?null: cloudTask.getId())!=null?extResourceMapper.resultPercentByCloud(accountId, "MediumRisk", cloudTask ==null?null: cloudTask.getId()): "0.0");
            Double lowResultPercent = Double.valueOf(extResourceMapper.resultPercentByCloud(accountId, "LowRisk", cloudTask ==null?null: cloudTask.getId())!=null?extResourceMapper.resultPercentByCloud(accountId, "LowRisk", cloudTask ==null?null: cloudTask.getId()):"0.0");

            HistoryCloudTaskExample example = new HistoryCloudTaskExample();
            HistoryCloudTaskExample.Criteria criteria = example.createCriteria();
            criteria.andAccountIdEqualTo(accountId).andSeverityEqualTo("HighRisk");
            long high = historyCloudTaskMapper.countByExample(example);
            criteria.andSeverityEqualTo("MediumRisk");
            long mediuml = historyCloudTaskMapper.countByExample(example);
            criteria.andSeverityEqualTo("LowRisk");
            long low = historyCloudTaskMapper.countByExample(example);

            long sum = 5 * high + 3 * mediuml + 2 * low;
            score = 100 - (int) Math.ceil(highResultPercent * (5 * high / (sum == 0 ? 1 : sum) ) * 100 + mediumlResultPercent * (3 * mediuml / (sum == 0 ? 1 : sum) ) * 100 + lowResultPercent * (2 * low / (sum == 0 ? 1 : sum) ) * 100);

        } else if(StringUtils.equalsIgnoreCase(accountType, TaskEnum.vulnAccount.getType())) {
            CloudTask historyVulnTask = (CloudTask) task;
            Double highResultPercent = Double.valueOf(extResourceMapper.resultPercentByVuln(accountId, "HighRisk", historyVulnTask ==null?null: historyVulnTask.getId())!=null?extResourceMapper.resultPercentByVuln(accountId, "HighRisk", historyVulnTask ==null?null: historyVulnTask.getId()):"0.0");
            Double mediumlResultPercent = Double.valueOf(extResourceMapper.resultPercentByVuln(accountId, "MediumRisk", historyVulnTask ==null?null: historyVulnTask.getId())!=null?extResourceMapper.resultPercentByVuln(accountId, "MediumRisk", historyVulnTask ==null?null: historyVulnTask.getId()): "0.0");
            Double lowResultPercent = Double.valueOf(extResourceMapper.resultPercentByVuln(accountId, "LowRisk", historyVulnTask ==null?null: historyVulnTask.getId())!=null?extResourceMapper.resultPercentByVuln(accountId, "LowRisk", historyVulnTask ==null?null: historyVulnTask.getId()):"0.0");

            HistoryVulnTaskExample example = new HistoryVulnTaskExample();
            HistoryVulnTaskExample.Criteria criteria = example.createCriteria();
            criteria.andAccountIdEqualTo(accountId).andSeverityEqualTo("HighRisk");
            long high = historyVulnTaskMapper.countByExample(example);
            criteria.andSeverityEqualTo("MediumRisk");
            long mediuml = historyVulnTaskMapper.countByExample(example);
            criteria.andSeverityEqualTo("LowRisk");
            long low = historyVulnTaskMapper.countByExample(example);

            long sum = 5 * high + 3 * mediuml + 2 * low;
            score = 100 - (int) Math.ceil(highResultPercent * (5 * high / (sum == 0 ? 1 : sum) ) * 100 + mediumlResultPercent * (3 * mediuml / (sum == 0 ? 1 : sum) ) * 100 + lowResultPercent * (2 * low / (sum == 0 ? 1 : sum) ) * 100);

        } else if(StringUtils.equalsIgnoreCase(accountType, TaskEnum.serverAccount.getType())) {
            ServerResult serverResult = (ServerResult) task;
            if (StringUtils.equalsIgnoreCase(serverResult.getSeverity(), TaskConstants.Severity.HighRisk.name())) {
                score = 100 - 20;
            } else if (StringUtils.equalsIgnoreCase(serverResult.getSeverity(), TaskConstants.Severity.MediumRisk.name())) {
                score = 100 - 10;
            } else if (StringUtils.equalsIgnoreCase(serverResult.getSeverity(), TaskConstants.Severity.LowRisk.name())) {
                score = 100 - 5;
            }
        } else if(StringUtils.equalsIgnoreCase(accountType, TaskEnum.imageAccount.getType())) {
            ImageResult imageResult = (ImageResult) task;
            if (imageResult.getReturnSum() >= 0 && imageResult.getReturnSum() < 10) {
                score = 100 - 5;
            } else if (imageResult.getReturnSum() >= 10 && imageResult.getReturnSum() < 50) {
                score = 100 - 10;
            } else if (imageResult.getReturnSum() >= 50 && imageResult.getReturnSum() < 100) {
                score = 100 - 20;
            } else if (imageResult.getReturnSum() >= 100 && imageResult.getReturnSum() < 200) {
                score = 100 - 30;
            } else if (imageResult.getReturnSum() >= 200 && imageResult.getReturnSum() < 500) {
                score = 100 - 40;
            } else {
                score = 100 - 41;
            }
        } else if(StringUtils.equalsIgnoreCase(accountType, TaskEnum.packageAccount.getType())) {
            PackageResult packageResult = (PackageResult) task;
            if (packageResult.getReturnSum() >= 0 && packageResult.getReturnSum() < 10) {
                score = 100 - 5;
            } else if (packageResult.getReturnSum() >= 10 && packageResult.getReturnSum() < 50) {
                score = 100 - 10;
            } else if (packageResult.getReturnSum() >= 50 && packageResult.getReturnSum() < 100) {
                score = 100 - 20;
            } else if (packageResult.getReturnSum() >= 100 && packageResult.getReturnSum() < 200) {
                score = 100 - 30;
            } else if (packageResult.getReturnSum() >= 200 && packageResult.getReturnSum() < 500) {
                score = 100 - 40;
            } else {
                score = 100 - 41;
            }
        }

        return score;
    }

    public void insertHistoryCloudTask(HistoryCloudTask historyCloudTask) throws Exception {
        try {
            historyCloudTaskMapper.insertSelective(historyCloudTask);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryCloudTask(HistoryCloudTask historyCloudTask) throws Exception {
        try {
            historyCloudTaskMapper.updateByPrimaryKeySelective(historyCloudTask);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryCloudTaskItem(HistoryCloudTaskItemWithBLOBs historyCloudTaskItem) throws Exception {
        try {
            historyCloudTaskItemMapper.insertSelective(historyCloudTaskItem);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryCloudTaskItem(HistoryCloudTaskItemWithBLOBs historyCloudTaskItem) throws Exception {
        try {
            historyCloudTaskItemMapper.updateByPrimaryKeySelective(historyCloudTaskItem);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryCloudTaskLog(HistoryCloudTaskLog historyCloudTaskLog) throws Exception {
        try {
            historyCloudTaskLogMapper.insertSelective(historyCloudTaskLog);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryCloudTaskResource(HistoryCloudTaskResourceWithBLOBs historyCloudTaskResource) throws Exception {
        try {
            historyCloudTaskResource.setId(UUIDUtil.newUUID());
            historyCloudTaskResourceMapper.insertSelective(historyCloudTaskResource);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryCloudTaskResource(HistoryCloudTaskResourceWithBLOBs historyCloudTaskResource) throws Exception {
        try {
            historyCloudTaskResourceMapper.updateByPrimaryKeySelective(historyCloudTaskResource);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryVulnTask(HistoryVulnTask historyVulnTask) throws Exception {
        try {
            historyVulnTaskMapper.insertSelective(historyVulnTask);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryVulnTask(HistoryVulnTask historyVulnTask) throws Exception {
        try {
            historyVulnTaskMapper.updateByPrimaryKeySelective(historyVulnTask);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryVulnTaskItem(HistoryVulnTaskItemWithBLOBs historyVulnTaskItem) throws Exception {
        try {
            historyVulnTaskItemMapper.insertSelective(historyVulnTaskItem);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryVulnTaskItem(HistoryVulnTaskItemWithBLOBs historyVulnTaskItemWithBLOBs) throws Exception {
        try {
            historyVulnTaskItemMapper.updateByPrimaryKeySelective(historyVulnTaskItemWithBLOBs);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryVulnTaskLog(HistoryVulnTaskLog historyVulnTaskLog) throws Exception {
        try {
            historyVulnTaskLogMapper.insertSelective(historyVulnTaskLog);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryVulnTaskResource(HistoryVulnTaskResourceWithBLOBs historyVulnTaskResource) throws Exception {
        try {
            historyVulnTaskResource.setId(UUIDUtil.newUUID());
            historyVulnTaskResourceMapper.insertSelective(historyVulnTaskResource);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateHistoryVulnTaskResource(HistoryVulnTaskResourceWithBLOBs historyVulnTaskResource) throws Exception {
        try {
            historyVulnTaskResourceMapper.updateByPrimaryKeySelective(historyVulnTaskResource);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void insertHistoryServerTask(HistoryServerTask record) {
        historyServerTaskMapper.insertSelective(record);
    }

    public void updateHistoryServerTask(HistoryServerTask record) {
        historyServerTaskMapper.updateByPrimaryKeySelective(record);
    }

    public void insertHistoryServerTaskLog(HistoryServerTaskLog record) {
        historyServerTaskLogMapper.insertSelective(record);
    }

    public void insertHistoryPackageTask(HistoryPackageTaskWithBLOBs record) {
        historyPackageTaskMapper.insertSelective(record);
    }

    public void updateHistoryPackageTask(HistoryPackageTaskWithBLOBs record) {
        historyPackageTaskMapper.updateByPrimaryKeySelective(record);
    }

    public void insertHistoryPackageTaskLog(HistoryPackageTaskLog record) {
        historyPackageTaskLogMapper.insertSelective(record);
    }

    public void insertHistoryImageTask(HistoryImageTaskWithBLOBs record) {
        historyImageTaskMapper.insertSelective(record);
    }

    public void updateHistoryImageTask(HistoryImageTaskWithBLOBs record) {
        historyImageTaskMapper.updateByPrimaryKeySelective(record);
    }

    public void insertHistoryImageTaskLog(HistoryImageTaskLog record) {
        historyImageTaskLogMapper.insertSelective(record);
    }

}
