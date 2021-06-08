package gr.aueb.recipeapp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Collections;
import java.util.Iterator;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class User {

    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private HashMap<Integer, Date> recipesRead;
    private HashMap<Integer, Rating> ratings;

    /**
     *constructor of User class
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recipesPublished = new ArrayList<Recipe>();
        this.recipesRead = new HashMap<Integer, Date>();
        this.ratings = new HashMap<Integer, Rating>();
    }

    /**
     * returns the username of the user
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets the username of the user
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * returns the password of the user
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password of the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns the recipes that the user has published
     * @return recipes that the user has published
     */
    public ArrayList<Recipe> getRecipesPublished() {
        return recipesPublished;
    }

    /**
     * sets the recipes that the user has published
     * @param recipesPublished
     */
    public void setRecipesPublished(ArrayList<Recipe> recipesPublished) {
        this.recipesPublished = recipesPublished;
    }

    /**
     * returns the ratings that the user has submitted
     * @return ratings that the user has submitted
     */
    public HashMap<Integer, Rating> getRatings() {
        return ratings;
    }

    /**
     * sets the ratings that the user has submitted
     * @param ratings
     */
    public void setRatings(HashMap<Integer, Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     * returns the recipes that the user has read
     * @return recipes that the user has read
     */
    public HashMap<Integer, Date> getRecipesRead() {
        return recipesRead;
    }

    /**
     * sets the recipes that the user has read
     * @param recipesRead
     */
    public void setRecipesRead(HashMap<Integer, Date> recipesRead) {
        this.recipesRead = recipesRead;
    }

}
