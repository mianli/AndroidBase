package example.com.sucai.reflect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.Reflect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgv = new ImageView(this);
//        Class cls = imgv.getClass();
//
//        Package pkg = cls.getPackage();
//
//        int m = cls.getModifiers();
//        Log.i(TAG, Modifier.toString(m));
//
//        if(Modifier.isInterface(m)) {
//            Log.i(TAG, "onCreate: isInterface");
//        }else {
//            Log.i(TAG, "onCreate: isCLass");
//        }
//
//        Log.i(TAG, "getName : " + cls.getName());
//
//        Log.i(TAG, "fields:---------------");
//        Field[] fileds = cls.getDeclaredFields();
//        for (Field field : fileds) {
//            Log.i(TAG, Modifier.toString(field.getModifiers()));
//
//            Log.i(TAG, field.getType().getName());
//
//            Log.i(TAG, "field getName : " + field.getName());
//        }
//
//
//        Log.i(TAG, "constructors:---------------");
//        Constructor[] constructors = cls.getConstructors();
//        for (Constructor constructor : constructors) {
//            Log.i(TAG, Modifier.toString(constructor.getModifiers()));
//
//            Log.i(TAG, constructor.getName());
//
//        }
//
//        Log.i(TAG, "methods:---------------");
//        Method[] methods = cls.getMethods();
//        for (Method method : methods) {
//            Log.i(TAG, Modifier.toString(method.getModifiers()));
//
//            Log.i(TAG, method.getReturnType().getName());
//
//            Log.i(TAG, method.getName());
//        }

        /*Class<Person> pcls = Person.class;

        Class[] params = new Class[2];
        params[0] = String.class;
        params[1] = Integer.TYPE;

        try {
            Constructor constructor = pcls.getDeclaredConstructor(params);
            constructor.setAccessible(true);

            Object[] objects = new Object[2];
            objects[0] = "mli";
            objects[1] = 20;

            Object obj = constructor.newInstance(objects);
            Toast.makeText(this, obj.toString(), Toast.LENGTH_SHORT).show();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        /*Class<Person> cls = Person.class;
        try {
            Person person = cls.newInstance();

            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                Log.i(TAG, method.getName());
            }

            Class[] param1 = {String.class};
            Method setNameMethod = cls.getDeclaredMethod("setName", param1);
            setNameMethod.setAccessible(true);
            Object[] value1 = {"mli"};
            setNameMethod.invoke(person, value1);

            Class[] param2 = {Integer.TYPE};
            Method setAgeMethod = cls.getDeclaredMethod("setAge", param2);
            setAgeMethod.setAccessible(true);
            Object[] value2 = {2};
            setAgeMethod.invoke(person, value2);

            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
*/


        Person p = new Person();
        Class<?> cls = Person.class;
        Field[] fields = cls.getDeclaredFields();
        try {
            Field field = cls.getDeclaredField("student");
            field.setAccessible(true);
            Student s = (Student) field.get(p);
            s.setStuName("mli zhangGaihong");
            Log.i("Main", s.getStuName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        for (Field field : fields) {
//            Log.i(TAG, field.getType().getName());
//        }

//        try {
//            Person person = (Person) cls.newInstance();
//            Field name = cls.getDeclaredField("name");
//            name.setAccessible(true);
//            name.set(person, "mli");
//
//            Field age = cls.getDeclaredField("age");
//            age.setAccessible(true);
//            age.setInt(person, 20);
//
//            Toast.makeText(this, person.toString(), Toast.LENGTH_SHORT).show();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

//        LogHandler handler = new LogHandler();
//        IHello helloSpeaker = new HelloSpeaker();
//        IHello speakProxy = (IHello) handler.bind(helloSpeaker);
//        speakProxy.hello("hello");
//
//        speakProxy.byeBye();

    }
}
