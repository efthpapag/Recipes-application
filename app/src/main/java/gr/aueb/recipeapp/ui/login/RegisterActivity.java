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

public class RegisterActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPassword;
    Button buttonRegister;

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
                    startActivity(intent);
                    getParent().finish();
                    finish();
                }
            }

        });
    }
}