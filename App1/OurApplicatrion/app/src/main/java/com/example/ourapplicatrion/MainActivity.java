package com.example.ourapplicatrion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = findViewById(R.id.txtMessage);
        Button btnTryk = findViewById(R.id.btnTryk);
        
        btnTryk.setOnClickListener((v) -> txtMessage.setText("Hej"));
    }
    @Override
    public void onClick(View v)
    {
        txtMessage.setText("Der blev trykket på knappen");
    }
}