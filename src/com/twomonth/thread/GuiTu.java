package com.twomonth.thread;

public class GuiTu {
    public static void main(String[] args) {

        my12306 My123 = new my12306();
        Thread threadpiao1 = new Thread(My123, "林通");
        Thread threadpiao2 = new Thread(My123, "学昌");
        Thread threadpiao3 = new Thread(My123, "张瑞");

        threadpiao1.start();
        threadpiao2.start();
        threadpiao3.start();


//        Runner runner = new Runner(150);
//        Thread thread1 = new Thread(runner, "乌龟");
//        Thread thread2 = new Thread(runner,"兔子");
//        thread1.start();
//        thread2.start();
    }
}

class my12306 implements Runnable{
    private int piao = 99;
    @Override
    public void run() {
        while (piao>0){
            System.out.println(Thread.currentThread().getName()+"===>"+piao);
            piao--;
        }
    }
}

class Runner implements Runnable{
    private int step;
    public Runner(int step) {
        this.step = step;
    }
    boolean gameing = true;

    @Override
    public void run() {
        for (int i = 0; i <= step; i++) {
            if (gameing){
                System.out.println(Thread.currentThread().getName()+"===>"+i);
                if (i==step){
                    gameing = false;
                    System.out.println(Thread.currentThread().getName()+"是胜利者！！！");
                }
            }else {
                break;
            }
        }
    }
}
