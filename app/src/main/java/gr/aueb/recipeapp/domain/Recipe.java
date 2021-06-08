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
     *
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
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public CourseType getCourseType() {
        return courseType;
    }

    /**
     *
     * @param courseType
     */
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    /**
     *
     * @return
     */
    public int getPrepTime() {
        return prepTime;
    }

    /**
     *
     * @param prepTime
     */
    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    /**
     *
     * @return
     */
    public int getPortion() {
        return portion;
    }

    /**
     *
     * @param portion
     */
    public void setPortion(int portion) {
        this.portion = portion;
    }

    /**
     *
     * @return
     */
    public String getSteps() {
        return steps;
    }

    /**
     *
     * @param steps
     */
    public void setSteps(String steps) {
        this.steps = steps;
    }

    /**
     *
     * @return
     */
    public ArrayList<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    /**
     *
     * @param ingredients
     */
    public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public float getTotalCalories() {
        return totalCalories;
    }

    /**
     *
     */
    public void calorieCalculation(){
        for (RecipeIngredient ing : this.ingredients){
            this.totalCalories += ing.calorieCalculation();
        }
    }

    public static class RecipeComparator implements Comparator<Recipe> {

        User u;

        /**
         *
         * @param u
         */
        public RecipeComparator(User u){
            this.u = u;
        }

        /**
         *
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
     *
     * @param ratingLevel
     * @return
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
