package com.sucai.model.observerable;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;

/**
 * Created by limian on 2018/2/26.
 */

public class AObserver implements Observer{

    private static Logger logger = Logger.getLogger(AObserver.class.getSimpleName());

    public AObserver(ObserverManager om) {
        om.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        ObserverManager om = (ObserverManager) o;
        logger.info("a:" + om.getData() + ", " + arg);
    }

}
