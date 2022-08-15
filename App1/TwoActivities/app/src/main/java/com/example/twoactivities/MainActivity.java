package com.example.twoactivities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    //TextView txtFromSecond;
    ActivityResultLauncher<Intent> secondActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoToSecond = findViewById(R.id.btnGoToSecond);
        //txtFromSecond = findViewById(R.id.txtFromSecond);

//        secondActivityLauncher = registerForActivityResult(
//        new ActivityResultContracts.StartActivityForResult(),
//        new ActivityResultCallback<ActivityResult>() {
//            @Override
//            public void onActivityResult(ActivityResult result) {
//                if (result.getResultCode() == Activity.RESULT_OK) {
//                    // There are no request codes
//                    Intent data = result.getData();
//                    String message = data.getStringExtra("TextFromSecond");
//                    Log.v("Tag",message);
//                }
//            }
//        });

        btnGoToSecond.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("TextToSecond", "Hej fra Main");
                //startActivity(intent);
                startActivityForResult(intent, 1);
                //secondActivityLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            String message = data.getStringExtra("TextFromSecond");
            Log.v("Tag", message);
            //txtFromSecond.setText(message);
        }
    }
}

