package com.moyansz.scalescan.controller;

import com.moyansz.common.BestEduUtil;
import com.moyansz.common.FileUtil;
import com.moyansz.file.ZipUtils;
import com.moyansz.scalescan.po.Holoenterprise;
import com.moyansz.scalescan.po.Holomodlefile;
import com.moyansz.scalescan.po.constants.ConstantsErrorCode;
import com.moyansz.scalescan.po.constants.ConstantsErrorMsg;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.service.EnterpriseService;
import com.moyansz.scalescan.service.ModlefileService;

import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * projectName: 	    ScaleScan
 * packageName:	        com.moyansz.scalescan.controller
 * className:	        UploadController
 * author:	            Luoxiang
 * time:	            2017/5/10	15:35
 * desc:	            所有上传 相关
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/5/10
 * upDateDesc:	        TODO
 */

@Controller
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private ModlefileService modlefileServiceImpl;

    @Resource
    private EnterpriseService enterpriseServiceImpl;

    @RequestMapping("uploadModle")
    public @ResponseBody
    CommBean uploadModleV2(MultipartHttpServletRequest multipartHttpServletRequest,
                           HttpSession session,
                           Integer userid)
    {

        CommonsMultipartFile uploadFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile(
                "fileName");
        String               filename   = uploadFile.getOriginalFilename();


        CommBean commBean = modlefileServiceImpl.selectByNameAndUserid(filename, userid);
        if (commBean.getCode() == ConstantsErrorCode.SUCCESS) {
            //已经存在直接返回
            return commBean;
        } else if (commBean.getCode() == -1) {
            /**
             * 不存在 需要写文件和操作数据库
             */
            String realPath = session.getServletContext()
                                     .getRealPath("/uploadfile");

            // 向下创建4级目录
            String path = FileUtil.getPath(filename, 4);

            File file = new File(realPath, path + filename);
            if (!file.getParentFile()
                     .exists())
            {
                file.getParentFile()
                    .mkdirs();
            }
            File jsonFile = new File(realPath,path+filename.substring(0,filename.lastIndexOf(".zip")) + ".json");
            try {
                //uploadFile.transferTo(file);
                String modlepath = "/uploadfile" + path + jsonFile.getName();
                if (!jsonFile.exists()){
                    ZipUtils.unZip(uploadFile.getInputStream() , jsonFile);
                    Holomodlefile holomodlefile = new Holomodlefile();
                    holomodlefile.setFkuserid(userid);
                    holomodlefile.setUploadtime(new Date());
                    holomodlefile.setModlepath(modlepath);
                    modlefileServiceImpl.insert(holomodlefile);
                }
                commBean.setCode(ConstantsErrorCode.SUCCESS);
                commBean.setMsg(modlepath);

            } catch (Exception e) {
                e.printStackTrace();
                if (jsonFile.exists()){
                    jsonFile.delete();
                }
                commBean.setCode(ConstantsErrorCode.UPLOAD_MODLE_ERROR);
                commBean.setMsg(ConstantsErrorMsg.UPLOAD_MODLE_ERROR);
            }

            return commBean;

        } else {
            //参数校验错误 返回
            return commBean;
        }


    }


    @RequestMapping("uploadPic")
    public @ResponseBody
    CommBean uploadPic(MultipartHttpServletRequest multipartHttpServletRequest,
                       String existsFileName,
                       Integer userid,
                       HttpSession session)
    {
        CommBean commBean = new CommBean();
        if (userid == null) {
            /**
             * 校验是谁发送的
             */
            commBean.setCode(ConstantsErrorCode.LOGIN_TIME_OUT);
            commBean.setMsg(ConstantsErrorMsg.LOGIN_TIME_OUT);
            return commBean;
        }


        try {
            CommonsMultipartFile uploadFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile(
                    "fileName");
            String               filename   = uploadFile.getOriginalFilename();

            // 向下创建4级目录
            String guid = BestEduUtil.getGuid();
            filename = guid + filename.substring(filename.lastIndexOf("."));
            String path = FileUtil.getPath(guid, 4);

            String realPath = session.getServletContext()
                                     .getRealPath("/picfile");
            File file = new File(realPath, path + filename);
            if (!file.getParentFile()
                     .exists())
            {
                /**
                 * 判断父级路径是否存在
                 */
                file.getParentFile()
                    .mkdirs();
            }
            //文件写出
            uploadFile.transferTo(file);

            /**
             * 数据库操作
             */
            Holoenterprise holoenterprise = new Holoenterprise();
            holoenterprise.setHuserid(userid);
            String hentpic1 = "/picfile" + path + filename;
            holoenterprise.setHentpic1(hentpic1);
            enterpriseServiceImpl.updatePic(holoenterprise);
            /**
             * 成功返回0
             * 在消息结果中返回路径
             */
            commBean.setCode(ConstantsErrorCode.SUCCESS);
            commBean.setMsg(hentpic1);

            if (!TextUtils.isEmpty(existsFileName)) {
                File file1 = new File(existsFileName);
                if (file1.exists()) {
                    file1.delete();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            /**
             * 失败
             */
            commBean.setCode(ConstantsErrorCode.UPLOAD_PIC_ERROR);
            commBean.setMsg(ConstantsErrorMsg.UPLOAD_PIC_ERROR);
        }

        return commBean;
    }

    @RequestMapping("checkFile")
    public @ResponseBody
    CommBean checkFile(String fileName) {
        return modlefileServiceImpl.selectModle(fileName);
    }

    /**
     * 专用上传ply文件和ply对应的图片问及那
     * @param multipartHttpServletRequest 文件封装类
     * @param session 用于初始化文件路径
     * @param userid 用户ID
     * @return 常规返回
     */
    @RequestMapping("uploadDir")
    public @ResponseBody
    CommBean uploadDir(MultipartHttpServletRequest multipartHttpServletRequest,
                       HttpSession session,
                       Integer userid){
        CommonsMultipartFile uploadFile = (CommonsMultipartFile) multipartHttpServletRequest.getFile(
                "fileName");
        String               filename   = uploadFile.getOriginalFilename();

        CommBean commBean = modlefileServiceImpl.selectByNameAndUserid(filename, userid);
        if (commBean.getCode() == ConstantsErrorCode.SUCCESS) {
            //已经存在直接返回
            return commBean;
        } else if (commBean.getCode() == -1) {
            /**
             * 不存在 需要写文件和操作数据库
             */
            String realPath = session.getServletContext()
                                     .getRealPath("/uploadfile");

            // 向下创建4级目录
            String path = FileUtil.getPath(filename, 4);

            File file = new File(realPath, path);
            if (!file.exists())
            {
                file.mkdirs();
            }

            System.out.println(file.getAbsolutePath());

            File zipfile = null;
            try {
                zipfile = new File(file , filename);
                uploadFile.transferTo(zipfile);
                ZipUtils.unZipFiles(zipfile , file.getPath());
                String plyName = "";
                for(File fileItem : file.listFiles()){
                    if (fileItem.getName().endsWith(".ply")){
                        plyName = "/uploadfile" + path + fileItem.getName();
                        break;
                    }
                }

                if (!TextUtils.isEmpty(plyName)){
                    Holomodlefile holomodlefile = new Holomodlefile();
                    holomodlefile.setFkuserid(userid);
                    holomodlefile.setUploadtime(new Date());
                    holomodlefile.setModlepath(plyName);
                    modlefileServiceImpl.insert(holomodlefile);
                    commBean.setCode(ConstantsErrorCode.SUCCESS);
                    commBean.setMsg(plyName);
                }else {
                    commBean.setCode(ConstantsErrorCode.UPLOAD_MODLE_ERROR);
                    commBean.setMsg(ConstantsErrorMsg.UPLOAD_MODLE_ERROR);
                }
            } catch (Exception e) {
                e.printStackTrace();
                commBean.setCode(ConstantsErrorCode.UPLOAD_MODLE_ERROR);
                commBean.setMsg(ConstantsErrorMsg.UPLOAD_MODLE_ERROR);
            }finally {
                uploadFile = null;
                if (zipfile != null && zipfile.exists()){
                    //zipfile.delete();
                }
            }

            return commBean;

        } else {
            //参数校验错误 返回
            return commBean;
        }
    }
}
