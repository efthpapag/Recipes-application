package gr.aueb.recipeapp.ui.adminIngredient;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;

public class IngredientManagementActivity extends AppCompatActivity {

    private ListView mListview;
    private IngredientManagementAdapter mAdapter;
    Button btnAction1;
    Button button;
    public static final String un = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_management);

        Intent intent = getIntent();
        String us = intent.getStringExtra(UserMainPageActivity.un);

        button = findViewById(R.id.addButton);
        mListview = (ListView) findViewById(R.id.IngredientList);
        btnAction1 = (Button) findViewById(R.id.editButton);
        mAdapter = new IngredientManagementAdapter(IngredientManagementActivity.this, IngredientDao.allIngredients);
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( IngredientManagementActivity.this, AddIngredientActivity.class);
                startActivity(intent);
            }
        });

    }
}