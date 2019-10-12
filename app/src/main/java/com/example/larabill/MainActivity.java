package com.example.larabill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.larabill.R.id.loginBtn;
import static com.example.larabill.R.id.loginEmail;
import static com.example.larabill.R.id.loginPassword;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Email;
    private EditText Password;
    private Button loginButton;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.loginEmail);
        Password = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), "123456");
            }
        });

    }

    private void validate(String userEmail, String userPassword) {
        if((userEmail == "admin") && (userPassword == "123456" )){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            Email.setFocusable(true);
            Password.setFocusable(true);

            counter++;

            if( counter == 5 ){
                loginButton.setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}
