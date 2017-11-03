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

public class MetricBmi extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_metric_bmi);
    }

    public void onCalMet(View view){

        final EditText cm = (EditText) findViewById(R.id.cm);
        final EditText kg = (EditText) findViewById(R.id.kg);
        TextView bmiResultM = (TextView)findViewById(R.id.bmiResultM);
        
        if (TextUtils.isEmpty(cm.getText().toString())) {
            cm.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(kg.getText().toString())) {
            kg.setError("Invalid Input");
            return;
        }


        double c = Double.parseDouble(cm.getText().toString());
        double k = Double.parseDouble(kg.getText().toString());

        double height = c/100;
        double x =  (k/ (height* height));
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
        bmiResultM.setText(output);
    }

    public void onBMIRM(View view){
        clearForm((ViewGroup) findViewById(R.id.metLayout));
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
