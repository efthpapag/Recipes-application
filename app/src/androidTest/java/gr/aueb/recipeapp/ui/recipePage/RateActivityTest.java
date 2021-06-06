package gr.aueb.recipeapp.ui.recipePage;

import android.content.Context;
import android.content.Intent;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

public class RateActivityTest {

    @Rule
    public ActivityTestRule<RateActivity> activityRule =
            new ActivityTestRule<RateActivity>(RateActivity.class){
                @Override
                protected Intent getActivityIntent() {
                    RecipeDao.allRecipes.add(new Recipe(0, "meli", CourseType.Dessert, 6, 5, "text", new ArrayList<RecipeIngredient>(Arrays.asList(new RecipeIngredient[]{new RecipeIngredient(1, new Ingredient("meli", 5))})), UserDao.allUsers.get(0)));
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent result = new Intent(targetContext, RateActivity.class);
                    result.putExtra("user", "username");
                    result.putExtra("Recipe", 0);
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
    public void testnegativeButton() throws Throwable {

        onView((withId(R.id.negativeButton))).perform(click());

        onView((withId(R.id.confirmButton))).perform(click());

        assertEquals(RatingLevel.Negative, UserDao.findUser("username").getRatings().get(0).getRating());

    }

    @Test
    public void testneutralButton() throws Throwable {

        onView((withId(R.id.neutralButton))).perform(click());

        onView((withId(R.id.confirmButton))).perform(click());

        assertEquals(RatingLevel.Neutral, UserDao.findUser("username").getRatings().get(0).getRating());

    }

    @Test
    public void testpositiveButton() throws Throwable {

        onView((withId(R.id.positiveButton))).perform(click());

        onView((withId(R.id.confirmButton))).perform(click());

        assertEquals(RatingLevel.Positive, UserDao.findUser("username").getRatings().get(0).getRating());

    }


}