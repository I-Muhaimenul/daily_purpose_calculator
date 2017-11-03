package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class Simple extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_simple);
    }

    public void onClick(View view) {



        //-----getting the edittext value to a variable--------//
        final EditText firstNo = (EditText) findViewById(R.id.firstNo);
        final EditText sign = (EditText) findViewById(R.id.sign);
        final EditText secNo = (EditText) findViewById(R.id.secNo);
        TextView result = (TextView)findViewById(R.id.result);

        //--------Constrain of a edittext feild can be given by the methode below-------------//
        if (TextUtils.isEmpty(firstNo.getText().toString())) {
            firstNo.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(sign.getText().toString())) {
            sign.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(secNo.getText().toString())) {
            secNo.setError("Invalid Input");
            return;
        }

        //-------putting converting the edittext variable to a java varaible for use in code------//
        double first = Double.parseDouble(firstNo.getText().toString());
        String s = sign.getText().toString();
        double sec = Double.parseDouble(secNo.getText().toString());

        double result1 = 0;  //temporary result variable
        int flag = 1;
        String output;

        if (s.equals("+")) {
            result1 = first + sec;
        } else if (s.equals("-")) {
            result1 = first - sec;

        } else if (s.equals("*")) {
            result1 = first * sec;
        } else if (s.equals("/")) {
            try {
                if (sec == 0) {
                    flag = 0;
                } else {
                    result1 = first / sec;
                }
            } catch (Exception e) {
            }
        } else if (s.equals("%")) {
            result1 = first * sec * 0.01;
        } else {
            flag = 2;
        }

        if (flag == 1) {
            output = Double.toString(result1);
        } else if (flag == 2) {
            output="Undefine Sign";
        } else {
            output = "Can't Divide by Zero";
        }
        String show = "= "+output;
        result.setText(show);
    }

    public void onRefresh(View view){
        /*Intent refresh = new Intent(this, Simple.class);  //This is
        startActivity(refresh);                             //the method for
        this.finish();*/                                    //reloading an activity
        clearForm((ViewGroup) findViewById(R.id.simpleLayout));
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
