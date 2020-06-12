package com.twomonth.io;

public class TestString {



    public static void main(String[] args) {

        String string = "Hello World!";
        String string2 = new String("abc");

        //1.获取字符串长度
        string.length();
        //2.截取一个字符
        string.charAt(0);
        //3.替代getChars()的一种方法是将字符存储在字节数组中，该方法即getBytes()
        byte[] bytes = string.getBytes();
        //4.转换成字符数组
        char[] chars = string.toCharArray();
        //5.判断字符串开始和结束
        boolean h = string.startsWith("H");
        boolean b = string.endsWith("World!");
        //6.indexOf() 查找字符或者子串第一次出现的地方。
        int e = string.indexOf('e');
        //7.lastIndexOf() 查找字符或者子串是后一次出现的地方
        int o = string.lastIndexOf('o');
        //8.截取字符串
        String substring = string.substring(1);//指定位置到结束
        String substring1 = string.substring(1, 3);//指定位置到指定位置,结果"el"
        //9.替换(这个替换是全部的)。
        String replace = string.replace('o', 'z');
        //10.连接两个字符串
        String concat = string.concat(string2);
        //11.去掉起始和结尾的空格
        String trim = string.trim();
        //12.将基础数据类型转换为字符串类型
        String s = String.valueOf(333);
        //13.大小写转换
        string.toLowerCase();
        string.toUpperCase();


        System.out.println(trim);
        System.out.println(substring1);
        System.out.println("".hashCode());
//        equals he  equalsIgnoreCase() he ==
    }
}
