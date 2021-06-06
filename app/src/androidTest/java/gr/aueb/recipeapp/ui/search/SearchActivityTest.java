package gr.aueb.recipeapp.ui.search;

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
import gr.aueb.recipeapp.ui.recipePage.RateActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class SearchActivityTest {

    @Rule
    public ActivityTestRule<SearchActivity> activityRule =
            new ActivityTestRule<SearchActivity>(SearchActivity.class){
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent result = new Intent(targetContext, SearchActivity.class);
                    result.putExtra("user", "username");
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
    public void testappetizerButton() throws Throwable {

        onView(withHint("Time in minutes")).perform(clearText());
        onView((withHint("Time in minutes"))).perform(typeText("8"), closeSoftKeyboard());

        onView((withId(R.id.appetizerButton))).perform(click());

        onView((withId(R.id.selectIngredientsButton))).perform(click());

        onView(withId(R.id.confirmChoicesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

    }

    @Test
    public void testsaladButton() throws Throwable {

        onView(withHint("Time in minutes")).perform(clearText());
        onView((withHint("Time in minutes"))).perform(typeText("8"), closeSoftKeyboard());

        onView((withId(R.id.saladButton))).perform(click());

        onView((withId(R.id.selectIngredientsButton))).perform(click());

        onView(withId(R.id.confirmChoicesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

    }

    @Test
    public void testmainButton() throws Throwable {

        onView(withHint("Time in minutes")).perform(clearText());
        onView((withHint("Time in minutes"))).perform(typeText("8"), closeSoftKeyboard());

        onView((withId(R.id.mainButton))).perform(click());

        onView((withId(R.id.selectIngredientsButton))).perform(click());

        onView(withId(R.id.confirmChoicesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

    }

    @Test
    public void testdessertButton() throws Throwable {

        onView(withHint("Time in minutes")).perform(clearText());
        onView((withHint("Time in minutes"))).perform(typeText("8"), closeSoftKeyboard());

        onView((withId(R.id.dessertButton))).perform(click());

        onView((withId(R.id.selectIngredientsButton))).perform(click());

        onView(withId(R.id.confirmChoicesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.listView)).check(matches(isDisplayed()));

    }

}