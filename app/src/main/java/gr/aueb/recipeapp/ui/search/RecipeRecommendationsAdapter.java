package gr.aueb.recipeapp.ui.search;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.ui.adminIngredient.EditIngredientActivity;
import gr.aueb.recipeapp.ui.recipePage.RecipePageActivity;

public class RecipeRecommendationsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Recipe> mArr;
    public static final String un = "user";
    String us;

    public RecipeRecommendationsAdapter(Context context, ArrayList<Recipe> Arr, String us) {
        super();
        mContext = context;
        mArr = Arr;
    }

    public int getCount() {
        return mArr.size();
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.one_button_list_item, parent, false);


        TextView tv = (TextView) view.findViewById(R.id.itemName);
        tv.setText(mArr.get(position).getName());
        Button btn1 = (Button) view.findViewById(R.id.editButton);
        btn1.setText("select");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mContext, RecipePageActivity.class);
                intent.putExtra(un, us);
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
