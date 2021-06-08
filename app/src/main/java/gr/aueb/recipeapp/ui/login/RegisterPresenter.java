package gr.aueb.recipeapp.ui.login;

import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RegisterPresenter {
    /**
     *creates new account for a new user
     * @param name
     * @param password
     * @return the new user
     */
    public User accountCreation(String name, String password){
        for (User u : UserDao.allUsers){
            if (u.getUsername().equals(name)){
                return null;
            }
        }
        return UserDao.accountCreation(name, password);
    }

}
