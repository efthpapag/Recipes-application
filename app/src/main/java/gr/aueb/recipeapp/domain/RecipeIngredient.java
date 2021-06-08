package gr.aueb.recipeapp.domain;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipeIngredient {

    private float quantity;
    private Ingredient ingredientType;

    /**
     *constructor of RecipeIngredient class
     * @param quantity
     * @param ingredientType
     */
    public RecipeIngredient(float quantity, Ingredient ingredientType) {
        this.quantity = quantity;
        this.ingredientType = ingredientType;
    }

    /**
     * returns the quantity of the ingredient
     * @return quantity
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     * sets the quantity of the ingredient
     * @param quantity
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    /**
     * returns the ingredient type
     * @return ingredient type
     */
    public Ingredient getIngredientType() {
        return ingredientType;
    }

    /**
     * sets the ingredient type
     * @param ingredientType
     */
    public void setIngredientType(Ingredient ingredientType) {
        this.ingredientType = ingredientType;
    }

    /**
     * calculates and returns the calories of the ingredient for its given quantity
     * @return calories of the ingredient for its given quantity
     */
    public float calorieCalculation(){
        return quantity * ingredientType.getCalories();
    }

}
