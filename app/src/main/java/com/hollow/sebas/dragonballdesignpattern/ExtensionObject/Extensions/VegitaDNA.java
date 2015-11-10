package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 9/11/2015 Dragon Ball Design Pattern.
 */
public class VegitaDNA implements Extension {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getRace() {
        return "";
    }

    @Override
    public int getPowerLevel() {
        return 50;
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }
}
