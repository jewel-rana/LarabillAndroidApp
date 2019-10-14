package com.example.larabill.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.larabill.R;
import com.example.larabill.models.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;

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
        if(userEmail.equals("admin") && userPassword.equals("123456")){
            Intent i = new Intent(this, LoginActivity.class);
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
