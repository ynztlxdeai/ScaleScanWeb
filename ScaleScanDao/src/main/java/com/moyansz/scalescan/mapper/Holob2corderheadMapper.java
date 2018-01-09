package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holob2corderhead;
import com.moyansz.scalescan.po.Holob2corderheadExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Holob2corderheadMapper {
    int countByExample(Holob2corderheadExample example);

    int deleteByExample(Holob2corderheadExample example);

    int deleteByPrimaryKey(Integer horderid);

    int insert(Holob2corderhead record);

    int insertSelective(Holob2corderhead record);

    List<Holob2corderhead> selectByExample(Holob2corderheadExample example);

    Holob2corderhead selectByPrimaryKey(Integer horderid);

    int updateByExampleSelective(@Param("record") Holob2corderhead record,
                                 @Param("example") Holob2corderheadExample example);

    int updateByExample(@Param("record") Holob2corderhead record,
                        @Param("example") Holob2corderheadExample example);

    int updateByPrimaryKeySelective(Holob2corderhead record);

    int updateByPrimaryKey(Holob2corderhead record);
}