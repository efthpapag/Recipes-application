package gr.aueb.recipeapp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Collections;
import java.util.Iterator;

public class User {

    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private HashMap<Integer, Date> recipesRead;
    private HashMap<Integer, Rating> ratings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recipesPublished = new ArrayList<Recipe>();
        this.recipesRead = new HashMap<Integer, Date>();
        this.ratings = new HashMap<Integer, Rating>();
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

    public HashMap<Integer, Rating> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<Integer, Rating> ratings) {
        this.ratings = ratings;
    }

    public HashMap<Integer, Date> getRecipesRead() {
        return recipesRead;
    }

    public void setRecipesRead(HashMap<Integer, Date> recipesRead) {
        this.recipesRead = recipesRead;
    }

}
