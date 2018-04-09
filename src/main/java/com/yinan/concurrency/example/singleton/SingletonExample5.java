package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式（双重同步锁单例模式）
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {
    }

    //1. memory = allocate() 分配对象的内存空间
    //2. ctorinstance() 初始化对象
    //3. instance = memory 设置instance指向刚分配的内存

    // 单例对象（volatile + 双重检测机制 -> 禁止指令重排）
    private volatile static SingletonExample5 instance = null;

    //静态工厂方法(加synchronize后可能会出现性能问题，不加则导致线程不安全)
    public static SingletonExample5 getInstance() {

        if (instance == null) {//双重检测机制
            synchronized (SingletonExample5.class) {//同步锁
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
