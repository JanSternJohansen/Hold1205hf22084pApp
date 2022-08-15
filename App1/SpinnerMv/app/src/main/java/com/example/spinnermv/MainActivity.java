package com.example.spinnermv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    Spinner spnNames;
    List<String> names;
    TextView txtSpinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSpinnerValue = findViewById(R.id.txtSpinnerValue);
        names = new ArrayList<String>(Arrays.asList("Tavs", "Daniel", "Berk", "Mie", "Christine",
                "Manish", "Lucas", "Kasper", "Rizwana"));

        spnNames = findViewById(R.id.spnNames);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnNames.setOnItemSelectedListener(this);

        spnNames.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent,
                               View view, int position, long id)
    {
        String name = names.get(position);
        txtSpinnerValue.setText(name);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}