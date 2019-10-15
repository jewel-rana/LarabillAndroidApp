package com.example.larabill.api;

import com.squareup.okhttp.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "http://192.168.1.103:8000/api/v2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if( retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
