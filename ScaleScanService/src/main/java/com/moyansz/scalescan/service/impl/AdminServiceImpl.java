package com.moyansz.scalescan.service.impl;

import com.moyansz.common.BestEduUtil;
import com.moyansz.scalescan.mapper.HoloadminMapper;
import com.moyansz.scalescan.mapper.HolosecretkeysMapper;
import com.moyansz.scalescan.po.Holoadmin;
import com.moyansz.scalescan.po.HoloadminExample;
import com.moyansz.scalescan.po.Holosecretkeys;
import com.moyansz.scalescan.po.result.CommBean;
import com.moyansz.scalescan.po.vo.back.HoloadminVo;
import com.moyansz.scalescan.service.AdminService;
import org.apache.http.util.TextUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.scalescan.service.impl
 * className:	        AdminServiceImpl
 * author:	            Luoxiang
 * time:	            2017/6/19	14:50
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/19
 * upDateDesc:	        TODO
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private HoloadminMapper holoadminMapper;

    @Resource
    private HolosecretkeysMapper holosecretkeysMapper;

    @Override
    public CommBean login(HoloadminVo holoadminVo, String contextPath) {
        CommBean commBean = new CommBean();
        if (TextUtils.isEmpty(holoadminVo.getPassword()) || holoadminVo.getPassword().length() < 6 || holoadminVo.getPassword().length() > 24){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\""+contextPath + "/admin/index\">密码为空或格式不正确</a>");
            return commBean;
        }
        if (TextUtils.isEmpty(holoadminVo.getSecretCode()) || holoadminVo.getSecretCode().length() < 6 || holoadminVo.getSecretCode().length() > 12){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\""+contextPath + "/admin/index\">密钥为空或格式不正确</a>");
            return commBean;
        }
        if (TextUtils.isEmpty(holoadminVo.getUsername()) || holoadminVo.getUsername().length() < 5 || holoadminVo.getUsername().length()>24){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\"" + contextPath + "/admin/index\">用户名为空或格式不正确</a>");
            return commBean;
        }

        HoloadminExample holoadmin = new HoloadminExample();
        HoloadminExample.Criteria criteria = holoadmin.createCriteria();
        criteria.andAdminpwdEqualTo(holoadminVo.getPassword());
        criteria.andAdminsecretEqualTo(holoadminVo.getSecretCode());
        criteria.andAdminuserEqualTo(holoadminVo.getUsername());

        List<Holoadmin> holoadmins = holoadminMapper.selectByExample(holoadmin);
        if (holoadmins != null && holoadmins.size() > 0){
            commBean.setCode(0);
        }
        return commBean;
    }

    @Override
    public CommBean createSecretCode(int number, int category, String path , String filePath) {
        CommBean commBean = new CommBean();
        if (number <= 0){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\""+path + "/admin/secret\">数量输入错误</a>");
            return commBean;
        }
        if (category != 1 && category != 2){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\""+path + "/admin/secret\">用户类型错误</a>");
            return commBean;
        }
        ArrayList<String> arrayList = new ArrayList<>(number);
        Holosecretkeys record = null;
        for (int i = 0; i < number; i++) {
            try {
                record = new Holosecretkeys();
                record.setCategory(category);
                if (category == 2){
                    record.setMaxusers(20);
                }else {
                    record.setMaxusers(1);
                }
                String guid = BestEduUtil.getGuid();
                record.setSecretkey(guid);
                holosecretkeysMapper.insert(record);
                arrayList.add(guid);
            }catch (Exception e){
                i--;
                e.printStackTrace();
            }
        }


        int position = 0;
        try {
            // create a new file
            File file = new File(filePath , System.currentTimeMillis() + ".xls");
            if (!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            FileOutputStream out  = new FileOutputStream(file);
            // create a new workbook
            Workbook wb = new HSSFWorkbook();
            // create a new sheet
            Sheet s = wb.createSheet();
            // declare a row object reference
            Row r = null;
            // declare a cell object reference
            Cell c = null;
            // create 1 cell styles
            CellStyle cs = wb.createCellStyle();
            // create 2 fonts objects
            Font f  = wb.createFont();
            //set font 1 to 12 point type
            f.setFontHeightInPoints((short) 12);
            //arial is the default font
            f.setBoldweight(Font.BOLDWEIGHT_BOLD);
            //set cell stlye
            cs.setFont(f);
            wb.setSheetName(0 , "sheet1");
            int maxCellNum = 1;
            int rownum = arrayList.size() / maxCellNum;
            if (arrayList.size() % maxCellNum != 0){
                rownum++;
            }
            for (int i = 0; i < rownum; i++) {
                // create a row
                r = s.createRow(i);
                for (short cellnum = (short) 0; cellnum < maxCellNum; cellnum ++) {
                    c = r.createCell(cellnum);
                    c.setCellValue(arrayList.get(position++));
                    // make this column a bit wider
                    s.setColumnWidth((short) (cellnum + 1), (short) ((50 * 8) / ((double) 1 / 20)));
                }
            }
            // write the workbook to the output stream
            // close our file (don't blow out our file handles
            wb.write(out);
            out.close();
            commBean.setCode(0);
            commBean.setMsg(path + "/secretPath/" + file.getName());
        }catch (Exception e){
            commBean.setCode(-1);
            commBean.setMsg("<a href=\""+path+ "/admin/secret\">生成失败</a>");
            e.printStackTrace();
        }
        return commBean;
    }
}
