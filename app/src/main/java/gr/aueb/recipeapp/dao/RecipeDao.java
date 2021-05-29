package gr.aueb.recipeapp.dao;

import java.util.ArrayList;

import gr.aueb.recipeapp.domain.Recipe;

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

    public void add(Recipe r){
        allRecipes.add(r);
    }

    public void remove(int id){
        Recipe r = find(id);
        allRecipes.remove(r);
    }

    public void update(Recipe recipe){
        remove(recipe.getId());
        add(recipe);
    }
}
