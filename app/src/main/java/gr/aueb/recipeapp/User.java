package gr.aueb.recipeapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Collections;
import java.util.Iterator;

public class User {

    private String username;
    private String password;
    private ArrayList<Recipe> recipesPublished;
    private HashMap<Recipe, Date> recipesRead;
    private HashMap<Integer, Rating> ratings;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.recipesPublished = new ArrayList<Recipe>();
        this.recipesRead = new HashMap<Recipe, Date>();
        this.ratings = new HashMap<Integer, Rating>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Recipe> getRecipesPublished() {
        return recipesPublished;
    }

    public void setRecipesPublished(ArrayList<Recipe> recipesPublished) {
        this.recipesPublished = recipesPublished;
    }

    public HashMap<Integer, Rating> getRatings() {
        return ratings;
    }

    public void setRatings(HashMap<Integer, Rating> ratings) {
        this.ratings = ratings;
    }

    public HashMap<Recipe, Date> getRecipesRead() {
        return recipesRead;
    }

    public void setRecipesRead(HashMap<Recipe, Date> recipesRead) {
        this.recipesRead = recipesRead;
    }

    public void publish(String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        Recipe r = new Recipe(Recipe.idCounter, name, courseType, prepTime, portion, steps, ingredients, this);
        this.recipesPublished.add(r);
        Recipe.allRecipes.add(r);
        Recipe.idCounter++;
    }

    public void remove(int id){
        Iterator<Recipe> iter = this.recipesPublished.iterator();
        while (iter.hasNext()){
            Recipe r = iter.next();
            if (r.getId() == id){
                iter.remove();
                Recipe.allRecipes.remove(r);
            }
        }
    }

    public void edit(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients){
        for (Recipe r : this.recipesPublished){
            if (r.getId() == id){
                remove(r.getId());
                Recipe recipe = new Recipe(id, name, courseType, prepTime, portion, steps, ingredients, this);
                this.recipesPublished.add(recipe);
                Recipe.allRecipes.add(recipe);
            }
        }
    }

    public void rate(int id, RatingLevel level){
        for (Recipe r : Recipe.allRecipes){
            if (r.getId() == id){
                this.ratings.put(id, new Rating(level, new Date(), this, r));
                break;
            }
        }
    }

    public ArrayList<Recipe> search(int time, ArrayList<RecipeIngredient> availableIngredients, CourseType courseType){
        ArrayList<Recipe> recommendations = new ArrayList<Recipe>();
        for(Recipe r : Recipe.allRecipes){
            boolean eligible = true;
            for(RecipeIngredient i : availableIngredients){
                boolean found = false;
                for(RecipeIngredient j : r.getIngredients()){
                    if((i.getIngredientType() == j.getIngredientType()) & (i.getQuantity() >= j.getQuantity())){
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
            Collections.sort(recommendations, new Recipe.RecipeComparator(this));
        }
        else{
            Collections.sort(recommendations, new Recipe.RecipeComparatorByTime(this));
        }
        return recommendations;
    }



}
