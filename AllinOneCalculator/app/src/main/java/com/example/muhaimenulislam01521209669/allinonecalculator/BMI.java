package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.view.View;
import android.view.Window;

public class BMI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bmi);
    }

    public void onStand(View view){
        Intent i1 =new Intent(this, StandardBMI.class);
        startActivity(i1);
    }

    public void onMet(View view){
        Intent i2 = new Intent(this,MetricBmi.class);
        startActivity(i2);
    }
}
