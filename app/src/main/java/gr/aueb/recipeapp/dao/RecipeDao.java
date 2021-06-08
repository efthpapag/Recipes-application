package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;

import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipeDao {
    public static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

    /**
     *finds recipe by id
     * @param id
     * @return the recipe the id belongs to else null
     */
    public Recipe find(int id){
        for (Recipe r : allRecipes){
            if (r.getId() == id){
                return r;
            }
        }
        return null;
    }

    /**
     *adds recipe to all Recipes list
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     * @param user
     */
    public void add(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        Recipe r = new Recipe( id, name, courseType, prepTime, portion, steps, ingredients, user);
        allRecipes.add(r);
    }

    /**
     * removes recipe from all Recipes list
     * @param id
     */
    public void remove(int id){
        Recipe r = find(id);
        allRecipes.remove(r);
    }

    /**
     *edits recipe parameters
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     * @param user
     */
    public void update(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        remove(id);
        add(id, name, courseType, prepTime, portion, steps, ingredients, user);
    }
}
