package com.example.coding.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chunchen.huang
 * @description
 * @date 2024-01-24 17:21:02
 */
public class test {

    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Vol1(), "A");
        Thread b = new Thread(new Vol2(), "B");
        a.start();
        b.start();
    }

    public static class Syn implements Runnable{

        private int num = 0;

        @Override
        public void run() {
            while (true){
                synchronized (this){
                    notify();
                    if (num <= 99){
                        System.out.println("线程" + Thread.currentThread().getName() + ":" + num);
                        num++;
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        break;
                    }
                }
            }
        }
    }


    public static class Loc implements Runnable{

        private Lock lock =  new ReentrantLock();

        private Condition condition = lock.newCondition();


        private int num = 0;

        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    condition.signal();
                    if (num <= 99){
                        System.out.println("线程" + Thread.currentThread().getName() +":" + num);
                        num++;
                    }else {
                        break;
                    }
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }

        }
    }


    static class Vol1 implements Runnable{
        @Override
        public void run() {
            int num = 0;
            while (true){
                if (num<=99){
                    if (flag){
                        System.out.println("线程" + Thread.currentThread().getName() + ":" + num);
                    }
                    flag = false;
                    num+=2;
                }
            }
        }
    }

    static class Vol2 implements Runnable{

        @Override
        public void run() {
            int num = 1;
            while (true){
                if (num <=99){
                    if (!flag){
                        System.out.println("线程" + Thread.currentThread().getName() + ":" + num);
                    }
                    flag=true;
                    num+=2;
                }
            }
        }
    }


}
