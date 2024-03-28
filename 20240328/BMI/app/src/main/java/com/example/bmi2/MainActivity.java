package com.example.bmi2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txvShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        EditText edtHeight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
            double height = Double.parseDouble(edtHeight.getText().toString());
            double weight = Double.parseDouble(edtWeight.getText().toString());
            double bmi = weight / Math.pow(height/100.0 , 2);
            if (bmi >= 24)
                txvShow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txvShow.setTextColor(Color.BLUE);
            else
                txvShow.setTextColor(Color.GREEN);

            txvShow.setText(String.format("%.2f", bmi));
        }
        });
       btnClaer.setOnclickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               wdtHeight.setText("0");
               edtWeight.setText("0");
               txvSow..setText("");
        }
                });
        }
        }