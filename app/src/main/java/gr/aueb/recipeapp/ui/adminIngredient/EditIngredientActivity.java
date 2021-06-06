package gr.aueb.recipeapp.ui.adminIngredient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.ui.search.RecipeRecommendationsAdapter;

public class EditIngredientActivity extends AppCompatActivity {

    public static final String ingn = "ingredient_name";
    public static final String ingc = "ingredient_calories";
    Button btn;
    EditText nameText;
    EditText caloriesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        Intent intent = getIntent();
        String name = intent.getStringExtra(IngredientManagementAdapter.ingn);
        int calories = intent.getIntExtra(IngredientManagementAdapter.ingc, -1);

        btn = findViewById(R.id.confirmButtonIM);
        nameText = findViewById(R.id.editTextName);
        caloriesText = findViewById(R.id.editTextCalories);

        nameText.setText(name);
        caloriesText.setText(Integer.toString(calories));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IngredientManagementPresenter().editIngredient(name, nameText.getText().toString(), Integer.parseInt(caloriesText.getText().toString()));
                Intent intent = new Intent(EditIngredientActivity.this, IngredientManagementActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}