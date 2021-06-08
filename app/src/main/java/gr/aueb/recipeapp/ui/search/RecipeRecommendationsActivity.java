package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.domain.RecipeIngredient;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipeRecommendationsActivity extends AppCompatActivity{

    public static final String c = "course_type";
    public static final String t = "time";
    public static final String ic = "ingredients_chosen";
    public static final String icn = "ingredients_chosen_name";
    public static final String icq = "ingredients_chosen_quantity";
    public static final String un = "user";

    private ListView mListview;
    private RecipeRecommendationsAdapter mAdapter;
    Button btnAction1;

    /**
     *creates the layout
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_recommendations);

        Intent intent = getIntent();
        int time = intent.getIntExtra(IngredientSelectionActivity.t,0);
        String courseTypeS = intent.getStringExtra(IngredientSelectionActivity.c);
        String us = intent.getStringExtra(IngredientSelectionActivity.un);

        CourseType courseType;
        if (courseTypeS.equals("Appetizer")){
            courseType = CourseType.Appetizer;
        }
        else if (courseTypeS.equals("Main")){
            courseType = CourseType.Main;
        }
        else if (courseTypeS.equals("Salad")){
            courseType = CourseType.Salad;
        }
        else{
            courseType = CourseType.Dessert;
        }

        ArrayList<String> ingredientsChosenName = intent.getStringArrayListExtra(IngredientSelectionActivity.icn);
        ArrayList<String> ingredientsChosenQuantity = intent.getStringArrayListExtra(IngredientSelectionActivity.icq);


        ArrayList<RecipeIngredient> ingredientsChosen = new ArrayList<RecipeIngredient>();
        for (int i = 0; i< ingredientsChosenName.size(); i++){
            ingredientsChosen.add(new RecipeIngredient(Float.parseFloat(ingredientsChosenQuantity.get(i)), new IngredientDao().findIngredient(ingredientsChosenName.get(i))));
        }

        ArrayList<Recipe> recipes = new SearchPresenter(UserDao.findUser(us)).search(time, ingredientsChosen,courseType);

        mListview = (ListView) findViewById(R.id.list1);
        btnAction1 = (Button) findViewById(R.id.editButton);
        mAdapter = new RecipeRecommendationsAdapter(RecipeRecommendationsActivity.this, recipes, us);
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}