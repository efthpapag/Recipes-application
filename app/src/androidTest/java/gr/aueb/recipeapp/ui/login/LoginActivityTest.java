package gr.aueb.recipeapp.ui.login;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.ui.mainPage.AdminMainPageActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {


    @Rule
    public ActivityTestRule<LoginActivity> activityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testLogIn() throws Throwable {

        onView(withHint("Username")).perform(clearText());
        onView((withHint("Username"))).perform(typeText("username"));

        onView(withHint("Password")).perform(clearText());
        onView((withHint("Password"))).perform(typeText("password"));

        onView((withId(R.id.loginButton))).perform(click());

        onView(withId(R.id.searchRecipesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.recipesButton)).check(matches(isDisplayed()));
        onView(withId(R.id.ingredientsButton)).check(matches(isDisplayed()));

    }

}