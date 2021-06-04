package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.IngredientDao;
import gr.aueb.recipeapp.domain.Ingredient;

public class IngredientSelectionActivity extends AppCompatActivity {

    private Button btn;
    private ListView lv;
    private IngredientSelectionAdapter customeAdapter;
    public ArrayList<Ingredient> IngredientArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.confirmChoicesButton);
        IngredientArrayList = populateList();
        customeAdapter = new IngredientSelectionAdapter(IngredientSelectionActivity.this,IngredientArrayList);
        lv.setAdapter(customeAdapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IngredientSelectionActivity.this, RecipeFilterActivity.class);
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

    /*public static final String TAG = "ListView";
    public static final String c = "course_type";
    public static final String t = "time";
    public static final String ic = "ingredients_chosen";

    ListView listView;
    Button buttonSelect;
    ArrayList<Ingredient> ingredientsChosen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_selection);

        Intent intent = getIntent();
        String time = intent.getStringExtra(SearchActivity.c);
        String courseType = intent.getStringExtra(SearchActivity.t);

        this.listView = (ListView)findViewById(R.id.listView);
        this.buttonSelect = (Button)findViewById(R.id.selectButton);
        this.listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
                CheckedTextView v = (CheckedTextView) view;
                boolean currentCheck = v.isChecked();
                Ingredient i = (Ingredient) listView.getItemAtPosition(position);
                i.setActive(!currentCheck);
            }
        });

        this.buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray sp = listView.getCheckedItemPositions();

                for(int i=0;i<sp.size();i++){
                    if(sp.valueAt(i) == true){
                        Ingredient in = (Ingredient) listView.getItemAtPosition(i);
                        ingredientsChosen.add(in);
                    }
                }
                Intent intent = new Intent(IngredientSelectionActivity.this, RecipeFilterActivity.class);
                intent.putExtra(c, courseType);
                intent.putExtra(t, time);
                intent.putExtra(ic, ingredientsChosen);
                startActivity(intent);
                finish();
            }
        });

        this.initListViewData();
    }

    private void initListViewData()  {

        ArrayAdapter<Ingredient> arrayAdapter = new ArrayAdapter<Ingredient>(this, android.R.layout.simple_list_item_checked , IngredientDao.allIngredients);

        this.listView.setAdapter(arrayAdapter);

        for(int i = 0; i < IngredientDao.allIngredients.size(); i++ )  {
            this.listView.setItemChecked(i,IngredientDao.allIngredients.get(i).isActive());
        }
    }*/

}