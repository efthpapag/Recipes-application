package gr.aueb.recipeapp.dao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Rating;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class UserDao {

    public static ArrayList<User> allUsers = new ArrayList<User>(Arrays.asList(new User[]{new Admin("username", "password"), new Admin("Koytsioykiadis", "password"), new Admin("Kakatsinos", "password"), new Admin("Papaefthymiou", "password"), new User("Mamalakis", "1234")}));

    /**
     * publishs new recipe
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     * @param user
     */
    public void publish(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        Recipe r = new Recipe( id, name, courseType, prepTime, portion, steps, ingredients, user);
        user.getRecipesPublished().add(r);
    }

    /**
     * removes recipe from the app
     * @param user
     * @param id
     */
    public void remove(User user, int id){
        Iterator<Recipe> iter = user.getRecipesPublished().iterator();
        while (iter.hasNext()){
            Recipe r = iter.next();
            if (r.getId() == id){
                iter.remove();
            }
        }
    }

    /**
     *edits a recipe's parameters
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     * @param user
     */
    public void edit(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user){
        for (Recipe r : user.getRecipesPublished()){
            if (r.getId() == id){
                remove(user, r.getId());
                user.getRecipesPublished().add(new Recipe(id, name, courseType, prepTime, portion, steps, ingredients, user));
            }
        }
    }

    /**
     *updates a recipe's rating
     * @param user
     * @param id
     * @param level
     */
    public void rate(User user, int id, RatingLevel level){
        for (Recipe r : RecipeDao.allRecipes){
            if (r.getId() == id){
                user.getRatings().put(id, new Rating(level, new Date(), user, r));
                break;
            }
        }
    }

    /**
     * adds a recipe on the list of read recipes of the user and the date when it was read
     * @param r
     * @param u
     */
    public void addOnRead(Recipe r, User u){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        u.getRecipesRead().put(r.getId(), date);
    }

    /**
     *creates new account for a new user
     * @param name
     * @param password
     * @return the new user
     */
    public static User accountCreation(String name, String password){
        User user = new User(name, password);
        allUsers.add(user);
        return user;
    }

    /**
     *checks if the credentials belong to a user
     * @param name
     * @param password
     * @return the user with this credentials or null if the user does not exists
     */
    public static User login(String name, String password){
        for (User u : allUsers){
            if (u.getUsername().equals(name) & u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

    /**
     *finds a user by username
     * @param name
     * @return the user the name belongs to
     */
    public static User findUser(String name){
        for (User u : allUsers){
            if (u.getUsername().equals(name)){
                return u;
            }
        }
        return null;
    }

}
