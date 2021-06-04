package gr.aueb.recipeapp.ui.search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import gr.aueb.recipeapp.R;

public class RecipeFilterActivity extends AppCompatActivity{
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_filter);
        tv = (TextView) findViewById(R.id.tv);
        for (int i = 0; i < IngredientSelectionAdapter.IngredientArrayList.size(); i++){
            if(IngredientSelectionAdapter.IngredientArrayList.get(i).getSelected()) {
                tv.setText(tv.getText() + " " + IngredientSelectionAdapter.IngredientArrayList.get(i).getEditTextValue() + System.getProperty("line.separator"));
            }
        }
    }

}