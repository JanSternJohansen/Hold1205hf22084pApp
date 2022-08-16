package com.example.regnermedspinnerogmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTal1, edtTal2;
    TextView txtResult;
    Button btnResult;
    Spinner spnOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String[] operator = {"+", "-", "*", "/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.spinner_item,  // Custom layout
                getResources().getStringArray(R.array.operands));

        spnOperator = findViewById(R.id.spnOperator);
        spnOperator.setAdapter(adapter);
        edtTal1 = findViewById(R.id.edtTal1);
        edtTal2 = findViewById(R.id.edtTal2);
        txtResult = findViewById(R.id.txtResult);
        btnResult = findViewById(R.id.btnBeregn);
        btnResult.setOnClickListener(this);

        registerForContextMenu(txtResult);
    }

    @Override
    public void onClick(View v)
    {
        compute();
    }

    public void compute(){
        int tal1 = Integer.parseInt(edtTal1.getText().toString());
        int tal2 = Integer.parseInt(edtTal2.getText().toString());
        int result = 0;

        switch (spnOperator.getSelectedItem().toString()) {
            case "+":
                result = tal1 + tal2;
                break;
            case "-":
                result = tal1 - tal2;
                break;
            case "*":
                result = tal1 * tal2;
                break;
            case "/":
                result = tal1 / tal2;
                break;
        }
        txtResult.setText(result + "");

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        Log.v("Tag", "I Contextmenu");
        if (v == txtResult) {
            menu.setHeaderTitle("Vælg operator");
            menu.add(Menu.NONE, 0, Menu.NONE, "+");
            menu.add(Menu.NONE, 1, Menu.NONE, "-");
            menu.add(Menu.NONE, 2, Menu.NONE, "*");
            menu.add(Menu.NONE, 3, Menu.NONE, "/");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        int itemId = item.getItemId();
        spnOperator.setSelection(itemId);
        compute();
        Snackbar.make(spnOperator, "Du valgte: " + item.getTitle(), Snackbar.LENGTH_LONG).show();
        return super.onContextItemSelected(item);
    }

}