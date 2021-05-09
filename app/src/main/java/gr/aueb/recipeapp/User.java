package gr.aueb.recipeapp;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private ArrayList<Recipe> recipesRead;
    private ArrayList<Rating> ratings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public ArrayList<Recipe> getRecipesRead() {
        return recipesRead;
    }

    public void setRecipesRead(ArrayList<Recipe> recipesRead) {
        this.recipesRead = recipesRead;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

}
