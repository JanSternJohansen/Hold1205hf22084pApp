package com.example.elevclientapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder
{
    private static String URL = "http://10.131.193.228:8080/MySecondProject/api/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static <S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }
}
