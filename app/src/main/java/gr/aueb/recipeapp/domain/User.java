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
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public ArrayList<Recipe> getRecipesPublished() {
        return recipesPublished;
    }

    /**
     *
     * @param recipesPublished
     */
    public void setRecipesPublished(ArrayList<Recipe> recipesPublished) {
        this.recipesPublished = recipesPublished;
    }

    /**
     *
     * @return
     */
    public HashMap<Integer, Rating> getRatings() {
        return ratings;
    }

    /**
     *
     * @param ratings
     */
    public void setRatings(HashMap<Integer, Rating> ratings) {
        this.ratings = ratings;
    }

    /**
     *
     * @return
     */
    public HashMap<Integer, Date> getRecipesRead() {
        return recipesRead;
    }

    /**
     *
     * @param recipesRead
     */
    public void setRecipesRead(HashMap<Integer, Date> recipesRead) {
        this.recipesRead = recipesRead;
    }

}
