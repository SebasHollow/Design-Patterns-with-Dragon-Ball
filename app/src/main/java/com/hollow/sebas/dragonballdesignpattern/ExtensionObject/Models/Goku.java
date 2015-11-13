package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Models;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class Goku extends Hero {
    private String spriteRootPath = "Goku/Base/";
    String name = "Goku";
    int powerLevel = 1;
    int maxHealth = 100;
    HashMap<String, Integer> techniques = new HashMap<>();

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 4);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return null;
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo() {
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 13);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerLevel() {
        return powerLevel;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return techniques;
    }

}
