package gr.aueb.recipeapp;

import org.junit.Test;

import org.junit.Assert;


public class IngredientTest {

    @Test
    public void getName() {
        Ingredient i = new Ingredient("i", 1);
        Assert.assertEquals("i", i.getName());
    }

    @Test
    public void setName() {
    }

    @Test
    public void getCalories() {
    }

    @Test
    public void setCalories() {
    }
}