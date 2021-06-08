package gr.aueb.recipeapp.ui.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.recipePage.RecipePagePresenter;
import gr.aueb.recipeapp.ui.userRecipes.RecipeManagementPresenter;

import static org.junit.Assert.*;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class SearchPresenterTest {

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
    public void search() throws ParseException {
        ArrayList<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
        ingredients.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        ingredients.add(new RecipeIngredient( 1, new Ingredient("Mustard", 1)));
        ArrayList<RecipeIngredient> ingredients2 = new ArrayList<RecipeIngredient>();
        ingredients2.add(new RecipeIngredient(2, new Ingredient("Pork chop", 1)));
        ingredients2.add(new RecipeIngredient(2.5f, new Ingredient("Honey", 1)));
        new RecipeManagementPresenter(user).publish("Pork chops with honey and mustard", CourseType.Main, 8, 2, "Yada yada yada", ingredients);
        new RecipeManagementPresenter(user).publish("Pork chops with honey", CourseType.Main, 4, 2, "Yada yada yada", ingredients2);
        new RecipeManagementPresenter(user).publish("honey and mustard", CourseType.Appetizer, 4, 2, "Yada yada yada", ingredients);
        User user2 = new User("Lazarou", "efgh");
        ArrayList<Recipe> r;
        r = new SearchPresenter(user2).search(1, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals("Pork chops with honey and mustard", r.get(1).getName());
        r = new SearchPresenter(user2).search(10, ingredients2, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals(1, r.size());
        r = new SearchPresenter(user2).search(10, ingredients, CourseType.Appetizer);
        assertEquals("honey and mustard", r.get(0).getName());
        assertEquals(1, r.size());
        r = new SearchPresenter(user2).search(5, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey", r.get(0).getName());
        assertEquals(1, r.size());
        new RecipePagePresenter(user2).rate(0, RatingLevel.Positive);
        r = new SearchPresenter(user2).search(10, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey and mustard", r.get(0).getName());
        assertEquals("Pork chops with honey", r.get(1).getName());
        new RecipePagePresenter(user2).rate(0, RatingLevel.Neutral);
        HashMap<Integer, Date> h = new HashMap<Integer, Date>();
        h.put(0,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"));
        h.put(1,new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1999"));
        user2.setRecipesRead(h);
        r = new SearchPresenter(user2).search(10, ingredients, CourseType.Main);
        assertEquals("Pork chops with honey and mustard", r.get(0).getName());
        assertEquals("Pork chops with honey", r.get(1).getName());
    }
}