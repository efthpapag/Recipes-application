package gr.aueb.recipeapp.ui.search;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.Ingredient;

import java.util.ArrayList;

public class IngredientSelectionAdapter extends BaseAdapter {
    private Context context;
    public static ArrayList<Ingredient> IngredientArrayList;
    public IngredientSelectionAdapter(Context context, ArrayList<Ingredient> IngredientArrayList) {
        this.context = context;
        this.IngredientArrayList = IngredientArrayList;
    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getCount() {
        return IngredientArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return IngredientArrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.checkbox_text_box_list_item, null, true);
            holder.editText = (EditText) convertView.findViewById(R.id.editid);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.editText.setText(IngredientArrayList.get(position).getEditTextValue());
        holder.checkBox.setText("Checkbox " + position);
        holder.checkBox.setChecked(IngredientArrayList.get(position).getSelected());
        holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.setTag( position);
        holder.editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                IngredientArrayList.get(position).setEditTextValue(holder.editText.getText().toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pos = (Integer)  holder.checkBox.getTag();
                Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();
                if(IngredientArrayList.get(pos).getSelected()){
                    IngredientArrayList.get(pos).setSelected(false);
                }else {
                    IngredientArrayList.get(pos).setSelected(true);
                }
            }
        });
        return convertView;
    }
    private class ViewHolder {
        public CheckBox checkBox;
        protected EditText editText;
    }

}
