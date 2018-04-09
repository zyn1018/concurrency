package com.yinan.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 当synchronized关键字修饰类和静态方法时, 其作用于所有对象
 */
@Slf4j
public class SyncStatic {

    //修饰一个类
    public static void test1(int j) {
        synchronized (SyncStatic.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} -- {}", j, i);
            }
        }
    }

    //修饰一个静态方法
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} -- {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncStatic syncStatic = new SyncStatic();
        SyncStatic syncStatic2 = new SyncStatic();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(
                () -> syncStatic.test1(1));
        executorService.execute(
                () -> syncStatic2.test1(2));
    }
}
