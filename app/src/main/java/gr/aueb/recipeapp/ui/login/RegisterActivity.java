package gr.aueb.recipeapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class RegisterActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPassword;
    Button buttonRegister;
    public static final String un = "user";

    /**
     *creates the layout, receives the user input and starts the appropriate next activity based on the button clicked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.registerButton);

        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                User u = new RegisterPresenter().accountCreation(username, password);
                if(u == null){
                    Toast.makeText(RegisterActivity.this, "Username already in use.", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), UserMainPageActivity.class);
                    intent.putExtra(un, u.getUsername());
                    startActivity(intent);
                    finish();
                }
            }

        });
    }
}