package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Models;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Extension;
import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class CyborgGoku extends Hero {
    private String spriteRootPath = "Goku/Base/";
    String name = "Goku";
    int powerLevel = 1;
    int maxHealth = 100;
    HashMap<String, Integer> techniques = new HashMap<>();

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        Sprite.SpriteInfo value = new Sprite.SpriteInfo(spriteRootPath, 4);
        String alpha = getAlphaKey();
        return alpha == null ? value : m_extensions.get(alpha).getBaseSpriteInfo();
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        String alpha = getAlphaKey();
        return alpha == null ? null : m_extensions.get(alpha).getTransformationSpriteInfo();
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo() {
        Sprite.SpriteInfo value = new Sprite.SpriteInfo(spriteRootPath + "Attack/", 13);
        String alpha = getAlphaKey();
        return alpha == null ? value : m_extensions.get(alpha).getAttackSpriteInfo();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerLevel() {
        int value = powerLevel;
        for (Map.Entry<String, Extension> entry : m_extensions.entrySet())
            value += entry.getValue().getPowerLevel();
        return value;
    }

    @Override
    public int getMaxHealth() {
        int value = maxHealth;
        for (Map.Entry<String, Extension> entry : m_extensions.entrySet())
            value += entry.getValue().getMaxHealth();
        return value;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return techniques;
    }

    String getAlphaKey(){
        int maxPower = powerLevel;
        String alphaKey = null;

        for (Map.Entry<String, Extension> entry : m_extensions.entrySet()) {
            int power = entry.getValue().getPowerLevel();
            if (power > maxPower) {
                maxPower = power;
                alphaKey = entry.getKey();
            }
        }
        return alphaKey;
    }

}
