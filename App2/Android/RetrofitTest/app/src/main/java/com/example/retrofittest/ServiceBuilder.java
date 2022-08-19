package com.example.retrofittest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder
{
    // eller hostpc 10.131.216.103
    private static final String URL = "http://192.168.1.6:8080/MySecondProject/api/";
    private static Retrofit retrofit =
            new Retrofit.Builder().baseUrl(URL).
                    addConverterFactory((GsonConverterFactory.create())).build();

    public static <S> S buildService(Class<S> serviceType)
    {
        return retrofit.create(serviceType);
    }
}
