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
     *
     * @return
     */
    public RatingLevel getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(RatingLevel rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     *
     * @param recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}
