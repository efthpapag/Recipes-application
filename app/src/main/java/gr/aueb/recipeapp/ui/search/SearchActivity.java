package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import gr.aueb.recipeapp.R;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class SearchActivity extends AppCompatActivity {

    public static final String un = "user";
    public static final String c = "course_type";
    public static final String t = "time";
    Button buttonAppetizer;
    Button buttonMain;
    Button buttonSalad;
    Button buttonDessert;
    Button buttonSelectIngredient;
    EditText editTime;

    String courseType = null;
    int time = -1;

    /**creates the layout, receives the user input and starts the appropriate next activity based on the button clicked
     *
     * @param savedInstanceState
     */
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

        Intent intent = getIntent();
        String us = intent.getStringExtra(SearchActivity.un);


        buttonAppetizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = "Appetizer";
            }
        });

        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = "Main";
            }
        });

        buttonSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = "Salad";
            }
        });

        buttonDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                courseType = "Dessert";
            }
        });

        buttonSelectIngredient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = Integer.parseInt(editTime.getText().toString());
                if (!(courseType == null) &(time > 0)){
                    Intent intent = new Intent(SearchActivity.this, IngredientSelectionActivity.class);
                    intent.putExtra(c, courseType);
                    intent.putExtra(t, time);
                    intent.putExtra(un, us);
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