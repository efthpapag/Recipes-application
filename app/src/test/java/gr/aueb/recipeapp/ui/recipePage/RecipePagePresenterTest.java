package gr.aueb.recipeapp.ui.recipePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.userRecipes.RecipeManagementPresenter;
import gr.aueb.recipeapp.ui.userRecipes.UserRecipesPresenter;

import static org.junit.Assert.*;

public class RecipePagePresenterTest {

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
    public void rate() {

        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        User user2 = new User("Barbarigou", "efgh");
        new RecipeManagementPresenter(user).publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        new RecipePagePresenter(user2).rate(0, RatingLevel.Negative);
        assertEquals(RatingLevel.Negative, user2.getRatings().get(0).getRating());
        new RecipePagePresenter(user2).rate(1, RatingLevel.Positive);
        assertEquals(RatingLevel.Negative, user2.getRatings().get(0).getRating());

    }

    @Test
    public void addOnRead() {

        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        User user2 = new User("Barbarigou", "efgh");
        new RecipeManagementPresenter(user).publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        Recipe r;
        int id = -1;
        for(Recipe re : RecipeDao.allRecipes){
            if(re.getName().equals("Pork chops with honey and mustard")){
                id = re.getId();
            }
        }
        new RecipePagePresenter(user2).addOnRead(new RecipeDao().find(id));
        assertNotNull(user2.getRecipesRead().get(id));

    }
}