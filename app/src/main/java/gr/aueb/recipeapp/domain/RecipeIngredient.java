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
     *
     * @param quantity
     * @param ingredientType
     */
    public RecipeIngredient(float quantity, Ingredient ingredientType) {
        this.quantity = quantity;
        this.ingredientType = ingredientType;
    }

    /**
     *
     * @return
     */
    public float getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public Ingredient getIngredientType() {
        return ingredientType;
    }

    /**
     *
     * @param ingredientType
     */
    public void setIngredientType(Ingredient ingredientType) {
        this.ingredientType = ingredientType;
    }

    /**
     *
     * @return
     */
    public float calorieCalculation(){
        return quantity * ingredientType.getCalories();
    }

}
