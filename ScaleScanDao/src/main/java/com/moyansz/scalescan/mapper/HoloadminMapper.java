package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holoadmin;
import com.moyansz.scalescan.po.HoloadminExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoloadminMapper {
    int countByExample(HoloadminExample example);

    int deleteByExample(HoloadminExample example);

    int deleteByPrimaryKey(Integer aid);

    int insert(Holoadmin record);

    int insertSelective(Holoadmin record);

    List<Holoadmin> selectByExample(HoloadminExample example);

    Holoadmin selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Holoadmin record,
                                 @Param("example") HoloadminExample example);

    int updateByExample(@Param("record") Holoadmin record,
                        @Param("example") HoloadminExample example);

    int updateByPrimaryKeySelective(Holoadmin record);

    int updateByPrimaryKey(Holoadmin record);
}