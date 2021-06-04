package gr.aueb.recipeapp.ui.adminIngredient;

import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Ingredient;

public class IngredientManagementPresenter {

    IngredientDao ingredientDao = new IngredientDao();

    public void registerIngredient(String name, int calories){
        ingredientDao.registerIngredient(new Ingredient(name, calories));
    }

    public void editIngredient(String oldName, String newName, int newCalories){
        ingredientDao.editIngredient(oldName, newName, newCalories);
    }

}
