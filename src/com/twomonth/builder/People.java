package com.twomonth.builder;

public class People {
    private final String name;
    private final String sex;
    private final String shengao;
    private final String tizhong;
    private final int age;
    private final String work;
    private final String like;
    private final boolean hunfou;

    private People(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.shengao = builder.shengao;
        this.tizhong = builder.tizhong;
        this.age = builder.age;
        this.work = builder.work;
        this.like = builder.like;
        this.hunfou = builder.hunfou;
    }

    public static class Builder{
        private final String name;
        private final String sex;
        private String shengao;
        private String tizhong;
        private int age;
        private String work;
        private String like;
        private boolean hunfou;

        public Builder(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public Builder setShengao(String shengao){
            this.shengao = shengao;
            return this;
        }

        public Builder setTizhong(String tizhong){
            this.tizhong = tizhong;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setWork(String work){
            this.work = work;
            return this;
        }

        public Builder setLike(String like){
            this.like = like;
            return this;
        }

        public Builder setHunfou(Boolean hunfou){
            this.hunfou = hunfou;
            return this;
        }

        public People builder(){
            return new People(this);
        }
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", shengao='" + shengao + '\'' +
                ", tizhong='" + tizhong + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", like='" + like + '\'' +
                ", hunfou=" + hunfou +
                '}';
    }
}
