package gr.aueb.recipeapp.ui.adminIngredient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Ingredient;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static gr.aueb.recipeapp.ui.adminIngredient.IngredientManagementAdapter.ingn;
import static org.junit.Assert.*;

public class EditIngredientActivityTest {

    @Rule
    public ActivityTestRule<EditIngredientActivity> mActivityRule =
            new ActivityTestRule<EditIngredientActivity>(EditIngredientActivity.class) {
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent result = new Intent(targetContext, EditIngredientActivity.class);
                    result.putExtra("ingredient_name", "moustarda");
                    result.putExtra("ingredient_calories", 8);
                    return result;
                }
            };

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void edit() {

        IngredientDao.allIngredients.add(new Ingredient("moustarda", 8));

        onView(withId(R.id.editTextName)).perform(clearText());
        onView((withId(R.id.editTextName))).perform(typeText("u"));

        onView(withId(R.id.editTextCalories)).perform(clearText());
        onView((withId(R.id.editTextCalories))).perform(typeText("9"), closeSoftKeyboard());

        onView((withId(R.id.confirmButtonIM))).perform(click());

        assertEquals("u", IngredientDao.allIngredients.get(IngredientDao.allIngredients.size() - 1 ).getName());
        assertEquals(9, IngredientDao.allIngredients.get(IngredientDao.allIngredients.size() - 1 ).getCalories());

    }

}