package gr.aueb.recipeapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

import static org.junit.Assert.*;

public class RecipeTest {

    private Recipe r;
    private User user;
    private ArrayList<RecipeIngredient> i;

    @Before
    public void setUp() throws Exception{
        this.user = new User("Mamalakis", "abcd");
        this.i = new ArrayList<RecipeIngredient>();
        i.add(new RecipeIngredient(1, new Ingredient("Pork chop", 1)));
        i.add(new RecipeIngredient(2, new Ingredient("Honey", 1)));
        i.add(new RecipeIngredient(3, new Ingredient("Mustard", 1)));
        this.r = new Recipe(Recipe.idCounter, "R", CourseType.Main, 8, 2, "Yada Yada Yada", this.i, this.user);
    }

    @After
    public void tearDown() throws Exception{
        this.r = null;
        this.user = null;
        this.i = null;
    }

    @Test
    public void calorieCalculation() {
        assertEquals(6, r.getTotalCalories(), 0);
    }

}