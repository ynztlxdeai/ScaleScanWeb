package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holob2csendorderhead;
import com.moyansz.scalescan.po.Holob2csendorderheadExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Holob2csendorderheadMapper {
    int countByExample(Holob2csendorderheadExample example);

    int deleteByExample(Holob2csendorderheadExample example);

    int deleteByPrimaryKey(Integer hsendid);

    int insert(Holob2csendorderhead record);

    int insertSelective(Holob2csendorderhead record);

    List<Holob2csendorderhead> selectByExample(Holob2csendorderheadExample example);

    Holob2csendorderhead selectByPrimaryKey(Integer hsendid);

    int updateByExampleSelective(@Param("record") Holob2csendorderhead record,
                                 @Param("example") Holob2csendorderheadExample example);

    int updateByExample(@Param("record") Holob2csendorderhead record,
                        @Param("example") Holob2csendorderheadExample example);

    int updateByPrimaryKeySelective(Holob2csendorderhead record);

    int updateByPrimaryKey(Holob2csendorderhead record);
}