package com.twomonth.builder;

public class Test {
    public static void main(String[] args) {
        Fu fu = new Zi();
        System.out.println(fu.age);
        System.out.println();
        fu.fun();
    }
}

class Fu{
    int age = 30;
    public void fun(){
        System.out.println("我是你爸爸");
    }
}

class Zi extends Fu{
    int age = 5;
    boolean argue;
    public void fun(){
        System.out.println("我是儿子");
    }

    boolean getArgue(){
        return this.argue;
    }
}
