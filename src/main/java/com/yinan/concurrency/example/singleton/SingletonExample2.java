package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载时候进行创建
 * 如果构造函数中存在过多处理，可能会存在性能问题
 */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2() {
    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
