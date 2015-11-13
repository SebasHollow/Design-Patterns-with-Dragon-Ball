package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern;

import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastianas.Malinaus on 7/11/2015.
 */
public interface Hero {
    Sprite.SpriteInfo getTransformationSpriteInfo();
    Sprite.SpriteInfo getBaseSpriteInfo();
    Sprite.SpriteInfo getAttackSpriteInfo();
    String getName();
    int getPowerLevel();
    int getMaxHealth();
    Map<String, Integer> getAttacks();
}
