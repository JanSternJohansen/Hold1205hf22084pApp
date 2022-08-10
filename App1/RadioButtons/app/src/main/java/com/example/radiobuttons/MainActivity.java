package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    RadioGroup rdgColor;
    Button btnTryk;
    TextView txtMessage;
    CheckBox chkElev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdgColor = findViewById(R.id.rdgColor);
        btnTryk = findViewById(R.id.btnTryk);
        txtMessage = findViewById(R.id.txtMessage);
        chkElev = findViewById(R.id.chkElev);

        btnTryk.setOnClickListener(v ->
        {
            txtMessage.setText("");
            switch(rdgColor.getCheckedRadioButtonId())
            {
                case R.id.rdbRed:
                    txtMessage.setText("Red is chosen");
                    break;
                case R.id.rdbGreen:
                    txtMessage.setText("Green is chosen");
                    break;
                case R.id.rdbBlue:
                    txtMessage.setText("Blue is chosen");
                    break;
                default: txtMessage.setText("No color is chosen");
            }

            if(chkElev.isChecked())
                txtMessage.setText(txtMessage.getText() + " Elev");
            else
                txtMessage.setText(txtMessage.getText() + " Ikke Elev");
        });

        rdgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdbBlue)
                    txtMessage.setText("Blue color chosen");
            }
        });

        chkElev.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }
}