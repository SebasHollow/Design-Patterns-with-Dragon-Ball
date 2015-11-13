package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern;

import java.util.Map;

/**
 * Created by Sebastianas.Malinaus on 7/11/2015.
 */
public interface Hero {
    String spritePath();
    String getName();
    String getRace();
    int getPowerLevel();
    int getMaxHealth();
    Map<String, Integer> getAttacks();
}
