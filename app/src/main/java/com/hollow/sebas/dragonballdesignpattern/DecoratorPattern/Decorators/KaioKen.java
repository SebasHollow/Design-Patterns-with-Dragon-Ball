package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class KaioKen extends Decorator {
    private KaioKen(Hero hero){
        this.hero = hero;
    }

    @Override
    public String getName() {
        return MessageFormat.format("{0}", hero.getName());
    }

    @Override
    public String getRace() {
        return hero.getRace();
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
        return hero.getAttacks();
    }
}
