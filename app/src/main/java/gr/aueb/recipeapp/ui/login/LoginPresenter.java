package gr.aueb.recipeapp.ui.login;

import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.User;

public class LoginPresenter {

    public User accountCreation(String name, String password){
        for (User u : UserDao.allUsers){
            if (u.getUsername().equals(name)){
                return null;
            }
        }
        return UserDao.accountCreation(name, password);
    }

    public User login(String name, String password){
        for (User u : UserDao.allUsers){
            if (u.getUsername().equals(name)){
                return UserDao.login(name, password);
            }
        }
        return null;
    }
}
