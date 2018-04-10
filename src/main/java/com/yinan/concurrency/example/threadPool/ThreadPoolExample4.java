package com.yinan.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.schedule(() -> log.warn("schedule run"), 3, TimeUnit.SECONDS);

        executorService.scheduleAtFixedRate((Runnable) () -> {
            log.warn("schedule run");
        }, 1, 3, TimeUnit.SECONDS);
//        executorService.shutdown();
    }
}
