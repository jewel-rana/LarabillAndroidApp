package com.example.larabill.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.larabill.R;
import com.example.larabill.api.Api;
import com.example.larabill.api.Client;
import com.example.larabill.models.LoginResponse;
import com.example.larabill.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;

import static android.widget.Toast.*;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Email;
    private EditText Password;
    private Button loginButton;
    private int counter = 0;
    private TextView loginAttempt;
    //send request via retrofit to api
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://mmcm.itracker71.com/dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Api api = retrofit.create(Api.class);
    private Object User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.loginEmail);
        Password = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginBtn);
        loginAttempt = (TextView) findViewById(R.id.loginAttempt);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
    }

    private void userLogin()
    {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        validate(email, password);
    }

    private void validate(String email, String password){
        if(email.isEmpty()){
            Email.setError("The email / username field is required");
            Email.requestFocus();
            return;
        }


        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError("Your email address is not valid");
            Email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            Password.setError("The password field is required");
            Password.requestFocus();
            return;
        }

        if(password.length() < 6 ) {
            Password.setError("The password should at least 6 character");
            Password.requestFocus();
            return;
        }

        Toast.makeText(this, "Hello", LENGTH_LONG).show();

        Client client = new Client();
        Api api = client.getClient().create(Api.class);

        Call<LoginResponse> call = api.userLogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();

                if(loginResponse.isSuccess()) {

                    //save user
                    //make profile
                    //sqlite handle
                    Toast.makeText(LoginActivity.this, "Login success", LENGTH_LONG).show();

                } else {
                    makeText(LoginActivity.this, loginResponse.getMessage(), LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d("ERROR", t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
