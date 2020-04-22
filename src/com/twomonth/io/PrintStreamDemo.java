package com.twomonth.io;

import java.io.*;

/**
 * 打印流
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {


        PrintStream printStream = System.out;
        printStream.println("String");

        //打印流属于工具流，可以传入一个文件流输出到文件
        FileOutputStream fileOutputStream = new FileOutputStream("wenben.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        PrintStream printStream1 = new PrintStream(bufferedOutputStream,true);//true  和flush的作用一样
        printStream1.println("nihao zhou jie lun wo 交 王建朝");
        printStream1.flush();// 注意 有时候缓冲流缓冲区比较大，数据海尔米有沾满，所以需要手动 flush 否则看不到效果

        //重定向输出端
        System.setOut(printStream1);
        System.out.println("kankan 是不是换地方输出了！");
        //重定向回到控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("en ,我回来了！");
    }
}
