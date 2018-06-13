package com.sucai.model;

/**
 * Created by limian on 2018/2/23.
 */

public class Singleton1 {

    private Singleton1() {

    }

    private static final Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }

}
