package gr.aueb.recipeapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ingredient {

    public static ArrayList<Ingredient> allIngredients = new ArrayList<Ingredient>();
    private String name;
    private int calories;

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
    
}
