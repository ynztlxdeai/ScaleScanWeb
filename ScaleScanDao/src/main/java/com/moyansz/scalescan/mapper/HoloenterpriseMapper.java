package com.moyansz.scalescan.mapper;

import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.HoloenterpriseExample;
import com.moyansz.scalescan.po.vo.LoginInfo;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HoloenterpriseMapper {
    int countByExample(HoloenterpriseExample example);

    int deleteByExample(HoloenterpriseExample example);

    int deleteByPrimaryKey(Integer huserid);

    int insert(Holoenterprise record);

    int insertSelective(Holoenterprise record);

    List<Holoenterprise> selectByExample(HoloenterpriseExample example);

    Holoenterprise selectByPrimaryKey(Integer huserid);

    int updateByExampleSelective(@Param("record") Holoenterprise record,
                                 @Param("example") HoloenterpriseExample example);

    int updateByExample(@Param("record") Holoenterprise record,
                        @Param("example") HoloenterpriseExample example);

    int updateByPrimaryKeySelective(Holoenterprise record);

    int updateByPrimaryKey(Holoenterprise record);

    List<LoginInfo> login(Holoenterprise record);
}
