package gr.aueb.recipeapp.ui.recipePage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.RecipeIngredient;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RecipePageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<RecipeIngredient> mArr;

    /**
     *
     * @param context
     * @param Arr
     */
    public RecipePageAdapter(Context context, ArrayList<RecipeIngredient> Arr) {
        super();
        mContext = context;
        mArr = Arr;
    }

    /**
     *returns the layout of the list
     * @return layout
     */
    public int getCount() {
        return mArr.size();
    }

    /**
     *returns the layout of the list and which checkboxes are clicked
     * @param position
     * @param view
     * @param parent
     * @return layout
     */
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.no_button_list_item, parent, false);

        TextView tv = (TextView) view.findViewById(R.id.itemName);
        tv.setText(mArr.get(position).getIngredientType().getName() + "   " + mArr.get(position).getQuantity() + " grams/ml");

        return view;
    }

    /**
     *returns the item in possition given in the list shown to the user
     * @param position
     * @return the item in possition given in the list shown to the user
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
