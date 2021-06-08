package gr.aueb.recipeapp.ui.login;

import gr.aueb.recipeapp.dao.AdminDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class LoginPresenter {
    /**
     *checks if the credentials belong to a user
     * @param name
     * @param password
     * @return the user with this credentials or null if the user does not exists
     */
    public User login(String name, String password){
        return UserDao.login(name, password);
    }

    /**
     *checks if the user is an admin
     * @param name
     * @param password
     * @return true if the user is an admin or false if the user is an admin
     */
    public Boolean isAdmin(String name, String password){
        for (Admin a : AdminDao.allAdmins){
            if(a.getUsername().equals(name) & a.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
