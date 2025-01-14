package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.ImageSyftTable;
import com.hummerrisk.base.domain.ImageSyftTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageSyftTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    long countByExample(ImageSyftTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int deleteByExample(ImageSyftTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int insert(ImageSyftTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int insertSelective(ImageSyftTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    List<ImageSyftTable> selectByExample(ImageSyftTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    ImageSyftTable selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int updateByExampleSelective(@Param("record") ImageSyftTable record, @Param("example") ImageSyftTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int updateByExample(@Param("record") ImageSyftTable record, @Param("example") ImageSyftTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int updateByPrimaryKeySelective(ImageSyftTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_syft_table
     *
     * @mbg.generated Sun Jul 24 02:46:37 CST 2022
     */
    int updateByPrimaryKey(ImageSyftTable record);
}
