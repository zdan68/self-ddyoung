package com.self.ddyoung.daily.dao;

import com.self.ddyoung.daily.model.VerifyDO;
import com.self.ddyoung.daily.model.VerifyDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VerifyDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int countByExample(VerifyDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int deleteByExample(VerifyDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int insert(VerifyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int insertSelective(VerifyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    List<VerifyDO> selectByExample(VerifyDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    VerifyDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int updateByExampleSelective(@Param("record") VerifyDO record, @Param("example") VerifyDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int updateByExample(@Param("record") VerifyDO record, @Param("example") VerifyDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int updateByPrimaryKeySelective(VerifyDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cu_ac_writeoff_0000
     *
     * @mbggenerated Wed Feb 15 11:01:04 CST 2017
     */
    int updateByPrimaryKey(VerifyDO record);
}