package com.moyansz.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * projectName: 	    ScaleScanWeb
 * packageName:	        com.moyansz.file
 * className:	        JsonFileUtil
 * author:	            Luoxiang
 * time:	            2017/6/29	15:56
 * desc:	            TODO
 *
 * svnVersion:	        $Rev
 * upDateAuthor:	    Vincent
 * upDate:	            2017/6/29
 * upDateDesc:	        TODO
 */


public class JsonFileUtil {

    //把json格式的字符串写到文件
    public static void writeFile(File filePath, String sets) throws IOException {
        FileWriter  fw  = new FileWriter(filePath);
        PrintWriter out = new PrintWriter(fw);
        out.write(sets);
        out.println();
        fw.close();
        out.close();
    }
}
