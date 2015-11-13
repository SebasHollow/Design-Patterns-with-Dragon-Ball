package com.hollow.sebas.dragonballdesignpattern;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.Decorator;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.KaioKen;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan3;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models.Goku;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = MainGamePanel.class.getSimpleName();
	
	private SpriteThread thread;
	private Sprite sprite;
	private Hero hero = new Goku();
    private int index = 0;

	// the fps to be displayed
	private String avgFps;
	public void setAvgFps(String avgFps) {
		this.avgFps = avgFps;
	}

	public MainGamePanel(Context context, Sprite sprite) {
		super(context);

		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create the game loop thread
		thread = new SpriteThread(getHolder(), this);

		// make the GamePanel focusable so it can handle events
		setFocusable(true);
        this.sprite = sprite;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// at this point the surface is created and
		// we can safely start the game loop
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "Surface is being destroyed");
		// tell the thread to shut down and wait for it to finish
		// this is a clean shutdown
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
			} catch (InterruptedException e) {
				// try again shutting down the thread
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
            switch (++index){
                case 1:
                    sprite.cancelAnimations();
                    hero = new KaioKen(hero);
                    break;
                case 2:
                    hero = new SuperSaiyan(hero);
                    break;
                case 3:
                    hero = new SuperSaiyan3(hero);
                    break;
                case 4:
                    hero = ((Decorator)hero).removeRole(KaioKen.class);
                    break;
                case 5:
                    hero = ((Decorator)hero).removeRole(SuperSaiyan3.class);
                    break;
                case 6:
                    hero = ((Decorator)hero).removeRole(SuperSaiyan.class);
                    break;
                case 7:
                    sprite.pushAnimation(new Sprite.SpriteInfo("Goku/Kaioken/Attack/", 27));
                default:
                    index = 0;
            }
            sprite.updateBaseSpriteInfo(hero.getBaseSpriteInfo());
            Sprite.SpriteInfo transfAnim = hero.getTransformationSpriteInfo();
            if (transfAnim != null && index < 4)
                sprite.pushAnimation(transfAnim);
        }
		return true;
	}

	public void render(Canvas canvas) {
		canvas.drawARGB(0, 127, 0, 0);
		canvas.drawColor(Color.BLACK);
		sprite.draw(canvas);
		// display fps
		displayFps(canvas, avgFps);
	}

	/**
	 * This is the game update method. It iterates through all the objects
	 * and calls their update method if they have one or calls specific
	 * engine's update method.
	 */
	public void update() {
		sprite.update(System.currentTimeMillis());
	}

	private void displayFps(Canvas canvas, String fps) {
		if (canvas != null && fps != null) {
			Paint paint = new Paint();
			paint.setARGB(255, 255, 255, 255);
			canvas.drawText(fps, this.getWidth() - 50, 20, paint);
		}
	}

}
