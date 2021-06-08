package gr.aueb.recipeapp.domain;

import java.util.Date;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class Rating {

    private RatingLevel rating;
    private Date date;
    private User user;
    private Recipe recipe;

    /**
     *constructor of Rating class
     * @param rating
     * @param date
     * @param user
     * @param recipe
     */
    public Rating(RatingLevel rating, Date date, User user, Recipe recipe) {
        this.rating = rating;
        this.date = date;
        this.user = user;
        this.recipe = recipe;
    }

    /**
     * returns the rating level of the rating
     * @return rating level
     */
    public RatingLevel getRating() {
        return rating;
    }

    /**
     * sets the rating level of the rating
     * @param rating
     */
    public void setRating(RatingLevel rating) {
        this.rating = rating;
    }

    /**
     * returns the date that the rating was submitted
     * @return the date that the rating was submitted
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets the date that the rating was submitted
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * returns the user that submitted the rating
     * @return user that submitted the rating
     */
    public User getUser() {
        return user;
    }

    /**
     * sets the user that submitted the rating
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * returns the recipe for which the rating is submitted
     * @return recipe for which the rating is submitted
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * sets the recipe for which the rating is submitted
     * @param recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
