package com.twomonth.thread;

/**
 * 守护线程：是为用户线程提供服务的，jvm停止的时候不用等待 守护线程执行完毕。
 * 默认：用户线程，jvm会等待用户线程执行完毕才会停止。
 */
public class DaemonTest {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();

        //将god 线程提升为守护线程，虚拟机就不会在它执行完成之后才结束。设置必须在start 之前
        god.setDaemon(true);
        god.start();
        you.start();
        god.isAlive();//查看线城市不是还活着。
    }
}

class You extends Thread{
    @Override
    public void run() {
        for (int i = 0; i <365*100; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }
    }
}

class God extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"--->"+"守护");
        }
    }
}
