package com.twomonth.io;

import java.io.File;

public class DirDemo1 {
    public static void main(String[] args) {
        File file = new File("/Users/wangjianchao/WorkSpace/TJZX_OA_ANDROID/TianJinOALauncher/app/src");
        getAllFileName(file,1);
    }

    /**
     * 递归查找子目录以及文件
     */
    public static void getAllFileName(File file,int deep){
        if (file == null || !file.exists()){
            System.out.println("文件或者文件夹不存在");
            return;
        }
        //判断是不是文件夹
        if (file.isDirectory()){
//            for (int i = 0; i < deep; i++) {
//                System.out.print("*");
//            }
            System.out.println(file.getAbsolutePath());
            for (File file1:file.listFiles()){
                getAllFileName(file1,deep+1); //每深入一层deep+1
            }
        }else {
//            for (int i = 0; i < deep; i++) {
//                System.out.print("-");
//            }
            System.out.println(file.getName());
        }

    }
}
