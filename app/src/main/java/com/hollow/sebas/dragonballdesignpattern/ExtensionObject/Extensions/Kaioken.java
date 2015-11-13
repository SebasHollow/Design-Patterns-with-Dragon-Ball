package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 13/11/2015 Dragon Ball Design Pattern.
 */
public class Kaioken implements Extension {
    private String spriteRootPath = "Goku/Kaioken/";

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 2);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return null;
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 27);
    }

    @Override
    public String getName() {
        return "KaioKen";
    }

    @Override
    public int getPowerLevel() {
        return 10;
    }

    @Override
    public int getMaxHealth() {
        return 10;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }
}
