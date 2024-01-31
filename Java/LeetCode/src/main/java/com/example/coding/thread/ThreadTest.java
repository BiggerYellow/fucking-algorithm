package com.example.coding.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chunchen.huang
 * @description 生产者消费者示例
 * 1.首先进入消费者线程，消费者获得锁后发现无消息消费，进行等待释放锁
 * 2.然后生产者线程获取锁后生产消息即将flag设置为true，唤醒消费者，自己流程走完释放锁
 * 3.最终消费者唤醒后消费消息执行结束
 * @date 2023-12-28 20:07:58
 */
public class ThreadTest {

    static final Object obj = new Object();

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread consume = new Thread(new Consume(), "Consume");
        Thread produce = new Thread(new Produce(), "Produce");

        consume.start();
        Thread.sleep(1000);
        produce.start();
    }

    static class Produce implements Runnable{

        @Override
        public void run() {
            synchronized (obj){
                System.out.println("进入生产者线程");
                System.out.println("生产");
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                    flag = true;
                    //唤醒线程
                    obj.notify();
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("退出生产者线程");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consume implements Runnable{

        @Override
        public void run() {
            synchronized(obj){
                System.out.println("进入消费者线程");
                System.out.println("wait flag1 is " + flag);
                while (!flag){
                    try {
                        System.out.println("还没生产进入等待");
                        //线程等待 释放锁  sleep不释放锁
                        obj.wait();
                        System.out.println("等待结束");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("wait flag2 is " + flag);
                System.out.println("消费");
                System.out.println("退出消费者线程");
            }
        }
    }
}
