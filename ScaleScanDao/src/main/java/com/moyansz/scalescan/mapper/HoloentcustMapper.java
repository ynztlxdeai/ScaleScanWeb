package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holoentcust;
import com.moyansz.scalescan.po.HoloentcustExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoloentcustMapper {
    int countByExample(HoloentcustExample example);

    int deleteByExample(HoloentcustExample example);

    int insert(Holoentcust record);

    int insertSelective(Holoentcust record);

    List<Holoentcust> selectByExample(HoloentcustExample example);

    int updateByExampleSelective(@Param("record") Holoentcust record,
                                 @Param("example") HoloentcustExample example);

    int updateByExample(@Param("record") Holoentcust record,
                        @Param("example") HoloentcustExample example);
}