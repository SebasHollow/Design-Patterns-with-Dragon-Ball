package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.Sprite;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class Goku implements Hero {
    private String spriteRootPath = "Goku/Base/";
    String name = "Goku";
    String race = "Saiyan";
    public int powerLevel = 1;
    public int maxHealth = 100;
    Map<String, Integer> techniques = new HashMap<>();

    public Goku(){
        techniques.put("Punch", 3);
        techniques.put("Kick", 5);
        techniques.put("Ki Blast", 10);
    }

    Goku(String name, String race, int powerLevel, int maxHealth){
        this.name = name;
        this.race = race;
        this.powerLevel = powerLevel;
        this.maxHealth = maxHealth;
    }

    @Override
    public Sprite.SpriteInfo getBaseSpriteInfo(){
        return new Sprite.SpriteInfo(spriteRootPath, 4);
    }

    @Override
    public Sprite.SpriteInfo getTransformationSpriteInfo() {
        return null;
    }

    @Override
    public Sprite.SpriteInfo getAttackSpriteInfo() {
        return new Sprite.SpriteInfo(spriteRootPath + "Attack/", 13);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPowerLevel() {
        return powerLevel;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public Map<String, Integer> getAttacks() {
        return techniques;
    }
}
