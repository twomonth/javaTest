package com.twomonth.io;

import java.io.*;

public class FileInputStreamDemo1 {
    public static InputStream fileInputStreamDemo1;
    public static void main(String[] args) {
        File file = new File("D:\\javaWorkSpase\\javaTest\\src\\com\\twomonth\\io\\IO基础知识.md");
        try {
            fileInputStreamDemo1 = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len=fileInputStreamDemo1.read(bytes)) != -1){
                System.out.print(new String(bytes,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStreamDemo1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
