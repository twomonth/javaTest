package com.twomonth.thread;

public class NoSynchronized {
    public static void main(String[] args) {
        ChePiao chePiao = new ChePiao();
        Thread thread1 = new Thread(chePiao, "林通");
        Thread thread2 = new Thread(chePiao, "林四");
        Thread thread3 = new Thread(chePiao, "林十");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ChePiao implements Runnable {

    private int tick = 200;
    private boolean flag = true;

    //用 synchronized 修饰run方法 可以实现同步锁，保证不会出现重复购票和出现负数。
    //synchronized 使用的时候，锁的是一个不变的对象，购买火车票的时候，锁火车票是不行的
    //这里如果使用同步代码块实现封装的话，锁的是 this
    @Override
    public void run() {
//        while (tick > 0) {
//            try {
//                Thread.sleep(100);
//                System.out.println(Thread.currentThread().getName() + "--->" + tick);
//                tick--;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        while (flag){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            test();
        }
    }
    //尽可能锁定合理范围，不是指代码，是指数据完整性。
    //这里使用了 double checking (双重检测)
    public void test() {
        //考虑没有票的情况
        if (tick <= 0) {
            return;
        }
        synchronized (this) {
            //考虑最后一张票的情况
            if (tick<=0){
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + "--->" + tick);
            tick--;
        }
    }
}
