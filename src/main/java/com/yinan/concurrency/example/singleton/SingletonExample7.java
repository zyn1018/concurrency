package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.Recommend;
import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式: 最安全
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {}

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
