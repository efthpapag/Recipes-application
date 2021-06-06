package gr.aueb.recipeapp.ui.mainPage;

import android.content.Context;
import android.content.Intent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.ui.adminIngredient.EditIngredientActivity;
import gr.aueb.recipeapp.ui.login.LoginActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class AdminMainPageActivityTest {

    @Rule
    public ActivityTestRule<AdminMainPageActivity> activityRule =
            new ActivityTestRule<AdminMainPageActivity>(AdminMainPageActivity.class){
                @Override
                protected Intent getActivityIntent() {
                    Context targetContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
                    Intent result = new Intent(targetContext, AdminMainPageActivity.class);
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
    public void testsearchRecipesButton() throws Throwable {

        onView((withId(R.id.searchRecipesButton))).perform(click());

        onView(withId(R.id.textView3)).check(matches(isDisplayed()));
        onView(withId(R.id.textView4)).check(matches(isDisplayed()));
        onView(withId(R.id.editTime)).check(matches(isDisplayed()));
        onView(withId(R.id.appetizerButton)).check(matches(isDisplayed()));
        onView(withId(R.id.saladButton)).check(matches(isDisplayed()));
        onView(withId(R.id.mainButton)).check(matches(isDisplayed()));
        onView(withId(R.id.dessertButton)).check(matches(isDisplayed()));
        onView(withId(R.id.selectIngredientsButton)).check(matches(isDisplayed()));

    }

    @Test
    public void testrecipesButton() throws Throwable {

        onView((withId(R.id.recipesButton))).perform(click());

        onView(withId(R.id.list1)).check(matches(isDisplayed()));
        onView(withId(R.id.addButton)).check(matches(isDisplayed()));

    }

    @Test
    public void testingredientsButton() throws Throwable {

        onView((withId(R.id.ingredientsButton))).perform(click());

        onView(withId(R.id.list1)).check(matches(isDisplayed()));
        onView(withId(R.id.addButton)).check(matches(isDisplayed()));

    }
}