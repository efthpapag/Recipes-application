package gr.aueb.recipeapp.ui.mainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.recipeapp.R;

public class AdminMainPageActivity extends AppCompatActivity {

    Button buttonSearch;
    Button buttonRecipes;
    Button buttonIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);

        buttonSearch = findViewById(R.id.searchRecipesButton);
        buttonRecipes = findViewById(R.id.recipesButton);
        buttonIngredients = findViewById(R.id.ingredientsButton);

        buttonRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserRecipesActivity.class);
                startActivity(intent);
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        buttonIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IngredientManagementActivity.class);
            }
        });
    }
}