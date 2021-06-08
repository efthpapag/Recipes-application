package gr.aueb.recipeapp.ui.userRecipes;

import android.app.Activity;
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
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class UserRecipesAdapter extends BaseAdapter {

    public static final String un = "user";
    public static final String i = "i";

    private Context mContext;
    private ArrayList<Recipe> mArr;
    String us;
    int id;

    /**
     *
     * @param context
     * @param Arr
     */
    public UserRecipesAdapter(Context context, ArrayList<Recipe> Arr) {
        super();
        mContext = context;
        mArr = Arr;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return mArr.size();
    }

    /**
     *
     * @param position
     * @param view
     * @param parent
     * @return
     */
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.two_button_list_item, parent, false);

        TextView tv = view.findViewById(R.id.itemName);
        tv.setText(mArr.get(position).getName());
        Button btn1 = view.findViewById(R.id.editButton);
        Button btn2 = view.findViewById(R.id.deleteButton);

        us = mArr.get(position).getUser().getUsername();
        id = mArr.get(position).getId();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mContext, EditRecipeActivity.class);
                intent.putExtra(un, us);
                intent.putExtra(i, id);
                mContext.startActivity(intent);
                ((Activity)mContext).finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new UserRecipesPresenter(mArr.get(position).getUser()).remove(mArr.get(position).getId());
                Intent intent = new Intent( mContext, UserRecipesActivity.class);
                intent.putExtra(un, us);
                mContext.startActivity(intent);
                ((Activity)mContext).finish();
            }
        });

        return view;
    }

    /**
     *
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
