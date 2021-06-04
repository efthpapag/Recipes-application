package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;

public class RecipeDao {
    public static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>(/*Arrays.asList(new Recipe[]{new Recipe(1,"mprizolew me meli", CourseType.Main, 5, 1, "text", new ArrayList<>(new)*/);

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
