package com.hello.resume.myresumedemo.util;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  保存日志
 */
public class LogSaveUtils {

    private static SimpleDateFormat mSdf = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat mSdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *  保存日志到本地存储路径
     * @param message   保存信息
     * @param name      保存文件名
     */
    public static void saveCrashInfo2File(String message  , String name) {

        StringBuffer sb = new StringBuffer();
        //记录时间
        Date now = new Date();
        sb.append("\n"+"\n"+"\n"+ mSdf.format(now));
        sb.append("\n"+ message);
        try {
            String fileName = name + mSdf2.format(now) + ".log";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String path = Environment.getExternalStorageDirectory().getPath() + "/mcs/log/";
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(path + fileName, true);
                fos.write(sb.toString().getBytes());
                fos.close();
            }
        } catch (Exception e) {
        }
    }
}
