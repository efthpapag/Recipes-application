package gr.aueb.recipeapp.ui.userRecipes;

import java.util.ArrayList;
import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipeManagementPresenter {


    public UserDao userDao = new UserDao();
    public User user;
    public RecipeDao recipeDao = new RecipeDao();

    /**
     *
     * @param user
     */
    public RecipeManagementPresenter(User user){
        this.user = user;
    }

    /**
     *
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     */
    public void publish(String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        userDao.publish(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, user);
        recipeDao.add(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, user);
        Recipe.idCounter++;
    }

    /**
     *
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     */
    public void edit(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe recipe = new Recipe(id, name, courseType, prepTime, portion, steps, ingredients, user);
        userDao.edit(id, name, courseType, prepTime, portion, steps, ingredients, user);
        recipeDao.update(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, user);
    }
}
