package com.yinan.concurrency.example.atomic;

import com.yinan.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicRefFieldUpdater {
    private static final AtomicIntegerFieldUpdater<AtomicRefFieldUpdater> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicRefFieldUpdater.class, "count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] args) {
        AtomicRefFieldUpdater atomicRefFieldUpdater = new AtomicRefFieldUpdater();
        if (updater.compareAndSet(atomicRefFieldUpdater, 100, 120)) {
            log.info("update success 1, {}", atomicRefFieldUpdater.getCount());
        }

        if (updater.compareAndSet(atomicRefFieldUpdater, 100, 120)) {
            log.info("update success 2, {}", atomicRefFieldUpdater.getCount());
        } else {
            log.info("update failed, {}", atomicRefFieldUpdater.getCount());
        }
    }
}
