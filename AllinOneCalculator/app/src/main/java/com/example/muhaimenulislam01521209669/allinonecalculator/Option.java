package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.view.View;

public class Option extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }

    public void onCalc(View view){
        Intent i1 =new Intent(this, Simple.class);
        startActivity(i1);
    }

    public void onAge(View view){
        Intent i2 = new Intent(this,Age.class);
        startActivity(i2);
    }

    public void onBMI(View view){
        Intent i3 = new Intent(this,BMI.class);
        startActivity(i3);
    }

    public void onLove(View view){
        Intent i4 = new Intent(this,LoveSplash.class);
        startActivity(i4);
    }

    public void onCredit(View view){
        Intent i5 = new Intent(this,about.class);
        startActivity(i5);
    }


}
