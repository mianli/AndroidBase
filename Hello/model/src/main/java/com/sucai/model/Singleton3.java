package com.sucai.model;

/**
 * Created by limian on 2018/2/23.
 */

public class Singleton3 {

    private static volatile Singleton3 instance = null;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        //先检查实例是否存在，如果不存在再进入同步代码块
        if(instance == null) {
            //同步块，线程安全创建实例
            synchronized (Singleton3.class) {
                if(instance == null) {
                    //再次检查实例是否存在，如果不存在则创建实例
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}
