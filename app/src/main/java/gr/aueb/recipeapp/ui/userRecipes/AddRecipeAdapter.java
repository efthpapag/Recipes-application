package gr.aueb.recipeapp.ui.userRecipes;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class AddRecipeAdapter extends BaseAdapter {
    private Context context;
    public static ArrayList<Ingredient> IngredientArrayList;

    /**
     * constructor of AddRecipeAdapter class
     * @param context
     * @param IngredientArrayList
     */
    public AddRecipeAdapter(Context context, ArrayList<Ingredient> IngredientArrayList) {
        this.context = context;
        this.IngredientArrayList = IngredientArrayList;
    }

    /**
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    /**
     *returns the position of an item in the list shown to the user
     * @param position
     * @return the position of an item in the list shown to the user
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }

    /**
     *
     * @return
     */
    @Override
    public int getCount() {
        return IngredientArrayList.size();
    }

    /**
     *returns the position of an item in the list shown to the user
     * @param position
     * @return the position of an item in the list shown to the user
     */
    @Override
    public Object getItem(int position) {
        return IngredientArrayList.get(position);
    }

    /**
     *returns the position of an item in the list shown to the user
     * @param position
     * @return the position of an item in the list shown to the user
     */
    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     *returns the layout of the list and which checkboxes are clicked
     * @param position
     * @param convertView
     * @param parent
     * @return layout
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.checkbox_text_box_list_item, null, true);
        EditText editText = (EditText) convertView.findViewById(R.id.editid);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb);
        TextView tv = (TextView) convertView.findViewById(R.id.text);

        tv.setText(IngredientArrayList.get(position).getName());
        checkBox.setChecked(IngredientArrayList.get(position).getSelected());
        checkBox.setTag(R.integer.btnplusview, convertView);
        checkBox.setTag( position);
        editText.setText("0");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                IngredientArrayList.get(position).setEditTextValue(editText.getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)  checkBox.getTag();
                if(IngredientArrayList.get(pos).getSelected()){
                    IngredientArrayList.get(pos).setSelected(false);
                }else {
                    IngredientArrayList.get(pos).setSelected(true);
                }
            }
        });
        return convertView;
    }
}
