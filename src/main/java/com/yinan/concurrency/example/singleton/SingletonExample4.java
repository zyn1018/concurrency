package com.yinan.concurrency.example.singleton;

import com.yinan.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式（双重同步锁单例模式）
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {
    }

    //1. memory = allocate() 分配对象的内存空间
    //2. ctorinstance() 初始化对象
    //3. instance = memory 设置instance指向刚分配的内存
    //JVM和CPU优化可能导致发生指令重排，如下:
    //1. memory = allocate() 分配对象的内存空间
    //2. instance = memory 设置instance指向刚分配的内存
    //3. ctorinstance() 初始化对象

    // 单例对象
    private static SingletonExample4 instance = null;

    //静态工厂方法(加synchronize后可能会出现性能问题，不加则导致线程不安全)
    public static SingletonExample4 getInstance() {

        if (instance == null) {//双重检测机制
            synchronized (SingletonExample4.class) {//同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
