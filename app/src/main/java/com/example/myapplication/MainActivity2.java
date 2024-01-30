package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    static final String fakeEmail = "test@mail.ru";
    static final String fakePassword = "123";
    private  Auth auth = new Auth("", "");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button siginButton = (Button) findViewById(R.id.SabrinaButton);
        Button sigupButton = (Button) findViewById(R.id.SabrinaSecondButton);
        EditText emailEdit = (EditText) findViewById(R.id.EmailEditText);
        EditText passwordEdit = (EditText) findViewById(R.id.PasswordEditText);

        Bundle userBundle = getIntent().getExtras();
        if (userBundle != null) {
            User user = (User)userBundle.getSerializable(User.class.getSimpleName());
            if (user != null) {
                emailEdit.setText(user.email);
                passwordEdit.setText(user.password);
            }
        }

        siginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    auth.email = emailEdit.getText().toString();
                    auth.password = passwordEdit.getText().toString();
                    if (auth.email.equals(fakeEmail) && auth.password.equals(fakePassword)){
                        Toast.makeText(getBaseContext(), "Добро пожаловать!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getBaseContext(), "Неверные данные", Toast.LENGTH_SHORT).show();
                    }
            }
        });
        sigupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent navigateToSign = new Intent(getBaseContext(), Registration.class);
                startActivity(navigateToSign);
            }
        });

    }

}