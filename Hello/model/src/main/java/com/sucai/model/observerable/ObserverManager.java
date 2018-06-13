package com.sucai.model.observerable;

import java.util.Observable;

/**
 * Created by limian on 2018/2/26.
 */

public class ObserverManager extends Observable {

    private int data = 0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;

        setChanged();
        notifyObservers(data);
    }

}
