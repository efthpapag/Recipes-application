package gr.aueb.recipeapp.ui.userRecipes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

import static org.junit.Assert.*;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class UserRecipesPresenterTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        this.user = new User("Mamalakis", "abcd");
        RecipeDao.allRecipes.clear();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void remove() {

        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        new RecipeManagementPresenter(user).publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        new UserRecipesPresenter(user).remove(1);
        assertFalse(RecipeDao.allRecipes.isEmpty());
        new UserRecipesPresenter(user).remove(0);
        assertTrue(RecipeDao.allRecipes.isEmpty());

    }
}