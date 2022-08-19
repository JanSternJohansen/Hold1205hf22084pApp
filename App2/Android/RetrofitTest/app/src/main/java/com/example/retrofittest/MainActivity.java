package com.example.retrofittest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText edtElevId;
    Button btnGetElevById;
    TextView txtShowElev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtElevId = findViewById(R.id.edtElevId);
        btnGetElevById = findViewById(R.id.btnGetElev);
        txtShowElev = findViewById(R.id.txtShowElev);

        btnGetElevById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                IPersonService service = ServiceBuilder.buildService(IPersonService.class);
                int id = Integer.parseInt(edtElevId.getText().toString());
                Call<Elev> request = service.getPersonById(id);
                request.enqueue(new Callback<Elev>() {
                    @Override
                    public void onResponse(Call<Elev> call, Response<Elev> response)
                    {
                        Elev p = response.body();
                        txtShowElev.setText(p.getName() + " " +p.getJob());
                    }

                    @Override
                    public void onFailure(Call<Elev> call, Throwable t)
                    {
                       txtShowElev.setText(t.getMessage());
                    }
                });

            }
        });


    }
}