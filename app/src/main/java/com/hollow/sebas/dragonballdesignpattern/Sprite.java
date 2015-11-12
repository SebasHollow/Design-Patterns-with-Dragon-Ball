package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class Sprite {

    private static final String TAG = Sprite.class.getSimpleName();

    private final Activity activity;
    private Bitmap bitmap;
    private ArrayList<Bitmap> extraBitmaps = new ArrayList<>(); // the animation sequence
    private int frameCount;		// number of frames in animation
    private int currentFrame = 0;
    private long frameTicker;	// the time of the last frame update
    private int framePeriod;	// milliseconds between each frame (1000/fps)
    private int kameLoop = 8;


    private int x;				// the X coordinate of the object (top left of the image)
    private int y;				// the Y coordinate of the object (top left of the image)

    private String format = "Goku/Kaioken/Kame/{0}.png";
    private int kamehameTick = 0;


    public Sprite(Activity activity, Bitmap bitmap, int x, int y, int fps) {
        this.activity = activity;
        this.bitmap = bitmap;
        this.x = x;
        this.y = y;
        frameCount = fps;
        framePeriod = 1000 / frameCount;
        frameTicker = 0l;

        extraBitmaps.add(getBitmap(MessageFormat.format(format, 12)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 13)));
        extraBitmaps.add(getBitmap(MessageFormat.format(format, 14)));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    // the update method for Elaine
    public void update(long gameTime) {
        if (gameTime <= frameTicker + framePeriod)
            return;
        frameTicker = gameTime;

        if (++currentFrame > kameLoop && ++kamehameTick < 25){
            currentFrame = 7;
        }
        else if (currentFrame >= frameCount - 1) {
            currentFrame = 0;
            kamehameTick = 0;
        }

        bitmap = getBitmap(MessageFormat.format(format, currentFrame));
    }

    public void draw(Canvas canvas) {
        Rect rect = new Rect(getX() - bitmap.getWidth(), getY() - bitmap.getHeight(), getX(), getY());
        canvas.drawBitmap(bitmap, null, rect, null);

        if (currentFrame < 7 || kameLoop >= 10)
            return;

        drawExtraBitmaps(canvas, rect);
    }

    private void drawExtraBitmaps(Canvas canvas, Rect rect){
        for (int i = 0; i < extraBitmaps.size(); i++){
            int left = rect.right;
            int top = (rect.centerY() - extraBitmaps.get(i).getHeight() / 2);
            rect.set(left, top, left + extraBitmaps.get(i).getWidth(), top + extraBitmaps.get(i).getHeight());
            canvas.drawBitmap(extraBitmaps.get(i), null, rect, null);
        }
    }

    Bitmap getBitmap(String path){
        try {
            Bitmap bmp = BitmapFactory.decodeStream(activity.getAssets().open(path));
            return Bitmap.createScaledBitmap(bmp, bmp.getWidth()*5, bmp.getHeight()*5, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
