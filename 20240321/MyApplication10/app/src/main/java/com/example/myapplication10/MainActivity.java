package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txvBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txvBMI = (TextView) findViewById(R.id.txvBMI);
        txvBMI.setTextSize(36);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this::onClick);
        button2.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View v) {
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);

        if (v.getId() == R.id.button1) {
            double height = Double.parseDouble(edtHeight.getText().toString());
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double bmi = weight / Math.pow(height/100.0 , 2);
            if (bmi >= 24)
                txvBMI.setTextColor(Color.RED);
            else if (bmi < 18.5);
                txvBMI.setTextColor(Color.BLUE);
            else
                txvBMI.setTextColor(Color.GREEN);

            txvBMI.setText(String.format("%.2f", bmi));
        }
        else {
            edtHeight.setText("0");
            edtWeight.setText("0");
            txvBMI.setText("");

        }
    }
}