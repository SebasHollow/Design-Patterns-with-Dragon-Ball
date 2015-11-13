package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 13/11/2015 Dragon Ball Design Pattern.
 */
public class SSJGoku3 implements Extension {
    private String spriteRootPath = "Goku/SSJ3/";

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 3);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Transformation/", 12);
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 9);
    }

    @Override
    public String getName() {
        return "SSJ3";
    }

    @Override
    public int getPowerLevel() {
        return 1000;
    }

    @Override
    public int getMaxHealth() {
        return 1000;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }
}
