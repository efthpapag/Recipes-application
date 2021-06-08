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
import gr.aueb.recipeapp.domain.Recipe;
import gr.aueb.recipeapp.ui.recipePage.RecipePageActivity;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipeRecommendationsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Recipe> mArr;
    public static final String un = "user";
    public static final String r = "Recipe";
    String us;

    /**
     *constructor of RecipeRecommendationsAdapter class
     * @param context
     * @param Arr
     * @param us
     */
    public RecipeRecommendationsAdapter(Context context, ArrayList<Recipe> Arr, String us) {
        super();
        mContext = context;
        mArr = Arr;
        this.us = us;
    }

    /**
     * returns size of the list shown to the user of the app
     * @return size of the list shown to the user of the app
     */
    public int getCount() {
        return mArr.size();
    }

    /**
     *returns the layout of the list and starts the appropriate next activity based on the button clicked
     * @param position
     * @param view
     * @param parent
     * @return layout
     */
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
                intent.putExtra(r, mArr.get(position).getId());
                mContext.startActivity(intent);
            }
        });

        return view;
    }

    /**
     *returns the item in possition given in the list shown to the user
     * @param position
     * @return the position of an item in the list shown to the user
     */
    public Object getItem(int position) {
        return position;
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

}
