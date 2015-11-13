package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models.Goku;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.text.MessageFormat;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class SuperSaiyan3 extends Decorator {
    private String spriteRootPath = "Goku/SSJ3/";
    private int permanentHpIncrement = 1000;
    public SuperSaiyan3(Hero hero){
        this.hero = hero;
        addPermanentPower(this.hero);
    }

    public void addPermanentPower (Hero hero){
        if (hero instanceof Goku)
            ((Goku) hero).maxHealth += permanentHpIncrement;
        else ((Decorator) hero).getChild();
    }

    @Override
    public String getName() {
        return MessageFormat.format("SSJ3 {0}", hero.getName());
    }

    @Override
    public int getPowerLevel() {
        int pow = hero.getPowerLevel();
        return pow * pow * pow;
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
        return new Sprite.SpriteInfo("Goku/SSJ3/", 3);
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 9);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath + "Transformation/", 12);
    }
}
