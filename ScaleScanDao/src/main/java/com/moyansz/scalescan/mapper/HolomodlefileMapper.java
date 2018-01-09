package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holomodlefile;
import com.moyansz.scalescan.po.HolomodlefileExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolomodlefileMapper {

    int countByExample(HolomodlefileExample example);

    int deleteByExample(HolomodlefileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Holomodlefile record);

    int insertSelective(Holomodlefile record);

    List<Holomodlefile> selectByExample(HolomodlefileExample example);

    Holomodlefile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Holomodlefile record, @Param("example") HolomodlefileExample example);

    int updateByExample(@Param("record") Holomodlefile record, @Param("example") HolomodlefileExample example);

    int updateByPrimaryKeySelective(Holomodlefile record);

    int updateByPrimaryKey(Holomodlefile record);

    List<Holomodlefile> selectByModlePath(String fileName);

    List<Holomodlefile> selectByNameAndUserid(Holomodlefile record);
}