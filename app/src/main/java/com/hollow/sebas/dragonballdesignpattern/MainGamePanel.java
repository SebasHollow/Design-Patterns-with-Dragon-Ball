package com.hollow.sebas.dragonballdesignpattern;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.Decorator;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.KaioKen;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan3;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models.Goku;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions.Kaioken;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions.SSJGoku;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions.SSJGoku3;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Models.CyborgGoku;

public class MainGamePanel extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = MainGamePanel.class.getSimpleName();
	
	private SpriteThread thread;
	private Hero hero = new Goku();
    private CyborgGoku cGoku = new CyborgGoku();
    private Sprite sprite;

    // the fps to be displayed
	private String avgFps;
	public void setAvgFps(String avgFps) {
		this.avgFps = avgFps;
	}

	public MainGamePanel(Activity activity) {
		super(activity.getBaseContext());
        sprite = new Sprite(activity, hero.getBaseSpriteInfo());

		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		thread = new SpriteThread(getHolder(), this);

		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder    holder, int format, int width,
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

    public void performAction (int i){
        boolean decoratorWasRemoved = false;
        switch (i){
            case 1:
                decoratorWasRemoved = removeDecorator(KaioKen.class);
                if (!decoratorWasRemoved){
                    sprite.cancelAnimations();
                    hero = new KaioKen(hero);
                }
                break;
            case 2:
                decoratorWasRemoved = removeDecorator(SuperSaiyan.class);
                if (!decoratorWasRemoved){
                    sprite.cancelAnimations();
                    hero = new SuperSaiyan(hero);
                }
                break;
            case 3:
                decoratorWasRemoved = removeDecorator(SuperSaiyan3.class);
                if (!decoratorWasRemoved){
                    sprite.cancelAnimations();
                    hero = new SuperSaiyan3(hero);
                }
                break;
            case 4:
                sprite.pushAnimation(hero.getAttackSpriteInfo());
                return;
            case 5:
                sprite.updateBaseSpriteInfo(cGoku.getBaseSpriteInfo());
                MainActivity.isDecorator = !MainActivity.isDecorator;
                return;
            case 0:
                hero = new Goku();
                sprite.updateBaseSpriteInfo(hero.getBaseSpriteInfo());
                return;
        }
        sprite.updateBaseSpriteInfo(hero.getBaseSpriteInfo());

        if (!decoratorWasRemoved && i > 0 && i < 4){
            Sprite.SpriteInfo transfAnim = hero.getTransformationSpriteInfo();
            if (transfAnim != null)
                sprite.pushAnimation(transfAnim);
        }

    }

    private boolean removeDecorator(Class cls){
        Hero tempHero;
        if (hero instanceof Decorator) {
            tempHero = ((Decorator) hero).removeRole(cls);
            if (tempHero != null){
                hero = tempHero;
                return true;
            }
        }
        return false;
    }

    public void performAction2 (int i){
        switch (i){
            case 1:
                toggleExtension("KaioKen", new Kaioken());
                break;
            case 2:
                toggleExtension("SSJGoku", new SSJGoku());
                break;
            case 3:
                toggleExtension("SSJGoku3", new SSJGoku3());
                break;
            case 4:
                Sprite.SpriteInfo rly = cGoku.getAttackSpriteInfo();
                sprite.pushAnimation(rly);
                return;
            case 5:
                sprite.updateBaseSpriteInfo(hero.getBaseSpriteInfo());
                MainActivity.isDecorator = !MainActivity.isDecorator;
                return;
            case 0:
                cGoku.removeAll();
                sprite.updateBaseSpriteInfo(cGoku.getBaseSpriteInfo());
        }
    }

    //return true if hero got "powered up"
    public void toggleExtension(String key, Extension e){
        if (cGoku.getExtension(key) != null){
            cGoku.removeExtension(key);
            sprite.updateBaseSpriteInfo(cGoku.getBaseSpriteInfo());
        } else {
            cGoku.addExtension(key, e);
            sprite.updateBaseSpriteInfo(cGoku.getBaseSpriteInfo());
            Sprite.SpriteInfo transformAnim = cGoku.getTransformationSpriteInfo();
            if (transformAnim != null)
                sprite.pushAnimation(transformAnim);
        }
    }

	public void render(Canvas canvas) {
		canvas.drawARGB(0, 127, 0, 0);
		canvas.drawColor(Color.BLACK);
		sprite.draw(canvas);
		// display fps
		displayFps(canvas, avgFps);
        displayStats(canvas);
	}

    private void displayStats(Canvas canvas) {
        if (canvas != null){
            Paint paint = new Paint();
            paint.setTextSize(16);
            if (MainActivity.isDecorator) {
                paint.setColor(Color.GREEN);
                canvas.drawText("Max HP : " + hero.getMaxHealth(), 100, 300, paint);
            }
            else {
                paint.setColor(Color.RED);
                canvas.drawText("Max HP : " + cGoku.getMaxHealth(), 100, 300, paint);
            }
        }
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
