package com.example.coding.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chunchen.huang
 * @description https://zhuanlan.zhihu.com/p/370130458
 * @date 2023-12-27 19:47:51
 */
public class print100 {

    public static volatile int flag = 0;
    public static void main(String[] args) {


//        CountThread4Synchronized count = new CountThread4Synchronized();
//        Thread thread1 = new Thread(count, "1");
//        Thread thread2 = new Thread(count, "2");
//        //线程进入就绪状态（READY）
//        thread1.start();
//        thread2.start();
//        CountThread4ReenTrantLock countThread4ReenTrantLock = new CountThread4ReenTrantLock();
//        Thread thread3 = new Thread(countThread4ReenTrantLock, "3");
//        Thread thread4 = new Thread(countThread4ReenTrantLock, "4");
//        thread3.start();
//        thread4.start();
        Thread thread5 = new Thread(new CountThread4Volatile1(), "1");
        Thread thread6 = new Thread(new CountThread4Volatile2(), "2");
        thread5.start();
        thread6.start();
    }

    /**
     * 使用synchronized
     */
    static class CountThread4Synchronized implements Runnable{

        private int i=0;


        @Override
        public void run() {
            while (true){
                synchronized (this){
                    System.out.println("进入 Thread" + Thread.currentThread().getName());

                    //唤醒线程，获取的锁的线程会从暂停的地方继续执行
                    notify();
                    System.out.println("notify Thread" + Thread.currentThread().getName());
                    //若i小于100直接打印并++，超过100直接退出
                    if (i<100){
                        i++;
                        System.out.println("Thread" + Thread.currentThread().getName() +  ":" + i);
                    }else {
                        break;
                    }
                    //i小于100直接wait方法阻塞线程，另一个线程直接
                    try {
                        System.out.println("准备 wait Thread" + Thread.currentThread().getName());
                        //暂停线程，线程进入waiting状态，会释放锁
                        wait();
                        System.out.println("结束 wait Thread" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    /**
     * 使用ReentrantLock
     */
    static class CountThread4ReenTrantLock implements Runnable{

        private int i=0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        @Override
        public void run() {
            while (true){
                lock.lock();
                try {
                    condition.signal();
                    if (i<100){
                        i++;
                        System.out.println("线程"+Thread.currentThread().getName()+":"+i);
                    }else {
                        break;
                    }
                    condition.await();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }
            }
        }
    }

    static class CountThread4Volatile1 implements Runnable{
        //偶数线程
        @Override
        public void run() {
            int i=-2;
            while (i<=99){
                if (flag == 0){
                    i+=2;
                    System.out.println("线程"+Thread.currentThread().getName()+":"+i);
                    flag = 1;
                }
            }
        }
    }

    static class CountThread4Volatile2 implements Runnable{
        //奇数线程
        @Override
        public void run() {
            int i=-1;
            while (i<=98){
                if (flag == 1){
                    i+=2;
                    System.out.println("线程" + Thread.currentThread().getName()+":"+i);
                    flag=0;
                }
            }
        }
    }
}


