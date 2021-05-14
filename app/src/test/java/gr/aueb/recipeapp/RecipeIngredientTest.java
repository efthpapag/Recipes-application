package gr.aueb.recipeapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeIngredientTest {

    private Ingredient i;

    @Before
    public void setUp() throws Exception{
        this.i = new Ingredient("i",1);
    }

    @After
    public void tearDown() throws Exception{
        this.i = null;
    }

    @Test
    public void calorieCalculation() {
        assertEquals(3.5f, new RecipeIngredient(3.5f, i).calorieCalculation(),0);
    }
}