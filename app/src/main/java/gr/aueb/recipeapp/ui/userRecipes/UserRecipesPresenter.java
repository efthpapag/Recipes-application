package gr.aueb.recipeapp.ui.userRecipes;

import java.util.ArrayList;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.User;

public class UserRecipesPresenter {

    //public UserRecipesView userRecipesView;
    public UserDao userDao = new UserDao();
    public User user;
    public RecipeDao recipeDao = new RecipeDao();

    UserRecipesPresenter(User user){
        this.user = user;
    }

    public void remove(int id){
        userDao.remove(user, id);
        recipeDao.remove(id);
    }

}
