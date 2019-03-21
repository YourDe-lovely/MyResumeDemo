package com.hello.resume.myresumedemo.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 *  异常信息打印
 */
public class ExceptionPrintUtils {


    /**
     *  打印异常信息保存到本地
     * @param e
     * @param name  文件名
     */
    private static void saveException2File(Exception e , String name){
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw,true));
        String message = sw.toString();

        LogSaveUtils.saveCrashInfo2File(message, name);
    }


}
