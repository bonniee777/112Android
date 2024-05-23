package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText txtC = (EditText) findViewById(R.id.txtC);
                int tempC = Integer.parseInt((txtC.getText().toString()));
                EditText edtPlace = (EditText) findViewById(R.id.edtplace);
                Intent intent = new Intent(MainActivity.this, FActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("TEMPC", String.valueOf(tempC));
                bundle.putInt("PLACE", Integer.parseInt(edtPlace.getText().toString()));
                intent .putExtras(bundle);
                startActivity(intent);
            }

        });
    }
}