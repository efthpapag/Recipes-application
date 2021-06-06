package gr.aueb.recipeapp.ui.userRecipes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.dao.UserDao;
import gr.aueb.recipeapp.ui.mainPage.AdminMainPageActivity;

public class UserRecipesActivity extends AppCompatActivity {

    public static final String un = "user";
    private ListView mListview;
    private UserRecipesAdapter mAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_recipes);

        Intent intent = getIntent();
        String us = intent.getStringExtra(AdminMainPageActivity.un);

        button = findViewById(R.id.addButton);
        mListview = findViewById(R.id.list1);
        mAdapter = new UserRecipesAdapter(UserRecipesActivity.this, UserDao.findUser(us).getRecipesPublished());
        mListview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( UserRecipesActivity.this,  AddRecipeActivity.class);
                intent.putExtra(un, us);
                startActivity(intent);
                finish();
            }
        });
    }
}