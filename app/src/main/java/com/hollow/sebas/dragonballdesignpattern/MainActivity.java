package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    MainGamePanel gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gameView = new MainGamePanel(this);
        //setContentView(R.layout.activity_main);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        FrameLayout game = new FrameLayout(this);
        game.addView(gameView);
        game.addView(getButtons());

        setContentView(game);

    }

    private LinearLayout getButtons(){
        LinearLayout buttons = new LinearLayout(this);
        String[] labels = new String[]{"Restart", "KaioKen", "SSJ", "SSJ3", "Attack!", "???"};
        for (int i = 0; i < labels.length; i++){
            Button btn = new Button(this);
            btn.setText(labels[i]);
            buttons.addView(btn);
            final int finalI = i;
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gameView.performAction(finalI);
                }
            });
        }
        return buttons;
    }
}
