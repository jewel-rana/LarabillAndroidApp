package com.example.larabill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private TextView loginAttempt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText) findViewById(R.id.loginEmail);
        Password = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginBtn);
        loginAttempt = (TextView) findViewById(R.id.loginAttempt);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userEmail, String userPassword) {
        Log.d("TAB", userEmail);
        if(userEmail=="admin" && userPassword=="123456"){
            Intent i = new Intent(this, SecondActivity.class);
            startActivity(i);
        } else {
            Email.setFocusable(true);
            Password.setFocusable(true);

            counter++;
            loginAttempt.setText("Faild login attempt: " + String.valueOf(counter));
            if( counter == 5 ){
                loginButton.setEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}
