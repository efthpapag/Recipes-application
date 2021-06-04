package gr.aueb.recipeapp.domain;

public class Ingredient {

    private String name;
    private int calories;
    private boolean isSelected;
    private String editTextValue;

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getEditTextValue() {
        return editTextValue;
    }
    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }

    @Override
    public String toString() {
        return this.getName();
    }


}
