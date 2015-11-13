package com.hollow.sebas.dragonballdesignpattern.ExtensionObject;

import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 8/11/2015 Dragon Ball Design Pattern.
 */
public interface Extension {
    Sprite.SpriteInfo getTransformationSpriteInfo();

    Sprite.SpriteInfo getAttackSpriteInfo();

    String getName();
    Sprite.SpriteInfo getBaseSpriteInfo();
    int getPowerLevel();
    int getMaxHealth();
    Map<String, Integer> getAttacks();
}