package com.twomonth.thread;

public class CinameDemo {
    public static void main(String[] args) {
        Cinamo cinamo = new Cinamo(20);
        new Thread(new Customer(cinamo,3),"林通").start();
        new Thread(new Customer(cinamo,1),"张瑞").start();
    }
}

class Customer implements Runnable{

    Cinamo cinamo;
    int seats;

    public Customer(Cinamo cinamo, int seats) {
        this.cinamo = cinamo;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinamo){
            boolean flag = cinamo.bookTickets(seats);
            if (flag){
                System.out.println("出票成功："+Thread.currentThread().getName()+"-->"+seats+"张");
            }else {
                System.out.println("出票失败："+Thread.currentThread().getName()+"-->位置不够");
            }
        }
    }
}

class Cinamo{
    private int avilebale;
    private String name = "万达影院";

    public Cinamo(int avilebale) {
        this.avilebale = avilebale;
    }

    public boolean bookTickets(int seats){
        System.out.println("剩余位置："+avilebale);
        if (seats>avilebale){
            System.out.println("剩余票数不够");
            return false;
        }
        avilebale -= seats;
        return true;
    }
}
