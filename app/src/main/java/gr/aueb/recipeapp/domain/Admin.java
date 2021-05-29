package gr.aueb.recipeapp.domain;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }

    public void registerIngredient(String name, int calories){
        Ingredient.allIngredients.add(new Ingredient(name, calories));
    }

    public void editIngredient(String oldName, String newName, int newCalories){
        for (Ingredient ing : Ingredient.allIngredients){
            if (ing.getName().equals(oldName)){
                ing.setName(newName);
                ing.setCalories(newCalories);
            }
        }
    }
}
