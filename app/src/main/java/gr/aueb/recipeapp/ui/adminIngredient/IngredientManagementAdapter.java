package gr.aueb.recipeapp.ui.adminIngredient;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;

import java.util.ArrayList;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class IngredientManagementAdapter extends BaseAdapter {

    public static final String ingn = "ingredient_name";
    public static final String ingc = "ingredient_calories";
    private Context mContext;
    private ArrayList<Ingredient> mArr;

    /**
     * constructor of IngredientManagementAdapter class
     * @param context
     * @param Arr
     */
    public IngredientManagementAdapter(Context context, ArrayList<Ingredient> Arr) {
        super();
        mContext = context;
        mArr = Arr;
    }

    /**
     * returns size of the list shown to the user of the app
     * @return size of the list shown to the user of the app
     */
    public int getCount() {
        return mArr.size();
    }

    /**
     * returns the layout of the list and starts the appropriate next activity based on the button clicked
     * @param position
     * @param view
     * @param parent
     * @return layout
     */
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.one_button_list_item, parent, false);

        TextView tv = view.findViewById(R.id.itemName);
        tv.setText(mArr.get(position).getName());
        Button btn1 = view.findViewById(R.id.editButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mContext, EditIngredientActivity.class);
                intent.putExtra(ingn, mArr.get(position).getName());
                intent.putExtra(ingc, mArr.get(position).getCalories());
                mContext.startActivity(intent);
                ((Activity)mContext).finish();
            }
        });

        return view;
    }

    /**
     * returns the item in position given in the list shown to the user
     * @param position
     * @return
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
