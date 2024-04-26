package com.example.utspeber.data.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ApiService apiService = retrofit.create(ApiService.class);

}
