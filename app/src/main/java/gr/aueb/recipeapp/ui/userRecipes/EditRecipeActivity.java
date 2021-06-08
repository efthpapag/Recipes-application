package gr.aueb.recipeapp.ui.userRecipes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.domain.CourseType;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.RecipeIngredient;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class EditRecipeActivity extends AppCompatActivity {

    public static final String un = "user";
    public static final String i = "i";
    private ListView mListview;
    private AddRecipeAdapter mAdapter;
    Button button;
    EditText name;
    EditText steps;
    EditText portions;
    EditText courseType;
    EditText prepTime;
    public ArrayList<Ingredient> IngredientArrayList;

    /**
     *creates the layout, receives the user input and starts the appropriate next activity based on the button clicked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);


        Intent intent = getIntent();
        String us = intent.getStringExtra(UserRecipesActivity.un);
        int id = intent.getIntExtra(UserRecipesAdapter.i, -1);

        name = findViewById(R.id.v1);
        steps = findViewById(R.id.v5);
        courseType = findViewById(R.id.v2);
        portions = findViewById(R.id.v4);
        prepTime = findViewById(R.id.v3);


        mListview = findViewById(R.id.list1);
        button = findViewById(R.id.button);
        button.setText("edit");
        IngredientArrayList = populateList();
        mAdapter = new AddRecipeAdapter(EditRecipeActivity.this, IngredientDao.allIngredients);
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String p1 = name.getText().toString();
                CourseType p2;
                String p5 = steps.getText().toString();

                if (courseType.getText().toString().equals("Appetizer")){
                    p2 = CourseType.Appetizer;
                }
                else if (courseType.getText().toString().equals("Salad")){
                    p2 = CourseType.Salad;
                }
                else if (courseType.getText().toString().equals("Main")){
                    p2 = CourseType.Main;
                }
                else {
                    p2 = CourseType.Dessert;
                }

                int p4 = Integer.parseInt(portions.getText().toString());
                int p3 = Integer.parseInt(prepTime.getText().toString());

                ArrayList<RecipeIngredient> ri = new ArrayList<RecipeIngredient>();

                for (Ingredient i : IngredientArrayList){
                    if(i.getSelected()){
                        ri.add(new RecipeIngredient(Float.parseFloat(i.getEditTextValue()), new IngredientDao().findIngredient(i.getName())));
                    }
                }

                new RecipeManagementPresenter(UserDao.findUser(us)).edit(id, p1, p2, p3, p4, p5, ri);

                Intent intent = new Intent(EditRecipeActivity.this, UserRecipesActivity.class);
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