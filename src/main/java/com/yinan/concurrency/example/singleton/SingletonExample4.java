package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.NotRecommend;
import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式（synchronized可能会影响性能）
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() {
    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法(加synchronize后可能会出现性能问题，不加则导致线程不安全)
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
