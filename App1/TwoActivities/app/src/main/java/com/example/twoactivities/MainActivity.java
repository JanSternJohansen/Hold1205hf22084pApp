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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static final int REQ_SECOND = 1;
    public static final int REQ_THIRD = 2;
    public static final String TEXT_TO_SECOND = "TextToSecond";
    public static final String TEXT_FROM_SECOND = "TextFromSecond";


    Button btnGoToSecond;
    EditText edtWriteToSecond;
    TextView txtFromSecond;
    ActivityResultLauncher<Intent> someActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFromSecond = findViewById(R.id.txtFromSecond);
        edtWriteToSecond = findViewById(R.id.edtWriteToSecond);
        btnGoToSecond = findViewById(R.id.btnGoToSecond);

        someActivityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // There are no request codes
                    Intent data = result.getData();
                    String message = data.getStringExtra(TEXT_FROM_SECOND);
                    txtFromSecond.setText(message);
                }
            }
        });
        
        btnGoToSecond.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra(TEXT_TO_SECOND, edtWriteToSecond.getText().toString());
                //startActivity(intent);
                //startActivityForResult(intent, REQ_SECOND);
                someActivityResultLauncher.launch(intent);
            }
        });
    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == REQ_SECOND && resultCode == Activity.RESULT_OK)
//        {
//            String message = data.getStringExtra(TEXT_FROM_SECOND);
//            txtFromSecond.setText(message);
//        }
//    }
}

//       someActivityResultLauncher = registerForActivityResult(
//                new ActivityResultContracts.StartActivityForResult(),
//                new ActivityResultCallback<ActivityResult>() {
//                    @Override
//                    public void onActivityResult(ActivityResult result) {
//                        if (result.getResultCode() == Activity.RESULT_OK) {
//                            // There are no request codes
//                            Intent data = result.getData();
//                            String message = data.getStringExtra("FromSecond");
//                            txtFromSecond.setText(message);
//                        }
//                    }
//              });