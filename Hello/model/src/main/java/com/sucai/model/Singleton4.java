package com.sucai.model;

/**
 * Created by limian on 2018/2/23.
 */

public class Singleton4 {

    private Singleton4() {

    }

    //静态内部类，被调用时才会重载，从而实现了延迟加载
    private static final class SingletonHolder {
        //静态初始化器，从而保证了线程的安全性
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

}
