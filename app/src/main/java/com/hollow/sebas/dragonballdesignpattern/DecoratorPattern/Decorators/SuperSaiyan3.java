package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;

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

    public String spritePath(){
        return "Goku/SSJ3/";
    }
}
