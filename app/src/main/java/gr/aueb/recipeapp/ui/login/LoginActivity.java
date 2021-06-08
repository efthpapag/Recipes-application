package gr.aueb.recipeapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import gr.aueb.recipeapp.R;
import gr.aueb.recipeapp.domain.User;
import gr.aueb.recipeapp.ui.mainPage.AdminMainPageActivity;
import gr.aueb.recipeapp.ui.mainPage.UserMainPageActivity;
/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class LoginActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPassword;
    Button buttonLogin;
    Button buttonRegister;
    public static final String un = "user";

    /**
     *creates the layout, receives the user input and starts the appropriate next activity based on the button clicked
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editTextUsername);
        editPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.loginButton);
        buttonRegister = findViewById(R.id.registerButton);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                User u = new LoginPresenter().login(username, password);
                if(u == null){
                    Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent;
                    if ((new LoginPresenter().isAdmin(u.getUsername(), u.getPassword()))){
                        intent = new Intent(getApplicationContext(), AdminMainPageActivity.class);
                    }
                    else {
                        intent = new Intent(getApplicationContext(), UserMainPageActivity.class);
                    }
                    intent.putExtra(un, u.getUsername());
                    startActivity(intent);
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}