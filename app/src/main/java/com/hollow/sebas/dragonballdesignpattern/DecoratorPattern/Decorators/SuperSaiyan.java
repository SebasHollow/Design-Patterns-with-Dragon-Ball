package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class SuperSaiyan extends Decorator {
    public SuperSaiyan(Hero hero){
        this.hero = hero;
    }

    /*public static Hero Extend(Hero hero){
        boolean isSaiyan = hero.getRace().equals("Saiyan");
        return isSaiyan ? new SuperSaiyan(hero) : hero;
    }
    */
    @Override
    public String getName() {
        return MessageFormat.format("SSJ {0}", hero.getName());
    }

    @Override
    public int getPowerLevel() {
        int pow = hero.getPowerLevel();
        return pow * pow;
    }

    public String spritePath(){
        return "Goku/SSJ/";
    }

    @Override
    public int getMaxHealth() {
        return hero.getMaxHealth();
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return null;
    }
}
