package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class SuperSaiyan extends Decorator {
    private String spriteRootPath = "Goku/SSJ/";
    public SuperSaiyan(Hero hero){
        this.hero = hero;
    }

    @Override
    public String getName() {
        return MessageFormat.format("SSJ {0}", hero.getName());
    }

    @Override
    public int getPowerLevel() {
        int pow = hero.getPowerLevel();
        return pow * pow;
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return new Sprite.SpriteInfo(spriteRootPath + "Transformation/XT/", 8);
    }

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 4);
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 13);
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
