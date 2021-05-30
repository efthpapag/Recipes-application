package gr.aueb.recipeapp.ui.mainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.login.RegisterActivity;
import gr.aueb.recipeapp.ui.login.RegisterPresenter;

public class UserMainPageActivity extends AppCompatActivity {

    Button buttonSearch;
    Button buttonRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);

        buttonSearch = findViewById(R.id.searchRecipesButton);
        buttonRecipes = findViewById(R.id.recipesButton);

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
    }
}