package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RecipeIngredient;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class IngredientSelectionActivity extends AppCompatActivity {

    public static final String c = "course_type";
    public static final String t = "time";
    public static final String icn = "ingredients_chosen_name";
    public static final String icq = "ingredients_chosen_quantity";
    public static final String un = "user";

    private Button btn;
    private ListView lv;
    private IngredientSelectionAdapter customeAdapter;
    public ArrayList<Ingredient> IngredientArrayList;
    ArrayList<String> ingredientsChosenName = new ArrayList<String>();
    ArrayList<String> ingredientsChosenQuantity = new ArrayList<String>();

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_selection);


        Intent intent = getIntent();
        int time = intent.getIntExtra(SearchActivity.t, 0);
        String courseType = intent.getStringExtra(SearchActivity.c);
        String us = intent.getStringExtra(SearchActivity.un);


        lv = (ListView) findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.confirmChoicesButton);
        IngredientArrayList = populateList();
        customeAdapter = new IngredientSelectionAdapter(IngredientSelectionActivity.this,IngredientArrayList);
        lv.setAdapter(customeAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Ingredient i : IngredientArrayList){
                    if(i.getSelected()){
                        ingredientsChosenName.add(i.getName());
                        ingredientsChosenQuantity.add(i.getEditTextValue());
                    }
                }

                Intent intent = new Intent(IngredientSelectionActivity.this, RecipeRecommendationsActivity.class);
                intent.putExtra(c, courseType);
                intent.putExtra(t, time);
                intent.putStringArrayListExtra(icn, ingredientsChosenName);
                intent.putStringArrayListExtra(icq, ingredientsChosenQuantity);
                intent.putExtra(un, us);
                startActivity(intent);
                finish();
            }
        });
    }
    private ArrayList<Ingredient> populateList(){
        ArrayList<Ingredient> list = new ArrayList<>();
        for(int i = 0; i < IngredientDao.allIngredients.size(); i++){
            IngredientDao.allIngredients.get(i).setEditTextValue(String.valueOf(i));
            list.add(IngredientDao.allIngredients.get(i));
        }
        return list;
    }
}