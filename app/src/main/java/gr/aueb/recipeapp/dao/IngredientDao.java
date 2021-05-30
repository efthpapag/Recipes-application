package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import gr.aueb.recipeapp.domain.Ingredient;

public class IngredientDao {

    public static ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();

    public void registerIngredient(Ingredient i){
        allIngredients.add(i);
    }

    public void editIngredient(String oldName, String newName, int newCalories){
        for (Ingredient ing : IngredientDao.allIngredients){
            if (ing.getName().equals(oldName)){
                ing.setName(newName);
                ing.setCalories(newCalories);
            }
        }
    }
}