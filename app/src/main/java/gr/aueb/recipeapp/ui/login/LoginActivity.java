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


public class LoginActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPassword;
    Button buttonLogin;
    Button buttonRegister;

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
                if (u == null){
                    Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent;
                    if (new LoginPresenter().isAdmin(u.getUsername(), u.getPassword())){
                        intent = new Intent(getApplicationContext(), AdminMainPageActivity.class);
                        startActivity(intent);
                    }else{
                        intent = new Intent(getApplicationContext(), UserMainPageActivity.class);
                        startActivity(intent);
                    }
                    startActivity(intent);
                    finish();
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}