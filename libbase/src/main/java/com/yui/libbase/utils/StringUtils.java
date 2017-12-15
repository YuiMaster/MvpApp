package com.yui.libbase.utils;

/**
 * Created by Jane on 2017/11/21.
 */

public class StringUtils {


    /**
     * 字符串为空
     *
     * @param str
     *
     * @return true 空  false 不为空
     */
    public static boolean isStringEmpty(String str) {
        return (str == null) || ("".equals(str));
    }

}
