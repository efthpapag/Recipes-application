package gr.aueb.recipeapp;

public class RecipeIngredient {

    private float quantity;
    private Ingredient ingredientType;

    public RecipeIngredient(float quantity, Ingredient ingredientType) {
        this.quantity = quantity;
        this.ingredientType = ingredientType;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Ingredient getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(Ingredient ingredientType) {
        this.ingredientType = ingredientType;
    }

    public float calorieCalculation(){
        return quantity * ingredientType.getCalories();
    }

}
