package com.example.marvelretrofit.service;

import com.example.marvelretrofit.model.DataMock;
import com.example.marvelretrofit.model.Superhero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @POST("/posts/")
    Call<Superhero> addSuperHero(@Body Superhero hero);

    @GET("/posts/")
    Call<List<DataMock>> getDataMock();
}
