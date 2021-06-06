package gr.aueb.recipeapp.ui.recipePage;

import java.util.Date;

import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Rating;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.User;

public class RecipePagePresenter {

    //public RecipePageView recipePageView;
    public UserDao userDao = new UserDao();
    public User user;

    public RecipePagePresenter(User user){
        this.user = user;
    }

    public void rate(int id, RatingLevel level){
        userDao.rate(this.user, id, level);
    }

    public void addOnRead(Recipe r){
        new UserDao().addOnRead(r, user);
    }

}
