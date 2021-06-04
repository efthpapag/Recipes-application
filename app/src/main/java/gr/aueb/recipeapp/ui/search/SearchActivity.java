package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.ui.login.LoginActivity;

public class SearchActivity extends AppCompatActivity {

    public static final String c = "course_type";
    public static final String t = "time";
    Button buttonAppetizer;
    Button buttonMain;
    Button buttonSalad;
    Button buttonDessert;
    Button buttonSelectIngredient;
    EditText editTime;

    CourseType courseType = null;
    int time = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        buttonAppetizer = findViewById(R.id.appetizerButton);
        buttonMain = findViewById(R.id.mainButton);
        buttonSalad = findViewById(R.id.saladButton);
        buttonDessert = findViewById(R.id.dessertButton);
        buttonSelectIngredient = findViewById(R.id.selectIngredientsButton);
        editTime = findViewById(R.id.editTime);


        buttonAppetizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = CourseType.Appetizer;
            }
        });

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = CourseType.Main;
            }
        });

        buttonSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = CourseType.Salad;
            }
        });

        buttonDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = CourseType.Dessert;
            }
        });

        buttonSelectIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(courseType == null & time > 0)){
                    Intent intent = new Intent(SearchActivity.this, IngredientSelectionActivity.class);
                    //intent.putExtra(c, courseType);
                    //intent.putExtra(t, time);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(SearchActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}