package com.moyansz.scalescan.service.impl;

import com.moyansz.scalescan.mapper.HolomodlefileMapper;
import com.moyansz.scalescan.po.Holomodlefile;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.service.ModlefileService;

import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.service.impl
 * className:	        ModlefileServiceImpl
 * author:	            Luoxiang
 * time:	            2017/5/11	16:13
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/11
 * upDateDesc:	        TODO
 */

@Service
public class ModlefileServiceImpl
        implements ModlefileService
{

    @Resource
    private HolomodlefileMapper holomodlefileMapper;

    @Override
    public void insert(Holomodlefile modlefileVo) {
        holomodlefileMapper.insertSelective(modlefileVo);
    }

    /**
     * 通过名字模糊查询
     * @param fileName 查询名字
     * @return
     */
    @Override
    public CommBean selectModle(String fileName) {
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(fileName)) {
            commBean.setCode(ConstantsErrorCode.FILE_NAME_FORMAT_ERROR);
            commBean.setMsg(ConstantsErrorMsg.FILE_NAME_FORMAT_ERROR);
            return commBean;
        }

        List<Holomodlefile> holomodlefiles = holomodlefileMapper.selectByModlePath(fileName);

        if (holomodlefiles != null && holomodlefiles.size() > 0) {
            commBean.setCode(ConstantsErrorCode.SUCCESS);
            commBean.setMsg(holomodlefiles.get(0)
                                          .getModlepath());
        } else {
            commBean.setCode(ConstantsErrorCode.FILE_NOT_EXISTS);
            commBean.setMsg(ConstantsErrorMsg.FILE_NOT_EXISTS);
        }

        return commBean;
    }

    /**
     * 查询数据库记录
     * @param filename 模糊查询模型名字
     * @param userid 匹配userid
     * @return 返回常规格式
     */
    @Override
    public CommBean selectByNameAndUserid(String filename, Integer userid) {
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(filename)) {
            commBean.setCode(ConstantsErrorCode.FILE_NAME_FORMAT_ERROR);
            commBean.setMsg(ConstantsErrorMsg.FILE_NAME_FORMAT_ERROR);
            return commBean;
        } else if (userid == null) {
            commBean.setCode(ConstantsErrorCode.PASSID_ERROR);
            commBean.setMsg(ConstantsErrorMsg.PASSID_ERROR);
            return commBean;
        }

       /* HolomodlefileExample example = new HolomodlefileExample();
        HolomodlefileExample.Criteria criteria = example.createCriteria();
        criteria.andFkuseridEqualTo(userid);
        criteria.andModlepathLike(filename);*/
        Holomodlefile holomodlefile = new Holomodlefile();
        holomodlefile.setModlepath(filename);
        holomodlefile.setFkuserid(userid);
        List<Holomodlefile> holomodlefiles = holomodlefileMapper.selectByNameAndUserid(holomodlefile);
        if (holomodlefiles != null && holomodlefiles.size() > 0) {
            commBean.setCode(ConstantsErrorCode.SUCCESS);
            commBean.setMsg(holomodlefiles.get(0)
                                          .getModlepath());
        } else {
            commBean.setCode(-1);
        }

        return commBean;
    }
}

