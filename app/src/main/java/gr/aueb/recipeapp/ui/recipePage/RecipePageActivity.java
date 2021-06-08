package gr.aueb.recipeapp.ui.recipePage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.RecipeDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.ui.search.RecipeRecommendationsAdapter;

/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipePageActivity extends AppCompatActivity {

    public static final String un = "user";
    public static final String r = "Recipe";
    private ListView mListview;
    private RecipePageAdapter mAdapter;
    Button buttonRate;
    TextView name;
    TextView steps;
    TextView calories;
    TextView portions;
    TextView courseType;
    TextView prepTime;

    /**
     *creates the layout and starts the appropriate next activity based on the button clicked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);

        Intent intent = getIntent();
        String us = intent.getStringExtra(RecipeRecommendationsAdapter.un);
        int re = intent.getIntExtra(RecipeRecommendationsAdapter.r, -1);
        Recipe rec = new RecipeDao().find(re);

        new  RecipePagePresenter(UserDao.findUser(us)).addOnRead(rec);

        name = findViewById(R.id.NameText);
        steps = findViewById(R.id.stepsTextVar);
        calories = findViewById(R.id.caloriesNumText);
        courseType = findViewById(R.id.courseTypeTextVar);
        portions = findViewById(R.id.portionNum);
        prepTime = findViewById(R.id.prepTimeTextVar);

        name.setText(rec.getName());
        steps.setText(rec.getSteps());
        calories.setText(Float.toString(rec.getTotalCalories()));
        portions.setText(Integer.toString(rec.getPortion()));
        courseType.setText(rec.getCourseType().toString());
        prepTime.setText(Integer.toString(rec.getPrepTime()));

        mListview = findViewById(R.id.List);
        buttonRate = findViewById(R.id.rateButton);
        mAdapter = new RecipePageAdapter(RecipePageActivity.this, rec.getIngredients());
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipePageActivity.this, RateActivity.class);
                intent.putExtra(un, us);
                intent.putExtra(r,re);
                startActivity(intent);
            }
        });

    }
}