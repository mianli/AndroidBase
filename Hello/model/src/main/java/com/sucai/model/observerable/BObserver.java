package com.sucai.model.observerable;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

/**
 * Created by limian on 2018/2/26.
 */

public class BObserver implements Observer {

    private static final Logger LOGGER = Logger.getLogger(BObserver.class.getSimpleName());

    public BObserver(ObserverManager om) {
        om.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        ObserverManager om = (ObserverManager) o;
        LOGGER.info("b:" + om.getData() + ", " + arg);
    }
}
