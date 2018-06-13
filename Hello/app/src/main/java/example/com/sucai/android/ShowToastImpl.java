package example.com.sucai.android;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by limian on 2018/1/8.
 */

public class ShowToastImpl implements IShowToast {

    @Override
    public int showToast(Context context) {
        Toast.makeText(context, "我来自另一个dex文件", Toast.LENGTH_SHORT).show();
        return 100;
    }


}
