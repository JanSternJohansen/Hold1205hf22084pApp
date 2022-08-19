package com.example.elevclientapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IElevService service = ServiceBuilder.buildService(IElevService.class);
        Call<Elev> request = service.getElevById(1);
        request.enqueue(new Callback<Elev>() {
            @Override
            public void onResponse(Call<Elev> call, Response<Elev> response)
            {
                Elev elev = response.body();
                Toast.makeText(MainActivity.this, elev.getName()
                              + " " + elev.getJob(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Elev> call, Throwable t)
            {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}