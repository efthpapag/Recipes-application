package gr.aueb.recipeapp.ui.adminIngredient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import gr.aueb.recipeapp.R;

import java.util.ArrayList;

public class IngredientManagementAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mArr;

    public IngredientManagementAdapter(Context context, ArrayList Arr) {
        super();
        mContext = context;
        mArr = Arr;
    }

    public int getCount() {
        return mArr.size();
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.two_button_list_item, parent, false);


        TextView tv = (TextView) view.findViewById(R.id.itemName);
        tv.setText(mArr.get(position));
        Button btn1 = (Button) view.findViewById(R.id.editButton);
        Button btn2 = (Button) view.findViewById(R.id.deleteButton);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mContext, EditIngredientActivity.class);
                mContext.startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( mContext, DeleteIngredientActivity.class);
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
