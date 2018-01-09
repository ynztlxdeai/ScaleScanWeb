package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holosecretkeys;
import com.moyansz.scalescan.po.HolosecretkeysExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolosecretkeysMapper {
    int countByExample(HolosecretkeysExample example);

    int deleteByExample(HolosecretkeysExample example);

    int deleteByPrimaryKey(String secretkey);

    int insert(Holosecretkeys record);

    int insertSelective(Holosecretkeys record);

    List<Holosecretkeys> selectByExample(HolosecretkeysExample example);

    Holosecretkeys selectByPrimaryKey(String secretkey);

    int updateByExampleSelective(@Param("record") Holosecretkeys record,
                                 @Param("example") HolosecretkeysExample example);

    int updateByExample(@Param("record") Holosecretkeys record,
                        @Param("example") HolosecretkeysExample example);

    int updateByPrimaryKeySelective(Holosecretkeys record);

    int updateByPrimaryKey(Holosecretkeys record);
}