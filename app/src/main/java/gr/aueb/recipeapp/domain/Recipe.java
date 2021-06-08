package gr.aueb.recipeapp.domain;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class Recipe{


    public static int idCounter = 0;
    private int id;
    private String name;
    private CourseType courseType;
    private int prepTime;
    private int portion;
    private String steps;
    private ArrayList<RecipeIngredient> ingredients;
    private User user;
    private float totalCalories;

    /**
     *constructor of Recipe class
     * @param id
     * @param name
     * @param courseType
     * @param prepTime
     * @param portion
     * @param steps
     * @param ingredients
     * @param user
     */
    public Recipe(int id, String name, CourseType courseType, int prepTime, int portion, String steps, ArrayList<RecipeIngredient> ingredients, User user) {
        this.id = id;
        this.name = name;
        this.courseType = courseType;
        this.prepTime = prepTime;
        this.portion = portion;
        this.steps = steps;
        this.ingredients = ingredients;
        this.user = user;
        this.calorieCalculation();
    }

    /**
     * returns the id of the recipe
     * @return id of the recipe
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the recipe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the name of the recipe
     * @return name of recipe
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the recipe
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the type of the course of the recipe
     * @return course type
     */
    public CourseType getCourseType() {
        return courseType;
    }

    /**
     * sets the type of the course of the recipe
     * @param courseType
     */
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    /**
     * returns the preparation time of the recipe
     * @return preparation time
     */
    public int getPrepTime() {
        return prepTime;
    }

    /**
     * sets the preparation time of the recipe
     * @param prepTime
     */
    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    /**
     * returns the portions of the recipe
     * @return portions of the recipe
     */
    public int getPortion() {
        return portion;
    }

    /**
     * sets the portions of the recipe
     * @param portion
     */
    public void setPortion(int portion) {
        this.portion = portion;
    }

    /**
     * returns the steps of the recipe
     * @return steps of the recipe
     */
    public String getSteps() {
        return steps;
    }

    /**
     * sets the steps of the recipe
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
    }

    /**
     * returns the ingredients of the recipe
     * @return ingredients of the recipe
     */
    public ArrayList<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    /**
     * sets the ingredients of the recipe
     * @param ingredients
     */
    public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * returns the user that published the recipe
     * @return user that published the recipe
     */
    public User getUser() {
        return user;
    }

    /**
     * sets the user that published the recipe
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * returns the calories of the recipe
     * @return calories of the recipe
     */
    public float getTotalCalories() {
        return totalCalories;
    }

    /**
     * calculates the total calories of the recipe
     */
    public void calorieCalculation(){
        for (RecipeIngredient ing : this.ingredients){
            this.totalCalories += ing.calorieCalculation();
        }
    }

    public static class RecipeComparator implements Comparator<Recipe> {

        User u;

        /**
         * constructor of RecipeComparator class
         * @param u
         */
        public RecipeComparator(User u){
            this.u = u;
        }

        /**
         * compares two recioes
         * @param r1
         * @param r2
         * @return
         */
        public int compare(Recipe r1, Recipe r2) {
            int r1Encoding;
            int r2Encoding;
            if (u.getRatings().get(r1.getId()) != null) {
                r1Encoding = ratingLevelsEncode(u.getRatings().get(r1.getId()).getRating());
            } else {
                r1Encoding = ratingLevelsEncode(RatingLevel.Neutral);
            }
            if (u.getRatings().get(r2.getId()) != null) {
                r2Encoding = ratingLevelsEncode(u.getRatings().get(r2.getId()).getRating());
            } else {
                r2Encoding = ratingLevelsEncode(RatingLevel.Neutral);
            }

            if (r1Encoding == r2Encoding) {
                return u.getRecipesRead().get(r1.getId()).compareTo(u.getRecipesRead().get(r2.getId()));
            } else {
                return Integer.compare(r1Encoding, r2Encoding);
            }
        }
    }

    public static class RecipeComparatorByTime implements Comparator<Recipe> {

        User u;

        public RecipeComparatorByTime(User u){
            this.u = u;
        }

        public int compare(Recipe r1, Recipe r2) {

            if(r1.getPrepTime() > r2.getPrepTime()){
                return 1;
            }
            else if (r1.getPrepTime() == r2.getPrepTime()){
                return new RecipeComparator(u).compare(r1, r2);
            }
            else{
                return -1;
            }
        }
    }

    /**
     * encodes rating levels
     * @param ratingLevel
     * @return the encoded rating level
     */
    static public int ratingLevelsEncode(RatingLevel ratingLevel){
        if(ratingLevel.equals(RatingLevel.Positive)){
            return -1;
        }else if(ratingLevel.equals(RatingLevel.Neutral)){
            return 0;
        }else{
            return 1;
        }
    }

}
