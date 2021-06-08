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
    public int getCalories() {
        return this.calories;
    }

    /**
     *
     * @param calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     *
     * @return
     */
    public boolean getSelected() {
        return isSelected;
    }

    /**
     *
     * @param selected
     */
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    /**
     *
     * @return
     */
    public String getEditTextValue() {
        return editTextValue;
    }

    /**
     *
     * @param editTextValue
     */
    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getName();
    }

}
