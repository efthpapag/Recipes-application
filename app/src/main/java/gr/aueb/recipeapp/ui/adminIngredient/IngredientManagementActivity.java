package gr.aueb.recipeapp.ui.adminIngredient;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class IngredientManagementActivity extends AppCompatActivity {

    private ListView mListview;
    private IngredientManagementAdapter mAdapter;
    Button button;
    //public static final String un = "user";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_list);

        button = findViewById(R.id.addButton);
        mListview = findViewById(R.id.list1);
        mAdapter = new IngredientManagementAdapter(IngredientManagementActivity.this, IngredientDao.allIngredients);
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( IngredientManagementActivity.this, AddIngredientActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}