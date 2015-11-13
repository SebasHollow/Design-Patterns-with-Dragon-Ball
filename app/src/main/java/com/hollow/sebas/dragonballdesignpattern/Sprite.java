package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.IOException;
import java.text.MessageFormat;

public class Sprite {

    private static final String TAG = Sprite.class.getSimpleName();

    private final Activity activity;
    private Bitmap bitmap;
    //private ArrayList<Bitmap> extraBitmaps = new ArrayList<>(); // the animation sequence
    private int fps;
    private int currentFrame = 0;
    private long frameTicker;
    private int framePeriod;
    //private int kameLoop = 8;

    @SuppressWarnings("FieldCanBeLocal")
    private int x = 400;
    @SuppressWarnings("FieldCanBeLocal")
    private int y = 850;

    private String format;
    //private int kameTick = 0;


    public Sprite(Activity activity, String path, int fps) {
        this.activity = activity;
        this.fps = fps;
        updatePath(path);
        bitmap = getBitmap(MessageFormat.format(format , 0));
        framePeriod = 1000 / this.fps;
        frameTicker = 0l;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void updatePath(String path){
        format = path + "{0}.png";
    }

    public void update(long gameTime) {
        if (gameTime <= frameTicker + framePeriod)
            return;
        frameTicker = gameTime;

/*        if (++currentFrame > kameLoop && ++kameTick < 25){
            currentFrame = 7;
        }
        else */
        if (++currentFrame >= fps - 1) {
            currentFrame = 0;
            //kameTick = 0;
        }
        bitmap = getBitmap(MessageFormat.format(format, currentFrame));
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect(getX() - bitmap.getWidth(), getY() - bitmap.getHeight(), getX(), getY());
        canvas.drawBitmap(bitmap, null, rect, null);

/*        if (currentFrame < 7 || currentFrame >= 10)
            return;

        drawExtraBitmaps(canvas, rect);*/
    }
/*
    private void drawExtraBitmaps(Canvas canvas, Rect rect){
        for (int i = 0; i < extraBitmaps.size(); i++){
            int left = rect.right;
            int top = (rect.centerY() - extraBitmaps.get(i).getHeight() / 2);
            rect.set(left, top, left + extraBitmaps.get(i).getWidth(), top + extraBitmaps.get(i).getHeight());
            canvas.drawBitmap(extraBitmaps.get(i), null, rect, null);
        }
    }*/

    Bitmap getBitmap(String path){
        try {
            Bitmap bmp = BitmapFactory.decodeStream(activity.getAssets().open(path));
            return Bitmap.createScaledBitmap(bmp, bmp.getWidth()*5, bmp.getHeight()*5, false);
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
        return null;
    }
}
