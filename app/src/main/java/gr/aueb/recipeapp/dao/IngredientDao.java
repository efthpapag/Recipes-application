package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.User;

public class IngredientDao {

    public static ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>(Arrays.asList(new Ingredient[]{new Ingredient("meli", 1), new Ingredient("mprizola", 2)}));

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
