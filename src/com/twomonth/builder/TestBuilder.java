package com.twomonth.builder;

public class TestBuilder {
    public static void main(String[] args) {
        People people = new People.Builder("林通","男")
                .setAge(28)
                .setHunfou(false)
                .setLike("吹牛逼")
                .setShengao("170")
                .setWork("程序员")
                .setTizhong("125")
                .builder();
        System.out.println(people.toString());

        People lwr = new People.Builder("林婉儿","女").builder();
        System.out.println(lwr.toString());
    }
}
