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
     *
     * @param name
     * @param password
     * @return
     */
    public User login(String name, String password){
        return UserDao.login(name, password);
    }

    /**
     *
     * @param name
     * @param password
     * @return
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
