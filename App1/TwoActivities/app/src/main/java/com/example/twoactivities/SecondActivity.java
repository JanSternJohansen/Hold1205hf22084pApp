package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    TextView txtShowMessage;
    EditText edtWriteReturnText;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        edtWriteReturnText = findViewById(R.id.edtWriteReturnText);

        txtShowMessage = findViewById(R.id.txtSecond_ShowMessage);
        intent = getIntent();
        String message = intent.getStringExtra("MessageToSecond");
        txtShowMessage.setText(message);
    }

    public void goBack(View v)
    {
        intent.putExtra("FromSecond", edtWriteReturnText.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}