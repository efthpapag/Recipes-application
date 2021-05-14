package gr.aueb.recipeapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception{
        this.user = new User("Mamalakis", "abcd");
    }

    @After
    public void tearDown() throws Exception{
        this.user = null;
        Recipe.allRecipes.clear();
        Recipe.idCounter = 0;
    }

    @Test
    public void publish() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        this.user.publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        assertEquals("Pork chops with honey and mustard", user.getRecipesPublished().get(0).getName());
        assertEquals("Pork chops with honey and mustard", Recipe.allRecipes.get(0).getName());
        assertEquals(1, Recipe.idCounter);
    }

    @Test
    public void remove() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        this.user.publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        this.user.remove(0);
        assertTrue(Recipe.allRecipes.isEmpty());
    }

    @Test
    public void edit() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        this.user.publish("Pork chops with honey", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        this.user.edit(0, "Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        assertEquals("Pork chops with honey and mustard", user.getRecipesPublished().get(0).getName());
    }

    @Test
    public void rate() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        User user2 = new User("Barbarigou", "efgh");
        this.user.publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        user2.rate(0, RatingLevel.Negative);
        assertEquals(RatingLevel.Negative, user2.getRatings().get(0).getRating());
    }

    @Test
    public void search() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        this.user.publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        User user2 = new User("Lazarou", "efgh");
        ArrayList<Recipe> r = user2.search(7, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey and mustard", r.get(0).getName());
    }
}