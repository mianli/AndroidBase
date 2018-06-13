package com.sucai.model;

/**
 * Created by limian on 2018/2/25.
 */

public class Copy implements Cloneable {

    private String desc;

    public Copy(String desc) {
        this.desc = desc;
    }

    @Override
    protected Copy clone() throws CloneNotSupportedException {
        return (Copy) super.clone();
    }
}
