package example.com.sucai.reflect;

import android.util.Log;

/**
 * Created by limian on 2018/1/10.
 */

public class HelloSpeaker implements IHello {

    private static final String TAG = "HelloSpeaker";

    @Override
    public void hello(String msg) {
        Log.i(TAG, "hello: " + msg);
    }

    @Override
    public void byeBye() {
        Log.i(TAG, "byeBye");
    }

}
