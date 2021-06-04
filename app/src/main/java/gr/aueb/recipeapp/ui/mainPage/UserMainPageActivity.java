package gr.aueb.recipeapp.ui.mainPage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.login.LoginActivity;
import gr.aueb.recipeapp.ui.login.LoginPresenter;
import gr.aueb.recipeapp.ui.login.RegisterActivity;
import gr.aueb.recipeapp.ui.recipePage.UserRecipesActivity;
import gr.aueb.recipeapp.ui.search.SearchActivity;
import gr.aueb.recipeapp.ui.userRecipes.UserRecipesPresenter;
import gr.aueb.recipeapp.R;

public class UserMainPageActivity extends AppCompatActivity {

    Button buttonSearch;
    Button buttonRecipes;
    public static final String un = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main_page);

        Intent intent = getIntent();
        String us = intent.getStringExtra(UserMainPageActivity.un);

        buttonSearch = findViewById(R.id.searchRecipesButton);
        buttonRecipes = findViewById(R.id.recipesButton);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMainPageActivity.this, SearchActivity.class);
                intent.putExtra(un, us);
                startActivity(intent);
            }
        });

        buttonRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserRecipesActivity.class);
                intent.putExtra(un, us);
                startActivity(intent);
            }
        });

    }
}
