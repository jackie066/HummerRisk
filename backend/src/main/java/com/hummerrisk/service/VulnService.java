package com.hummerrisk.service;

import com.hummerrisk.base.domain.Task;
import com.hummerrisk.base.domain.TaskExample;
import com.hummerrisk.base.mapper.TaskMapper;
import com.hummerrisk.base.mapper.ext.ExtAccountMapper;
import com.hummerrisk.base.mapper.ext.ExtRuleMapper;
import com.hummerrisk.controller.request.account.CloudAccountRequest;
import com.hummerrisk.controller.request.rule.CreateRuleRequest;
import com.hummerrisk.dto.AccountDTO;
import com.hummerrisk.dto.RuleDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author harris
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VulnService {

    @Resource
    private ExtAccountMapper extAccountMapper;
    @Resource
    private ExtRuleMapper extRuleMapper;
    @Resource
    private TaskMapper taskMapper;

    public List<AccountDTO> getVulnList(CloudAccountRequest request) {
        return extAccountMapper.getVulnList(request);
    }

    public List<RuleDTO> vulnList(CreateRuleRequest ruleRequest) {
        return extRuleMapper.vulnList(ruleRequest);
    }

    public List<Task> selectManualTasks(Map<String, Object> params) throws Exception {

        try {
            TaskExample example = new TaskExample();
            TaskExample.Criteria criteria = example.createCriteria();
            if (params.get("name") != null && StringUtils.isNotEmpty(params.get("name").toString())) {
                criteria.andTaskNameLike("%" + params.get("name").toString() + "%");
            }
            if (params.get("type") != null && StringUtils.isNotEmpty(params.get("type").toString())) {
                criteria.andTypeEqualTo(params.get("type").toString());
            }
            if (params.get("accountId") != null && StringUtils.isNotEmpty(params.get("accountId").toString())) {
                criteria.andAccountIdEqualTo(params.get("accountId").toString());
            }
            if (params.get("cron") != null && StringUtils.isNotEmpty(params.get("cron").toString())) {
                criteria.andCronLike(params.get("cron").toString());
            }
            if (params.get("status") != null && StringUtils.isNotEmpty(params.get("status").toString())) {
                criteria.andStatusEqualTo(params.get("status").toString());
            }
            if (params.get("severity") != null && StringUtils.isNotEmpty(params.get("severity").toString())) {
                criteria.andSeverityEqualTo(params.get("severity").toString());
            }
            if (params.get("pluginName") != null && StringUtils.isNotEmpty(params.get("pluginName").toString())) {
                criteria.andPluginNameEqualTo(params.get("pluginName").toString());
            }
            if (params.get("ruleTag") != null && StringUtils.isNotEmpty(params.get("ruleTag").toString())) {
                criteria.andRuleTagsLike("%" + params.get("ruleTag").toString() + "%");
            }
            if (params.get("resourceType") != null && StringUtils.isNotEmpty(params.get("resourceType").toString())) {
                criteria.andResourceTypesLike("%" + params.get("resourceType").toString() + "%");
            }
            List<String> values = new ArrayList<>();
            values.add("hummer-nuclei-plugin");
            values.add("hummer-xray-plugin");
            criteria.andPluginIdIn(values);
            example.setOrderByClause("FIELD(`status`, 'PROCESSING', 'APPROVED', 'FINISHED', 'WARNING', 'ERROR'), return_sum desc, create_time desc, FIELD(`severity`, 'HighRisk', 'MediumRisk', 'LowRisk')");
            return taskMapper.selectByExample(example);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}