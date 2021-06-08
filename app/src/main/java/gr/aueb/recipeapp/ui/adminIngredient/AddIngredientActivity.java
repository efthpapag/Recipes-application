package gr.aueb.recipeapp.ui.adminIngredient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.login.LoginActivity;
import gr.aueb.recipeapp.ui.login.LoginPresenter;
import gr.aueb.recipeapp.ui.mainPage.AdminMainPageActivity;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class AddIngredientActivity extends AppCompatActivity {

    Button btn;
    EditText nameText;
    EditText caloriesText;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);

        btn = findViewById(R.id.confirmButtonIM);
        nameText = findViewById(R.id.editTextName);
        caloriesText = findViewById(R.id.editTextCalories);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                int calories = Integer.parseInt(caloriesText.getText().toString());
                Ingredient ingredient = new IngredientManagementPresenter().registerIngredient( name, calories);
                if(ingredient == null){
                    Toast.makeText(AddIngredientActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(AddIngredientActivity.this, IngredientManagementActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}