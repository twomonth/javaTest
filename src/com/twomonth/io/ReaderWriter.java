package com.twomonth.io;

import java.io.*;

/**
 * 文件流和字节流操作是一样的，只不过flush 变成了一个 char[] 数组。
 */

public class ReaderWriter {

    public static void main(String[] args) {
        copy("D:\\H5\\java_IO.md","java.md");
    }

    public static void copy(String srcFrom,String srcTo){
        Reader inputStream = null;
        Writer outputStream = null;

        File fileFrom = new File(srcFrom);
        File fileTo = new File(srcTo);
        try {
            inputStream = new FileReader(fileFrom);
            outputStream = new FileWriter(fileTo);
            char[] flush = new char[1024*10];
            int len;
            while ((len = inputStream.read(flush)) != -1){
                outputStream.write(flush,0,len);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
