package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class SuperSaiyan3 extends Decorator {
    public SuperSaiyan3(Hero hero){
        this.hero = hero;
    }

    @Override
    public String getName() {
        return MessageFormat.format("SSJ2 {0}", hero.getName());
    }


    @Override
    public int getPowerLevel() {
        int pow = hero.getPowerLevel();
        return pow * pow;
    }

    @Override
    public int getMaxHealth() {
        return hero.getMaxHealth();
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo("Goku/SSJ3/", 4);
    }
}
