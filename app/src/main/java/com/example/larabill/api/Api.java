package com.example.larabill.api;

import com.example.larabill.models.LoginResponse;
import com.example.larabill.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("auth/login")
    Call<LoginResponse> userLogin(@Field("username") String email, @Field("password") String password);

    @GET("user/{id}")
    Call<User> getUser(@Header("Authorization") String token);

}
