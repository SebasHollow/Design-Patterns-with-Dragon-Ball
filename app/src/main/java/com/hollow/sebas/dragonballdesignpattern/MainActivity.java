package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Sprite sprite = new Sprite(this, BitmapFactory.decodeResource(getResources(), R.drawable.all_goku), 400, 850, 12);
        setContentView(new MainGamePanel(this, sprite));

        //setContentView(R.layout.activity_main);
    }
}
