package example.com.sucai.mylibrary;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by limian on 2018/1/8.
 */

public class JarCls {

    public static void showToast(Context context) {
        Toast.makeText(context, "来自jar的提示", Toast.LENGTH_SHORT).show();
    }

}
