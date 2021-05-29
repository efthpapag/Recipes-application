package gr.aueb.recipeapp.ui.search;

import java.util.ArrayList;
import java.util.Collections;

import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.domain.User;

public class SearchPresenter {

    //public SearchView searchView;
    public UserDao userDao;
    public User user;

    SearchPresenter(/*SearchView searchView*/){

    }

    public ArrayList<Recipe> search(int time, ArrayList<RecipeIngredient> availableIngredients, CourseType courseType){
        ArrayList<Recipe> recommendations = new ArrayList<Recipe>();
        for(Recipe r : RecipeDao.allRecipes){
            boolean eligible = true;
            for(RecipeIngredient i : r.getIngredients()){
                boolean found = false;
                for(RecipeIngredient j : availableIngredients){
                    if((i.getIngredientType().getName().equals(j.getIngredientType().getName())) & (j.getQuantity() >= i.getQuantity())){
                        found = true;
                        break;
                    }
                }
                if(!found){
                    eligible = false;
                    break;
                }
            }
            if(eligible & r.getCourseType().equals(courseType)){
                recommendations.add(r);
            }
        }
        boolean flag = false;
        for(Recipe r : recommendations){
            if(r.getPrepTime() <= time){
                flag = true;
            }
        }
        if(flag){
            for (Recipe r : recommendations){
                if (r.getPrepTime() > time){
                    recommendations.remove(r);
                }
            }
            Collections.sort(recommendations, new Recipe.RecipeComparator(user));
        }
        else{
            Collections.sort(recommendations, new Recipe.RecipeComparatorByTime(user));
        }
        return recommendations;
    }
}
