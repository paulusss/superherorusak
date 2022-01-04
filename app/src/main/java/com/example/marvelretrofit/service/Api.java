package com.example.marvelretrofit.service;

import com.example.marvelretrofit.model.Superhero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";
    @GET("marvel")
    Call<List<Superhero>> getSembarangan();
}