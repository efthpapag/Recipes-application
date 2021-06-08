package gr.aueb.recipeapp.ui.recipePage;

import java.util.Date;

import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Rating;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipePagePresenter {

    public UserDao userDao = new UserDao();
    public User user;

    /**
     * constructor of RecipeRecommendationsAdapter class
     * @param user
     */
    public RecipePagePresenter(User user){
        this.user = user;
    }

    /**
     *rates recipe by id
     * @param id
     * @param level
     */
    public void rate(int id, RatingLevel level){
        userDao.rate(this.user, id, level);
    }

    /**
     *
     * @param r
     */
    public void addOnRead(Recipe r){
        new UserDao().addOnRead(r, user);
    }

}
