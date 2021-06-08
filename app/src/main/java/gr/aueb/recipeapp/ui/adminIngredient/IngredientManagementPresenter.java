package gr.aueb.recipeapp.ui.adminIngredient;

import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class IngredientManagementPresenter {

    IngredientDao ingredientDao = new IngredientDao();

    /**
     * creates a new ingredient and adds it on the list
     * @param name
     * @param calories
     * @return the ingredient if it is created successfully
     */
    public Ingredient registerIngredient(String name, int calories){
        for (Ingredient i : IngredientDao.allIngredients){
            if (i.getName().equals(name)){
                return null;
            }
        }
        return ingredientDao.registerIngredient(name, calories);
    }

    /**
     * edits the parameters of the ingredient
     * @param oldName
     * @param newName
     * @param newCalories
     */
    public void editIngredient(String oldName, String newName, int newCalories){
        ingredientDao.editIngredient(oldName, newName, newCalories);
    }

}
