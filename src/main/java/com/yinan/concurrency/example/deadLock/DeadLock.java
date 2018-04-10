package com.yinan.concurrency.example.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * 一个简单的死锁类
 * 当DeadLock类的对象flag==1时（dl1）， 先锁定o1，睡眠500毫秒
 * 而dl1在睡眠的时候另一个flag==0的对象线程启动（dl2），先锁定o2，睡眠500毫秒
 * dl1睡眠结束后需要锁定o2才能继续执行，而此时o2已被dl2锁定；
 * dl2睡眠结束后需要锁定o1才能继续执行，而此时o1已被dl1锁定；
 * sl1、sl2相互灯带，都需要得到对方锁定的资源才能继续执行，从而死锁。
 */
@Slf4j
public class DeadLock implements Runnable {
    public int flag = 1;

    private static Object o1 = new Object(), o2 = new Object();


    @Override
    public void run() {
        log.info("flag: {}", flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    log.info("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock dl1 = new DeadLock();
        DeadLock dl2 = new DeadLock();
        dl1.flag = 1;
        dl2.flag = 0;

        new Thread(dl1).start();
        new Thread(dl2).start();
    }

}
