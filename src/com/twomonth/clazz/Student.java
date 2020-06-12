package com.twomonth.clazz;

public class Student {

    private String name;
    private int age;
    private char sex;

    Student(){

    }

    Student(String name){

    }

    @MyAnnotation("abc")
    public int sum(int a , int b){
        return a+b;
    }

    public void say(){
        System.out.println("偷偷说老师坏话。");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
