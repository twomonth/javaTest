package com.twomonth.thread;

import java.util.ArrayList;

/**
 * 多线程三大案例，购买火车票，账户存取款，list 数据存储造成覆盖。
 *
 *
 */
public class ThreadTest {


    public static void main(String[] args) {
//        Account account = new Account(500,"生活费");
//        new TiKuanJi(account,300,"公").start();
//        new TiKuanJi(account,300,"婆").start();


        //list 数据存储造成覆盖。
        addList();
    }


    /*
    list 数据存储造成覆盖,多条线程同时操作一份存储空间
     */
    public static void addList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                // 添加同步
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //添加同步之后主线程等待 同步块中所有子线程结束之后在显示，才是正确的
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("list长度"+list.size());

    }

}

/**
 * 账户取款问题
 */
class Account{
    public int money;
    public String accountName;
    public Account(int money,String accountName){
        this.money = money;
        this.accountName = accountName;
    }
}

class TiKuanJi extends Thread{
    Account account;
    int getMoney;

    public TiKuanJi(Account account,int getMoney,String name){
        super(name);
        this.account = account;
        this.getMoney = getMoney;
    }
    @Override
    public void run() {
        test();
    }

    // 如果在这里加上synchronized 那么锁是加在提款机上的，对操作的账户不起作用，所以不会有效果，也就锁错了地方
    // 目标不对，锁定失败，这里不是锁this 应该锁 Account
    public synchronized void test(){

        /**
         * 这里是中带你，能使代码进一步优化，在等待拿到线程锁之前进行判断，发现金额不支持提出了，等待锁的过程也可以省略，
         * 这样使 效率 更高。
         * 所谓的性能，就是通过这样的小细节 调优的。
         */
        if (account.money<=0){
            return;
        }

        //添加同步块
        synchronized (account){
            if (account.money - getMoney <0){
                System.out.println("账户余额不足");
                return;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= getMoney;
            System.out.println(Thread.currentThread().getName()+"取走了："+getMoney);
            System.out.println("账户余额："+account.money);
        }
    }
}
