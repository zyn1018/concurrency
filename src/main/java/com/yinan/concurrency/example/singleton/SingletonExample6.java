package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式2
 */
@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6() {
    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    public static SingletonExample6 getInstance() {
        return instance;
    }
}
