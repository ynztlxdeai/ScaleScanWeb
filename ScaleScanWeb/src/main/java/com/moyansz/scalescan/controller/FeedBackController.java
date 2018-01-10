package com.moyansz.scalescan.controller;

import com.moyansz.common.BestEduUtil;
import com.moyansz.common.JSONUtils;
import com.moyansz.file.JsonFileUtil;
import com.moyansz.file.ZipUtils;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.feedback.FeedBackBean;
import com.moyansz.scalescan.po.result.CommBean;

import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.scalescan.controller
 * className:	        FeedBackController
 * author:	            Luoxiang
 * time:	            2017/6/29	15:23
 * desc:	            意见反馈收集
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/29
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("feedback")
public class FeedBackController {

    @RequestMapping("sugestion")
    public @ResponseBody
    CommBean feedBack(String contract , String content , MultipartHttpServletRequest multipartHttpServletRequest,
                      HttpSession session , String hmobilenum){
        CommBean commBean = new CommBean();

        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(contract)){
            commBean.setCode(ConstantsErrorCode.FEED_BACK_ERROR);
            commBean.setMsg(ConstantsErrorMsg.FEED_BACK_ERROR);
            return commBean;
        }

        FeedBackBean feedBackBean = new FeedBackBean();
        feedBackBean.setContent(content);
        feedBackBean.setContract(contract);
        feedBackBean.setPhone(hmobilenum);

        String realPath = session.getServletContext()
                                 .getRealPath("/feedback");

        if (multipartHttpServletRequest != null){
            CommonsMultipartFile uploadFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile(
                    "fileName");

            File file = new File(realPath, BestEduUtil.getGuid());
            if (!file.exists())
            {
                file.mkdirs();
            }


            if (uploadFile  != null){
                String               filename   = uploadFile.getOriginalFilename();
                File zipfile = null;
                try {
                    zipfile = new File(file , filename);
                    uploadFile.transferTo(zipfile);
                    ZipUtils.unZipFiles(zipfile , file.getPath());
                    feedBackBean.setParentPath(file.getPath());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    uploadFile = null;
                    if (zipfile != null && zipfile.exists()){
                        zipfile.delete();
                    }
                }
            }
        }

        String result = JSONUtils.toJSONObject(feedBackBean)
                                 .toString();
        File jsonFile = new File(new File(realPath) , System.currentTimeMillis() + ".json");
        try {
            JsonFileUtil.writeFile(jsonFile , result);
            commBean.setCode(ConstantsErrorCode.SUCCESS);
        } catch (IOException e) {
            commBean.setCode(ConstantsErrorCode.FEED_BACK_ERROR);
            commBean.setMsg(ConstantsErrorMsg.FEED_BACK_ERROR);
            e.printStackTrace();
        }

        return commBean;
    }
}
