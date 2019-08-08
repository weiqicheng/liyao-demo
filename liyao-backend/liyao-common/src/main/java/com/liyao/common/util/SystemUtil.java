package com.liyao.common.util;


import java.util.Properties;

/**
 * Java的System类封装工具类。
 *
 * @author weimaomao
 */
public final class SystemUtil {
    /**
     * 判断系统是否是linux系统
     *
     * @return
     */
    public static boolean isOSLinux() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        if (os != null && os.toLowerCase().indexOf("linux") > -1) {
            return true;
        } else {
            return false;
        }
    }

}