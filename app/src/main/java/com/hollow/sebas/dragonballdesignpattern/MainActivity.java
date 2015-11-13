package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan3;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models.Goku;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Hero goku = new Goku();
        goku = new SuperSaiyan3(goku);
        Sprite sprite = new Sprite(this, goku.spritePath(),  4);
        setContentView(new MainGamePanel(this, sprite));

        //setContentView(R.layout.activity_main);
    }
}
