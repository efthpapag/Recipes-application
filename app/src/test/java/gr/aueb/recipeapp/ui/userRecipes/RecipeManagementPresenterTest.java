package gr.aueb.recipeapp.ui.userRecipes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

import static org.junit.Assert.*;

public class RecipeManagementPresenterTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        this.user = new User("Mamalakis", "abcd");
    }

    @After
    public void tearDown() throws Exception {
        this.user = null;
        RecipeDao.allRecipes.clear();
        Recipe.idCounter = 0;
        UserDao.allUsers.clear();
    }

    @Test
    public void publish() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        new RecipeManagementPresenter(user).publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        assertEquals("Pork chops with honey and mustard", user.getRecipesPublished().get(0).getName());
        assertEquals("Pork chops with honey and mustard", RecipeDao.allRecipes.get(0).getName());
    }

    @Test
    public void edit() {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        new RecipeManagementPresenter(user).publish("Pork chops with honey", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        new RecipeManagementPresenter(user).edit(0, "Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        assertEquals("Pork chops with honey and mustard", user.getRecipesPublished().get(0).getName());
        new RecipeManagementPresenter(user).edit(1, "Pork chops with honey", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        assertEquals("Pork chops with honey and mustard", user.getRecipesPublished().get(0).getName());
    }
}