package com.example.larabill.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "http://mmcm.itracker71.com/dev/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient(){
        if( retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
