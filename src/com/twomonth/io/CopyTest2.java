package com.twomonth.io;

import java.io.*;

/**
 * 缓冲流用于提升速率
 * 事实上就是利用装饰着模式，对性能进行提升，字节缓冲流BuffereadInputStream
 */
public class CopyTest2 {

    public static void main(String[] args) {
        long timeStart = System.currentTimeMillis();
        copy("D:\\BaiduYunDownload\\Visio2013_150904.zip","teeee.zip");
        long timeEnd = System.currentTimeMillis();
        System.out.println("耗时："+(timeEnd-timeStart));
    }

    public static void copy(String srcFrom,String srcTo){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File fileFrom = new File(srcFrom);
        File fileTo = new File(srcTo);
        if (fileTo.exists()){
            fileTo.mkdirs();
        }

        try {
            inputStream = new BufferedInputStream(new FileInputStream(fileFrom));
            outputStream = new BufferedOutputStream(new FileOutputStream(fileTo));
            byte[] flush = new byte[1024*10];
            int len;
            while ((len = inputStream.read(flush)) != -1){
                outputStream.write(flush,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
