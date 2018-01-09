package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holoentgoods;
import com.moyansz.scalescan.po.HoloentgoodsExample;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoloentgoodsMapper {
    int countByExample(HoloentgoodsExample example);

    int deleteByExample(HoloentgoodsExample example);

    int deleteByPrimaryKey(Integer hgoodsid);

    int insert(Holoentgoods record);

    int insertSelective(Holoentgoods record);

    List<Holoentgoods> selectByExample(HoloentgoodsExample example);

    Holoentgoods selectByPrimaryKey(Integer hgoodsid);

    int updateByExampleSelective(@Param("record") Holoentgoods record,
                                 @Param("example") HoloentgoodsExample example);

    int updateByExample(@Param("record") Holoentgoods record,
                        @Param("example") HoloentgoodsExample example);

    int updateByPrimaryKeySelective(Holoentgoods record);

    int updateByPrimaryKey(Holoentgoods record);
}