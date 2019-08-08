package com.liyao.common.util;
import java.io.File;

/**
 * 文件工具类
 *
 */
public class FileUtil {
    /**
     * 创建目录
     * @param filePath
     */
    public static void createFilePath(String filePath){
        File file = new File(filePath);
        if(!pathExists(file)){
            //如果路径不存在,创建路径
            file.mkdirs();
        }
    }

    /**
     * 判断文件夹是否存在
     * @param file
     * @return
     */
    public static boolean pathExists(File file ){
        if(!file.isDirectory()){
            return false;
        }
        if(!file.exists()){
            return false;
        }
        return true;
    }
}
