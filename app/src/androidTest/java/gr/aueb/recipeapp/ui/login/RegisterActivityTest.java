package gr.aueb.recipeapp.ui.login;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.dao.UserDao;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class RegisterActivityTest {


    @Rule
    public ActivityTestRule<RegisterActivity> activityRule =
            new ActivityTestRule<>(RegisterActivity.class);
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRegisterCorrect() throws Throwable {

        onView(withHint("Username")).perform(clearText());
        onView((withHint("Username"))).perform(typeText("u"));

        onView(withHint("Password")).perform(clearText());
        onView((withHint("Password"))).perform(typeText("p"));

        onView((withId(R.id.appetizerButton))).perform(click());

        assertEquals("u", UserDao.allUsers.get(UserDao.allUsers.size() - 1 ).getUsername());
        assertEquals("p", UserDao.allUsers.get(UserDao.allUsers.size() - 1 ).getPassword());

    }

    @Test
    public void testRegisterWrong() throws Throwable {

        int i = UserDao.allUsers.size();

        onView(withHint("Username")).perform(clearText());
        onView((withHint("Username"))).perform(typeText("username"));

        onView(withHint("Password")).perform(clearText());
        onView((withHint("Password"))).perform(typeText("p"));

        onView((withId(R.id.registerButton))).perform(click());

        assertEquals(i, UserDao.allUsers.size());
        assertEquals("password", UserDao.findUser("username").getPassword());
    }


}