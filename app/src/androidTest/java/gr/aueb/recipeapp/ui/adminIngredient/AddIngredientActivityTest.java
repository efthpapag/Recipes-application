package gr.aueb.recipeapp.ui.adminIngredient;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Ingredient;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class AddIngredientActivityTest{

    @Rule
    public ActivityTestRule<AddIngredientActivity> activityRule =
            new ActivityTestRule<>(AddIngredientActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {

        onView(withId(R.id.editTextName)).perform(clearText());
        onView((withId(R.id.editTextName))).perform(typeText("u"));

        onView(withId(R.id.editTextCalories)).perform(clearText());
        onView((withId(R.id.editTextCalories))).perform(typeText("9"), closeSoftKeyboard());

        onView((withId(R.id.confirmButtonIM))).perform(click());

        assertEquals("u", IngredientDao.allIngredients.get(IngredientDao.allIngredients.size() - 1 ).getName());
        assertEquals(9, IngredientDao.allIngredients.get(IngredientDao.allIngredients.size() - 1 ).getCalories());

    }

    @Test
    public void addWrong() throws Throwable {

        IngredientDao.allIngredients.add(new Ingredient("moustarda", 8));

        int i = IngredientDao.allIngredients.size();

        onView(withId(R.id.editTextName)).perform(clearText());
        onView((withId(R.id.editTextName))).perform(typeText("moustarda"));

        onView(withId(R.id.editTextCalories)).perform(clearText());
        onView((withId(R.id.editTextCalories))).perform(typeText("7"), closeSoftKeyboard());

        onView((withId(R.id.confirmButtonIM))).perform(click());

        assertEquals(i, IngredientDao.allIngredients.size());
        assertEquals(8, new IngredientDao().findIngredient("moustarda").getCalories());

    }
}