package gr.aueb.recipeapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User {

    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private HashMap<Integer, Date> recipesRead;
    private ArrayList<Rating> ratings;
    public static ArrayList<Recipe> allRecipes = new ArrayList<Recipe>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recipesPublished = new ArrayList<Recipe>();
        this.recipesRead = new HashMap<Integer, Date>();
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

    public HashMap<Integer, Date> getRecipesRead() {
        return recipesRead;
    }

    public void setRecipesRead(HashMap<Integer,Date> recipesRead) {
        this.recipesRead = recipesRead;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public void publish(String name, String courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe r = new Recipe(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, this);
        this.recipesPublished.add(r);
        User.allRecipes.add(r);
        Recipe.idCounter++;
    }

    public void remove(int id){
        for (Recipe r : this.recipesPublished){
            if (r.getId() == id){
                this.recipesPublished.remove(r);
                User.allRecipes.remove(r);
            }
        }
    }

    public void edit(int id, String name, String courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        for (Recipe r : this.recipesPublished){
            if (r.getId() == id){
                remove(r.getId());
                Recipe recipe = new Recipe(id, name, courseType, prepTime, portion, steps, ingredients, this);
                this.recipesPublished.add(recipe);
                User.allRecipes.add(recipe);
            }
        }
    }

    public void rate(int id, RatingLevels level){
        for (Recipe r : this.recipesPublished){
            if (r.getId() == id){
                this.ratings.add(new Rating(level, new Date(), this, r));
                break;
            }
        }
    }
}
