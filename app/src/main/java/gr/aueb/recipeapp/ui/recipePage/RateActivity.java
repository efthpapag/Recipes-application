package gr.aueb.recipeapp.ui.recipePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Rating;
import gr.aueb.recipeapp.domain.RatingLevel;
import gr.aueb.recipeapp.ui.login.LoginActivity;
import gr.aueb.recipeapp.ui.login.RegisterActivity;
import gr.aueb.recipeapp.ui.search.IngredientSelectionActivity;

public class RateActivity extends AppCompatActivity {

    public static final String un = "user";
    public static final String r = "Recipe";
    Button buttonPositive;
    Button buttonNeutral;
    Button buttonNegative;
    Button buttonConfirm;
    RatingLevel rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        Intent intent = getIntent();
        String us = intent.getStringExtra(RecipePageActivity.un);
        int re = intent.getIntExtra(RecipePageActivity.r, -1);

        buttonPositive = findViewById(R.id.positiveButton);
        buttonNeutral = findViewById(R.id.neutralButton);
        buttonNegative = findViewById(R.id.negativeButton);
        buttonConfirm = findViewById(R.id.confirmButton);

        buttonPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = RatingLevel.Positive;
            }
        });

        buttonNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = RatingLevel.Neutral;
            }
        });

        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = RatingLevel.Negative;
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RecipePagePresenter(UserDao.findUser(us)).rate(re, rate);
                finish();
            }
        });

    }
}