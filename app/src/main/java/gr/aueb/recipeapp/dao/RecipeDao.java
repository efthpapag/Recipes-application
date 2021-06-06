package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

public class RecipeDao {
    public static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();


    public Recipe find(int id){
        for (Recipe r : allRecipes){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    public void add(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        Recipe r = new Recipe( id, name, courseType, prepTime, portion, steps, ingredients, user);
        allRecipes.add(r);
    }

    public void remove(int id){
        Recipe r = find(id);
        allRecipes.remove(r);
    }

    public void update(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        remove(id);
        add(id, name, courseType, prepTime, portion, steps, ingredients, user);
    }
}
