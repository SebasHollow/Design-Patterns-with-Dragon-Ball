package com.hollow.sebas.dragonballdesignpattern.ExtensionObject;

import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.Map;

/**
 * Created by Sebastian Hollow on 9/11/2015 Dragon Ball Design Pattern.
 */
public abstract class Hero implements Extendable {
    public abstract Sprite.SpriteInfo getBaseSpriteInfo();
    public abstract String getName();
    public abstract int getPowerLevel();
    public abstract int getMaxHealth();
    public abstract Map<String, Integer> getAttacks();

    public void addExtension(String key, Extension extensionObject) {
        m_extensions.put(key, extensionObject);
    }

    public void removeExtension(String key) {
        if (m_extensions.containsKey(key))
            m_extensions.remove(key);
    }

    public Extension getExtension(String key) {
        if (m_extensions.containsKey(key))
            return m_extensions.get(key);
        return null;
    }
}
