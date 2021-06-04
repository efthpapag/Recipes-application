package gr.aueb.recipeapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import gr.aueb.recipeapp.domain.Admin;
import gr.aueb.recipeapp.domain.Rating;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.User;

public class UserDao {

    public static ArrayList<User> allUsers = new ArrayList<User>(Arrays.asList(new User[]{new Admin("username", "password"), new Admin("Koytsioykiadis", "password"), new Admin("Kakatsinos", "password"), new Admin("Papaefthymiou", "password"), new User("Mamalakis", "1234")}));

    public void publish(User user, Recipe r){
        user.getRecipesPublished().add(r);
    }

    public void remove(User user, int id){
        Iterator<Recipe> iter = user.getRecipesPublished().iterator();
        while (iter.hasNext()){
            Recipe r = iter.next();
            if (r.getId() == id){
                iter.remove();
            }
        }
    }

    public void edit(User user, Recipe recipe){
        for (Recipe r : user.getRecipesPublished()){
            if (r.getId() == recipe.getId()){
                remove(user, r.getId());
                user.getRecipesPublished().add(recipe);
            }
        }
    }

    public void rate(User user, int id, RatingLevel level){
        for (Recipe r : RecipeDao.allRecipes){
            if (r.getId() == id){
                user.getRatings().put(id, new Rating(level, new Date(), user, r));
                break;
            }
        }
    }


    public static User accountCreation(String name, String password){
        User user = new User(name, password);
        allUsers.add(user);
        return user;
    }

    public static User login(String name, String password){
        for (User u : allUsers){
            if (u.getUsername().equals(name) & u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }

}
