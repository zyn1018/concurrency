package com.yinan.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 当synchronized关键字修饰代码块和方法时, 其作用于调用对象
 */
@Slf4j
public class SyncBlockAndMethod {

    //修饰一个代码块
    public void test1(int j) {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} -- {}", j, i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} -- {}", j, i);
        }
    }

    public static void main(String[] args) {
        SyncBlockAndMethod syncBlockAndMethod = new SyncBlockAndMethod();
        SyncBlockAndMethod syncBlockAndMethod2 = new SyncBlockAndMethod();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(
                () -> syncBlockAndMethod.test2(1));
        executorService.execute(
                () -> syncBlockAndMethod2.test2(2));
    }
}
