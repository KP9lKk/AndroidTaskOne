package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Button sigupButton = (Button) findViewById(R.id.SignUpButton);
        Button cancelButton  = (Button) findViewById(R.id.CancelButton);
        EditText emailEdit = (EditText) findViewById(R.id.EmailEditText);
        EditText passwordEdit = (EditText) findViewById(R.id.PasswordEditText);
        EditText nameEdit = (EditText) findViewById(R.id.NameEditText);
        EditText confirmPasswordEdit = (EditText) findViewById(R.id.ConfirmPasswordEditText);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        sigupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(nameEdit.getText().toString(), emailEdit.getText().toString(), passwordEdit.getText().toString());
                String confirmPassword = confirmPasswordEdit.getText().toString();
                if (!user.password.equals(confirmPassword)){
                    Toast.makeText(getBaseContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent navigateToLogin = new Intent(getBaseContext(), MainActivity2.class);
                navigateToLogin.putExtra(User.class.getSimpleName(), user);
                startActivity(navigateToLogin);
            }
        });
    }
}