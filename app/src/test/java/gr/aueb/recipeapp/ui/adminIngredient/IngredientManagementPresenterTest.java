package gr.aueb.recipeapp.ui.adminIngredient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.Ingredient;

import static org.junit.Assert.*;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class IngredientManagementPresenterTest {

    private Admin a;

    @Before
    public void setUp() throws Exception {
        this.a = new Admin("Mamalakis", "abcd");
        IngredientDao.allIngredients.clear();
    }

    @After
    public void tearDown() throws Exception {
        this.a = null;
        IngredientDao.allIngredients.clear();
    }

    @Test
    public void registerIngredient() {
        new IngredientManagementPresenter().registerIngredient("Pork chop", 1);
        assertEquals("Pork chop", new IngredientDao().findIngredient("Pork chop").getName());
        assertEquals(1, new IngredientDao().findIngredient("Pork chop").getCalories());

        Ingredient t = new IngredientManagementPresenter().registerIngredient("Pork chop", 9);
        assertEquals(null,t);

    }

    @Test
    public void editIngredient() {
        new IngredientManagementPresenter().registerIngredient("Steak", 1);
        new IngredientManagementPresenter().editIngredient("Steak", "Pork chop", 2);
        assertEquals("Pork chop", new IngredientDao().findIngredient("Pork chop").getName());
        assertEquals(2, new IngredientDao().findIngredient("Pork chop").getCalories());
    }
}