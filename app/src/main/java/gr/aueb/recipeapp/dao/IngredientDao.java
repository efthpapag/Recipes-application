package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.User;

public class IngredientDao {


    public static ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();

    /**
     *adds ingredient to all Ingredients list
     * @param Name
     * @param Calories
     * @return
     */
    public Ingredient registerIngredient(String Name, int Calories){
        Ingredient i = new Ingredient(Name, Calories);
        allIngredients.add(i);
        return i;
    }

    /**
     *modifies ingredient parameters
     * @param oldName
     * @param newName
     * @param newCalories
     */
    public void editIngredient(String oldName, String newName, int newCalories){
        for (Ingredient ing : IngredientDao.allIngredients){
            if (ing.getName().equals(oldName)){
                ing.setName(newName);
                ing.setCalories(newCalories);
            }
        }
    }

    /**
     *finds ingredient by name
     * @param name
     * @return
     */
    public Ingredient findIngredient(String name){
        for (Ingredient i : allIngredients){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }

}
