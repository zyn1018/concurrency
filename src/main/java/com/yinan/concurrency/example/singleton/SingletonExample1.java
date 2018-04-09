package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.NotRecommend;
import com.yinan.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式（线程不安全）
 */
@NotThreadSafe
@NotRecommend
public class SingletonExample1 {

    private SingletonExample1() {
    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
