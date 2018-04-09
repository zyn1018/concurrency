package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.NotRecommend;
import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample1 {

    private SingletonExample1() {
    }

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法(加synchronize后可能会出现性能问题，不加则导致线程不安全)
    public static synchronized SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
