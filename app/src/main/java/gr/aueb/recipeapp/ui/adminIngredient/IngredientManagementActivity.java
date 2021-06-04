package gr.aueb.recipeapp.ui.adminIngredient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Ingredient;

public class IngredientManagementActivity extends AppCompatActivity {

    private ListView mListview;
    //private ArrayList<Ingredient> mArrData;
    private IngredientManagementAdapter mAdapter;
    Button btnAction1;
    Button btnAction2;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_management);

        button = findViewById(R.id.addButton);
        mListview = (ListView) findViewById(R.id.IngredientList);
        btnAction1 = (Button) findViewById(R.id.editButton);
        btnAction2 = (Button) findViewById(R.id.deleteButton);
        //mArrData = new ArrayList<String>(Arrays.asList("111,222,333,444,555,666".split(",")));
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