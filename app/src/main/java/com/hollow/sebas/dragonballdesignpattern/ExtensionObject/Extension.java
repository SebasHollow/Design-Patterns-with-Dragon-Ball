package com.hollow.sebas.dragonballdesignpattern.ExtensionObject;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 8/11/2015 Dragon Ball Design Pattern.
 */
public interface Extension {
    String getName();
    int getPowerLevel();
    int getMaxHealth();
    Map<String, Integer> getAttacks();
}