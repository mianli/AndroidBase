package example.com.sucai.reflect;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by limian on 2018/1/10.
 */

public class LogHandler implements InvocationHandler {

    private IHello delegate;

    public Object bind(IHello delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Log.i("LogHandler", "start");
        result = method.invoke(delegate, args);

        Log.i("LogHandler", "invoke: " + "end");

        return result;
    }


}
