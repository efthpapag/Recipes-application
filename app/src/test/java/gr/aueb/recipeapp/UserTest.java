package gr.aueb.recipeapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
        User.allUsers.clear();
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
        this.user.remove(1);
        assertFalse(Recipe.allRecipes.isEmpty());
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
        this.user.edit(1, "Pork chops with honey", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
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
        user2.rate(1, RatingLevel.Positive);
        assertEquals(RatingLevel.Negative, user2.getRatings().get(0).getRating());
    }

    @Test
    public void search() throws ParseException {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        ArrayList<RecipeIngredient> ingredients2 = new ArrayList<RecipeIngredient>();
        ingredients2.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients2.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        this.user.publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        this.user.publish("Pork chops with honey", CourseType.Main, 4, 2, "Yada yada yada", ingredients2);
        this.user.publish("honey and mustard", CourseType.Appetizer, 4, 2, "Yada yada yada", ingredients);
        User user2 = new User("Lazarou", "efgh");
        ArrayList<Recipe> r;
        r = user2.search(1, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals("Pork chops with honey and mustard", r.get(1).getName());
        r = user2.search(10, ingredients2, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals(1, r.size());
        r = user2.search(10, ingredients, CourseType.Appetizer);
        assertEquals("honey and mustard", r.get(0).getName());
        assertEquals(1, r.size());
        r = user2.search(5, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals(1, r.size());
        user2.rate(0, RatingLevel.Positive);
        /*r = user2.search(10, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey and mustard", r.get(0).getName());
        assertEquals("Pork chops with honey", r.get(1).getName());*/
        user2.rate(0, RatingLevel.Neutral);
        HashMap<Integer, Date> h = new HashMap<Integer, Date>();
        h.put(0,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        h.put(1,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1999"));
        user2.setRecipesRead(h);
        r = user2.search(10, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey and mustard", r.get(0).getName());
        assertEquals("Pork chops with honey", r.get(1).getName());
    }

    @Test
    public void accountCreation(){
        User.accountCreation("Akis", "efgh");
        assertEquals("Akis", User.allUsers.get(0).getUsername());
        assertEquals(false, User.accountCreation("Akis", "efgh"));
    }

}