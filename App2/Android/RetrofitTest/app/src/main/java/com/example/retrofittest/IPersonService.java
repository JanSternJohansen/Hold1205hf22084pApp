package com.example.retrofittest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IPersonService
{
    @GET("Elev")
    Call<List<Elev>> getAllPersons();

    @GET("Elev/{id}")
    Call<Elev> getPersonById(@Path("id") int id );

    @POST("Elev")
    Call<Void> addPerson(@Body Elev p);

}
