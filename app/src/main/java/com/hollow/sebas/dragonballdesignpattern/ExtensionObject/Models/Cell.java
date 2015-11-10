package com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Models;

import com.hollow.sebas.dragonballdesignpattern.ExtensionObject.Hero;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public class Cell extends Hero {
    String name = "Cell";
    String race = "Android";
    int powerLevel = 1;
    int maxHealth = 100;
    HashMap<String, Integer> techniques = new HashMap<>();

    public Cell(){
        techniques.put("Punch", 3);
        techniques.put("Kick", 5);
        techniques.put("Ki Blast", 10);
    }

    Cell(String name, String race, int powerLevel, int maxHealth){
        this.name = name;
        this.race = race;
        this.powerLevel = powerLevel;
        this.maxHealth = maxHealth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRace() {
        return race;
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
