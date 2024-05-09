package com.example.a06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener.CompoundButton.OnCheckedChange {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                //檢查勾選那些披薩
                CheckBox original = (CheckBox) findViewById(R.id.chkOriginal);
                CheckBox beef = (CheckBox) findViewById(R.id.chkBeef);
                CheckBox seafood = (CheckBox) findViewById(R.id.chkSeafood);
                String str = "";
                if (original.isChecked())
                    str += original.getText() + "\n";
                if (beef.isChecked())
                    str += beef.getText() + "\n";
                if (seafood.isChecked())
                    str += seafood.getText() + "\n";
                //顯示訂購項目
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(str);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        TextView txvStatus = (TextView) findViewById(R.id.lblOutput);
        int id = buttonView.getId();
        String str = "";
        String status = "";
            if (id == R.id.chkOriginal){
                status = (isChecked? "選取" : "取消") + "原味...";
    } else if (id == R.id.chkBeef) {
                status = (isChecked? "選取" : "取消") + "牛肉...";
    }else if (id == R.id.chkSeafood) {
                status = (isChecked? "選取" : "取消") + "海鮮...";
    }
            txvStatus.setText(status);
        for (int i : chkIDs){
            CheckBox chk = (CheckBox) findViewById(i);
            if (chk.isChecked())
                str += chk.getText() + "\n";
        }
        //顯示訂購項目
        output.setText(str);
       }
   }