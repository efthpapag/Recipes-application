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
public class RegisterPresenterTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void accountCreation() {

        new RegisterPresenter().accountCreation("user", "pass");
        assertEquals("user", UserDao.allUsers.get(UserDao.allUsers.size() - 1).getUsername());
        assertEquals("pass", UserDao.allUsers.get(UserDao.allUsers.size() - 1).getPassword());
        assertEquals(null, new  RegisterPresenter().accountCreation("user", "p"));
        assertEquals("pass", UserDao.allUsers.get(UserDao.allUsers.size() - 1).getPassword());

    }
}