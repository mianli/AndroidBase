package com.sucai.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sucai.model.observerable.AObserver;
import com.sucai.model.observerable.BObserver;
import com.sucai.model.observerable.ObserverManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObserverManager om = new ObserverManager();
        AObserver a = new AObserver(om);
        BObserver b = new BObserver(om);

        om.setData(10);
        om.deleteObserver(a);
        om.setData(20);
    }
}
