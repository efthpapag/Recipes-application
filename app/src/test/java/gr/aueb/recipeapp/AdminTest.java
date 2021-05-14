package gr.aueb.recipeapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminTest {

    private Admin a;

    @Before
    public void setUp() throws Exception{
        this.a = new Admin("Mamalakis", "abcd");
    }

    @After
    public void tearDown() throws Exception{
        this.a = null;
        Ingredient.allIngredients.clear();
    }

    @Test
    public void registerIngredient() {
        this.a.registerIngredient("Pork chop", 1);
        assertEquals("Pork chop", Ingredient.allIngredients.get(0).getName());
        assertEquals(1, Ingredient.allIngredients.get(0).getCalories());
    }

    @Test
    public void editIngredient() {
        this.a.registerIngredient("Steak", 1);
        this.a.editIngredient("Steak", "Pork chop", 2);
        assertEquals("Pork chop", Ingredient.allIngredients.get(0).getName());
        assertEquals(2, Ingredient.allIngredients.get(0).getCalories());
    }
}