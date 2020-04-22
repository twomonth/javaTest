package com.twomonth.io;

import java.io.*;

public class OutputStreamDemo1 {

    public static void main(String[] args) {
        File file = new File("OutDemo.txt");
        if (file.exists()){
            System.out.println("首次进入创建文件");
            file.mkdirs();
        }
        try {
            OutputStream outputStream = new FileOutputStream(file,true);//控制追加还是覆盖
            String str = "大家好我叫王建朝！";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
