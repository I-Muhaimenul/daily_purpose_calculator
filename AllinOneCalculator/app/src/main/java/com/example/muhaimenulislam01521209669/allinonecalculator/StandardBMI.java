package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class StandardBMI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_standard_bmi);
    }

    public void onCalStand(View view){
        final EditText feet = (EditText) findViewById(R.id.feet);
        final EditText inch = (EditText) findViewById(R.id.inch);
        final EditText pound = (EditText) findViewById(R.id.pound);
        TextView bmiResultS = (TextView)findViewById(R.id.bmiResultS);

        if (TextUtils.isEmpty(feet.getText().toString())) {
            feet.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(inch.getText().toString())) {
            inch.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(pound.getText().toString())) {
            pound.setError("Invalid Input");
            return;
        }

        double ft = Double.parseDouble(feet.getText().toString());
        double in = Double.parseDouble(inch.getText().toString());
        double pn = Double.parseDouble(pound.getText().toString());

        double height = ft*12+in;
        double x =  (pn/ (height* height)) * 703;
        String output=null;
        String result=null;
        String BMI=null;

        if(x<15.0) result="Very severely underweight";
        else if(x>=15.0 && x<16.0) result="Severely underweight";
        else if(x>=16.0 && x<18.5) result="Underweight";
        else if(x>=18.5 && x<25.0) result="Normal(healthy weight)";
        else if(x>=25.0 && x<30.0) result="Overweight";
        else if(x>=30.0 && x<35.0) result="Obese Class I(Moderately obese)";
        else if(x>=35.0 && x<40.0) result="Obese Class II(Severely obese)";
        else if(x>=40.0) result="Obese Class III(Very severely obese)";

        DecimalFormat numberFormat = new DecimalFormat("#.000");
        BMI = numberFormat.format(x);
        //BMI = Double.toString(x);
        output = BMI+"\n"+result;
        bmiResultS.setText(output);

    }
    public void onBMIRS(View view){
        clearForm((ViewGroup) findViewById(R.id.stanLayout));
    }
    private void clearForm(ViewGroup group) // This is the method for clearing multiple edittext
    {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }
            if(view instanceof ViewGroup && (((ViewGroup)view).getChildCount() > 0))
                clearForm((ViewGroup)view);
        }
    }
}
