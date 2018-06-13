package com.sucai.model;

/**
 * Created by limian on 2018/2/23.
 */

public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }

        return instance;
    }

}