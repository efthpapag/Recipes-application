package gr.aueb.recipeapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {

    public static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();
    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private ArrayList<HashMap<Recipe, Date>> recipesRead;
    private ArrayList<Rating> ratings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recipesPublished = new ArrayList<Recipe>();
        this.recipesRead = new ArrayList<HashMap<Recipe, Date>>();
        this.ratings = new ArrayList<Rating>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Recipe> getRecipesPublished() {
        return recipesPublished;
    }

    public void setRecipesPublished(ArrayList<Recipe> recipesPublished) {
        this.recipesPublished = recipesPublished;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<HashMap<Recipe, Date>> getRecipesRead() {
        return recipesRead;
    }

    public void setRecipesRead(ArrayList<HashMap<Recipe, Date>> recipesRead) {
        this.recipesRead = recipesRead;
    }

    public void Publish(String name, String courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe r = new Recipe(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, this);
        this.recipesPublished.add(r);
        User.allRecipes.add(r);
        Recipe.idCounter++;
    }

    public void Remove(int id){
        for(Recipe r : recipesPublished){
            if(r.getId() == id){
                recipesPublished.remove(r);
                User.allRecipes.remove(r);
            }
        }
    }



}
