package com.sucai.model.observerable;

import java.util.Observer;

/**
 * Created by limian on 2018/2/26.
 */

public interface Subject {

    void addObserver(Observer o);

    void deleteObserver(Observer o);

    void notifyObserver();

}
