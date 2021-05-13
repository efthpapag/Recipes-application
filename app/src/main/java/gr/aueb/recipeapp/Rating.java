package gr.aueb.recipeapp;

import java.util.Date;

public class Rating {

    private RatingLevel rating;
    private Date date;
    private User user;
    private Recipe recipe;

    public Rating(RatingLevel rating, Date date, User user, Recipe recipe) {
        this.rating = rating;
        this.date = date;
        this.user = user;
        this.recipe = recipe;
    }

    public RatingLevel getRating() {
        return rating;
    }

    public void setRating(RatingLevel rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
