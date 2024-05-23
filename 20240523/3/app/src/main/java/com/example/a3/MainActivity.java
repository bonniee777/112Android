package com.example.a3;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView)findViewById(R.id.lblOutput);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText txtOpd1, txtOpd2;
                txtOpd1 = (EditText) findViewById(R.id.txtOpd1) ;
                txtOpd2 = (EditText) findViewById(R.id.txtOpd2) ;
                Intent intent  = new Intent(MainActivity.this, OpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("OPERAND1",txtOpd1.getText().toString());
                bundle.putString("OPERAND2",txtOpd1.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    output.setText("計算結果: " + bundle.getDouble("RESULT"));
                }
                break;
        }
    }
}