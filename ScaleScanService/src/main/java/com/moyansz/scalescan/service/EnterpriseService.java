package com.moyansz.scalescan.service;

import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.HoloenterpriseVo;
import com.moyansz.scalescan.po.vo.LoginInfo;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service
 * className:	        EnterpriseServiceImpl
 * author:	            Luoxiang
 * time:	            2017/5/9	17:44
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/9
 * upDateDesc:	        TODO
 */

public interface EnterpriseService {
    CommBean<LoginInfo> regist(HoloenterpriseVo holoenterpriseVo);

    CommBean forgetPwd(HoloenterpriseVo holoenterpriseVo);

    CommBean<LoginInfo> login(HoloenterpriseVo holoenterpriseVo);

    CommBean checkPhone(String phone, String countryArea);

    CommBean updateUsername(HoloenterpriseVo holoenterpriseVo);

    CommBean updateDesc(HoloenterpriseVo holoenterpriseVo);

    void updatePic(Holoenterprise holoenterprise);

    CommBean logout(HoloenterpriseVo holoenterpriseVo);
}
