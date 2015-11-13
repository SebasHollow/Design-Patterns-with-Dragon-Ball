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
    private SpriteInfo animationInfo = null;

    @SuppressWarnings("FieldCanBeLocal")
    private int x = 400;
    @SuppressWarnings("FieldCanBeLocal")
    private int y = 850;

    private String format;


    public Sprite(Activity activity, SpriteInfo info) {
        this.activity = activity;
        updateBaseSpriteInfo(info);
        bitmap = getBitmap(MessageFormat.format(format, 0));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void updateBaseSpriteInfo(SpriteInfo info){
        format = info.path;
        fps = info.fps;
        frameTicker = 0l;
        framePeriod = 1000 / fps;
        currentFrame = 0;
    }

    public void pushAnimation(SpriteInfo info){
        animationInfo = info;
        currentFrame = 0;
    }

    public void cancelAnimations(){
        animationInfo = null;
        currentFrame = 0;
    }

    public void update(long gameTime) {
        boolean isBaseAnimation = animationInfo == null;
        long updateTime = frameTicker + (isBaseAnimation ? framePeriod : 1000 / animationInfo.fps);

        if (gameTime <= updateTime)
            return;

        frameTicker = gameTime;
        currentFrame++;

        if (isBaseAnimation) {
            //Constant loop between 0..fps values
            currentFrame %= fps;
            bitmap = getBitmap(MessageFormat.format(format, currentFrame));
        }
        else animationUpdate();
    }

    void animationUpdate (){
        String format = animationInfo.path;
        if (currentFrame >= animationInfo.fps - 1){
            animationInfo = null;
            frameTicker = 0l;
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


    public static class SpriteInfo{
        String path;
        int fps;

        public SpriteInfo(String path, int fps){
            this.path = path + "{0}.png";
            this.fps = fps;
        }
    }
}
