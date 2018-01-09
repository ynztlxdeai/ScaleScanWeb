package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holob2csendoerderdet;
import com.moyansz.scalescan.po.Holob2csendoerderdetExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Holob2csendoerderdetMapper {
    int countByExample(Holob2csendoerderdetExample example);

    int deleteByExample(Holob2csendoerderdetExample example);

    int deleteByPrimaryKey(Integer hsenddetid);

    int insert(Holob2csendoerderdet record);

    int insertSelective(Holob2csendoerderdet record);

    List<Holob2csendoerderdet> selectByExample(Holob2csendoerderdetExample example);

    Holob2csendoerderdet selectByPrimaryKey(Integer hsenddetid);

    int updateByExampleSelective(@Param("record") Holob2csendoerderdet record,
                                 @Param("example") Holob2csendoerderdetExample example);

    int updateByExample(@Param("record") Holob2csendoerderdet record,
                        @Param("example") Holob2csendoerderdetExample example);

    int updateByPrimaryKeySelective(Holob2csendoerderdet record);

    int updateByPrimaryKey(Holob2csendoerderdet record);
}