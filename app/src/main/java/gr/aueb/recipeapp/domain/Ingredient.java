package gr.aueb.recipeapp.domain;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class Ingredient {

    private String name;
    private int calories;
    private boolean isSelected;
    private String editTextValue;

    /**
     *constructor of Ingredient class
     * @param name
     * @param calories
     */
    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    /**
     * returns the name of the ingredient
     * @return name of ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the ingredient
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the calories of the ingredient
     * @return calories if the ingredient
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * sets the calories of the ingredient
     * @param calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * checks if the ingredient is selected
     * @return the status of the ingredient
     */
    public boolean getSelected() {
        return isSelected;
    }

    /**
     * sets the ingredient status as selected
     * @param selected
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    /**
     * returns the quantity of the ingredient from the edit text
     * @return the quantity of the edit text
     */
    public String getEditTextValue() {
        return editTextValue;
    }

    /**
     * sets quantity of the ingredient from the edit text
     * @param editTextValue
     */
    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    /**
     * converts ingredient to string
     * @return the name of the ingredient
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
