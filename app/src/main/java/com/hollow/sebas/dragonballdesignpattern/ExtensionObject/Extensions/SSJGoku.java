package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extensions;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 9/11/2015 Dragon Ball Design Pattern.
 */
public class SSJGoku implements Extension {
    @Override
    public String getName() {
        return "SSJ";
    }

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo() {
        return new Sprite.SpriteInfo("Goku/SSJ/", 4);
    }

    @Override
    public int getPowerLevel() {
        return 100;
    }

    public String spritePath(){
        return "Goku/SSJ/";
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
