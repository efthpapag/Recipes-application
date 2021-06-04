package gr.aueb.recipeapp.ui.mainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.ui.adminIngredient.IngredientManagementActivity;
import gr.aueb.recipeapp.ui.recipePage.UserRecipesActivity;
import gr.aueb.recipeapp.ui.search.SearchActivity;

public class AdminMainPageActivity extends AppCompatActivity {

    Button buttonSearch;
    Button buttonRecipes;
    Button buttonIngredients;
    public static final String un = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);

        Intent intent = getIntent();
        String us = intent.getStringExtra(UserMainPageActivity.un);

        buttonSearch = findViewById(R.id.searchRecipesButton);
        buttonRecipes = findViewById(R.id.recipesButton);
        buttonIngredients = findViewById(R.id.ingredientsButton);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMainPageActivity.this, SearchActivity.class);
                intent.putExtra(un, us);
                startActivity(intent);
            }
        });

        buttonRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserRecipesActivity.class);
                startActivity(intent);
            }
        });

        buttonIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), IngredientManagementActivity.class);
                startActivity(intent);
            }
        });

    }
}