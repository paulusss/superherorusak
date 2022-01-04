package com.example.marvelretrofit.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JsonPlaceHolderRetrofitClient {
    private static JsonPlaceHolderRetrofitClient instance = null;
    private JsonPlaceHolderApi myApi;

    public JsonPlaceHolderRetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(JsonPlaceHolderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    public static synchronized JsonPlaceHolderRetrofitClient getInstance() {
        if (instance == null) {
            instance = new JsonPlaceHolderRetrofitClient();
        }
        return instance;
    }

    public JsonPlaceHolderApi getMyApi() {
        return myApi;
    }
}
