package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class KaioKen extends Decorator {
    private String spriteRootPath = "Goku/Kaioken/";
    public KaioKen(Hero hero){
        this.hero = hero;
    }

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 2);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return hero.getTransformationSpriteInfo();
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 27);
    }

    @Override
    public String getName() {
        return MessageFormat.format("{0}", hero.getName());
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
