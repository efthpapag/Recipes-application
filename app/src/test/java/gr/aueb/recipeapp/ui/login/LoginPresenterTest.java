package gr.aueb.recipeapp.ui.login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.recipeapp.dao.UserDao;

import static org.junit.Assert.*;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class LoginPresenterTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login() {

        assertEquals(UserDao.allUsers.get(0), new LoginPresenter().login("username", "password"));
        assertEquals(null, new LoginPresenter().login("u", "password"));
        assertEquals(null, new LoginPresenter().login("username", "p"));

    }

    @Test
    public void isAdmin() {

        UserDao.accountCreation("user", "pass");

        assertEquals(true, new LoginPresenter().isAdmin("username", "password"));
        assertEquals(false, new LoginPresenter().isAdmin("user", "pass"));

    }
}