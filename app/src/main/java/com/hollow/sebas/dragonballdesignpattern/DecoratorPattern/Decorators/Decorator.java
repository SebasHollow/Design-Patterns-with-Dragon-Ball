package com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;

/**
 * Created by Sebastian Hollow on 7/11/2015 Dragon Ball Design Pattern.
 */
public abstract class Decorator implements Hero {
    Hero hero;

    public Decorator getRole(Class role) {
        if (getClass() == role)
            return this;

        return hero instanceof Decorator ? ((Decorator) hero).getRole(role) : null;
    }

    public Hero removeRole(Class role){
        if (getClass() == role)
            return getChild();

        return removeRole(role.getName()) ? this : null;
    }

    private boolean removeRole(String name){
        if (!(hero instanceof Decorator))
            return false;

        if (name.equals(hero.getClass().getName())) {
            hero = ((Decorator) hero).getChild();
            return true;
        }
        return ((Decorator) hero).removeRole(name);
    }

    protected Hero getChild(){
        return hero;
    }
}
