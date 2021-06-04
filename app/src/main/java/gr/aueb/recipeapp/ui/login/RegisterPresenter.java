package gr.aueb.recipeapp.ui.login;

import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.User;

public class RegisterPresenter {

    public User accountCreation(String name, String password){
        return UserDao.accountCreation(name, password);
    }

}
