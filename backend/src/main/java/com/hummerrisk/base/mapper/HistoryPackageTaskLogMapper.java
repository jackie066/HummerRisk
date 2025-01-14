package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.HistoryPackageTaskLog;
import com.hummerrisk.base.domain.HistoryPackageTaskLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryPackageTaskLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    long countByExample(HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int deleteByExample(HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int insert(HistoryPackageTaskLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int insertSelective(HistoryPackageTaskLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    List<HistoryPackageTaskLog> selectByExampleWithBLOBs(HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    List<HistoryPackageTaskLog> selectByExample(HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    HistoryPackageTaskLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByExampleSelective(@Param("record") HistoryPackageTaskLog record, @Param("example") HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByExampleWithBLOBs(@Param("record") HistoryPackageTaskLog record, @Param("example") HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByExample(@Param("record") HistoryPackageTaskLog record, @Param("example") HistoryPackageTaskLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByPrimaryKeySelective(HistoryPackageTaskLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByPrimaryKeyWithBLOBs(HistoryPackageTaskLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history_package_task_log
     *
     * @mbg.generated Thu Jul 21 01:24:27 CST 2022
     */
    int updateByPrimaryKey(HistoryPackageTaskLog record);
}
