package gr.aueb.recipeapp.ui.recipePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;

public class UserRecipesActivity extends AppCompatActivity {

    public static final String un = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recipes);

        Intent intent = getIntent();
        String us = intent.getStringExtra(UserMainPageActivity.un);



    }
}