package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 9/11/2015 Dragon Ball Design Pattern.
 */
public class SSJGoku implements Extension {
    private String spriteRootPath = "Goku/SSJ/";

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 4);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return new Sprite.SpriteInfo(spriteRootPath + "Transformation/XT/", 8);
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 13);
    }

    @Override
    public String getName() {
        return "SSJ";
    }

    @Override
    public int getPowerLevel() {
        return 100;
    }

    @Override
    public int getMaxHealth() {
        return 100;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }
}
