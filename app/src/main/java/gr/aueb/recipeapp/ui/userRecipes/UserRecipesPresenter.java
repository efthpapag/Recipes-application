package gr.aueb.recipeapp.ui.userRecipes;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class UserRecipesPresenter {

    public UserDao userDao = new UserDao();
    public User user;
    public RecipeDao recipeDao = new RecipeDao();

    /**
     *
     * @param user
     */
    UserRecipesPresenter(User user){
        this.user = user;
    }

    /**
     *
     * @param id
     */
    public void remove(int id){
        userDao.remove(user, id);
        recipeDao.remove(id);
    }

}
