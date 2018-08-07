package com.tahsin.testretrofit.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitClient {

    public static Retrofit retrofit;
    public static String BASE_URL = "https://api.myjson.com/";


    public static Retrofit getRetrofitInstance(){

        retrofit = new Retrofit.Builder()
                   .baseUrl(BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();

        return retrofit;

    }

}
