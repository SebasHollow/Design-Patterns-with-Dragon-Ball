package com.hollow.sebas.dragonballdesignpattern;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.Decorator;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Decorators.SuperSaiyan3;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Hero;
import com.hollow.sebas.dragonballdesignpattern.DecoratorPattern.Models.Goku;

import junit.framework.Assert;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
        Hero goku = new Goku();
        positiveTest(goku);
        negativeTest(goku);
    }


    public static void positiveTest(Hero h){
        Decorator ssjHero = new SuperSaiyan(h);
        Decorator newObj = ssjHero.getRole(SuperSaiyan.class);
        Assert.assertTrue(newObj != null);
    }

    public static void negativeTest(Hero h){
        Decorator ssjHero = new SuperSaiyan3(h);
        Decorator newObj = ssjHero.getRole(SuperSaiyan.class);
        Assert.assertTrue(newObj == null);
    }
}