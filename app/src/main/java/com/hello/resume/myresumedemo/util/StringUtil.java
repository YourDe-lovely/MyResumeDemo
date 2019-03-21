package com.hello.resume.myresumedemo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    /**
     *   去除字符串中的特殊符号
     * @param barcode
     * @return
     */
    public static String removeSpecialCharacter(String barcode){
        String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(barcode);
        return m.replaceAll("").trim().toString();
    }


    /**
     *  提取字符创中的数字
     * @param str
     * @return
     */
    public static String test13(String str) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        String result = m.replaceAll("").trim();
        return result ;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
