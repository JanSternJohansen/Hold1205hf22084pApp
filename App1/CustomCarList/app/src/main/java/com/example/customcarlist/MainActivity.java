package com.example.customcarlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Bil> biler = new ArrayList<Bil>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        biler.add(new Bil("VW T1 Rugbrød",
                "Berk elsker denne dejlige folkvognsbus",
                R.drawable.vw_t1));
        biler.add(new Bil("BMW Isetta",
                "Jans kabinescooter og invalidebil",
                R.drawable.bmw_isetta));
        biler.add(new Bil("Cadillac",
                "Nicolajs flyder",
                R.drawable.cadilac));
        biler.add(new Bil("Ford Fairlane",
                "Owen kører wroom... wroom...",
                R.drawable.ford_fairlane));
        biler.add(new Bil("Ford Zephyr",
                "En rigtig pløjemark racer",
                R.drawable.ford_zephyr));
        biler.add(new Bil("Chevrolet Impala",
                "Tavs lækre øse",
                R.drawable.impala));
        biler.add(new Bil("Jaguar",
                "Lucas a Grömma springer i den og kører på Island",
                R.drawable.jaguar));
        biler.add(new Bil("Jaguar Sport",
                "Mies foretrukne bil til skole",
                R.drawable.jaguar_sport));
        biler.add(new Bil("VW T1 Rugbrød",
                "Berk har et problem",
                R.drawable.opel_record));
        biler.add(new Bil("Smart og volsom volvo",
            "Sofies drøm om en Smart (bil)",
            R.drawable.volvo_amazon));
        biler.add(new Bil("Shelby",
            "Nirakash har købt den på Cuba",
            R.drawable.shelby));

        BilAdapter bilAdapter = new BilAdapter(biler, this);
        ListView lstBiler = findViewById(R.id.lstBiler);
        lstBiler.setAdapter(bilAdapter);
    }
}