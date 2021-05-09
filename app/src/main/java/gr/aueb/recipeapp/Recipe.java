package gr.aueb.recipeapp;

import java.util.ArrayList;

public class Recipe {

    private int id;
    private String name;
    private String courseType;
    private int prepTime;
    private int portion;
    private String steps;
    private ArrayList<RecipeIngredient> ingredients;
    private User user;
    private Rating rating;

    public Recipe(int id, String name, String courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user) {
        this.id = id;
        this.name = name;
        this.courseType = courseType;
        this.prepTime = prepTime;
        this.portion = portion;
        this.steps = steps;
        this.ingredients = ingredients;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public ArrayList<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
