package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.*;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Age extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_age);

        TextView tvDisplayDate = (TextView) findViewById(R.id.textView4);
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy        h:mma");
        String dateString = sdf.format(date);
        tvDisplayDate.setText(dateString);
    }

    public void onCalAge(View view){

        final EditText bday = (EditText) findViewById(R.id.bday);
        final EditText bmonth = (EditText) findViewById(R.id.bmonth);
        final EditText byear = (EditText) findViewById(R.id.byear);
        final EditText cday = (EditText) findViewById(R.id.cday);
        final EditText cmonth = (EditText) findViewById(R.id.cmonth);
        final EditText cyear = (EditText) findViewById(R.id.cyear);
        TextView ageShow = (TextView)findViewById(R.id.ageShow);

        if (TextUtils.isEmpty(bday.getText().toString())) {
            bday.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(bmonth.getText().toString())) {
            bmonth.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(byear.getText().toString())) {
            byear.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(cday.getText().toString())) {
            cday.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(cmonth.getText().toString())) {
            cmonth.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(cyear.getText().toString())) {
            cyear.setError("Invalid Input");
            return;
        }


        int bd = Integer.parseInt(bday.getText().toString());
        int bm = Integer.parseInt(bmonth.getText().toString());
        int by = Integer.parseInt(byear.getText().toString());
        int cd = Integer.parseInt(cday.getText().toString());
        int cm = Integer.parseInt(cmonth.getText().toString());
        int cy = Integer.parseInt(cyear.getText().toString());
        String output = null;

        if(bd>31||bd<=0||bm>12||bm<=0||by<=0){

            output = "Invalid Birthdate!";

        }else if(cd>31||cd<=0||cm>12||cm<=0||cy<=0){
            output = "Invalid Current date!";

        }else{

            Calendar bDate = Calendar.getInstance();
            bDate.set(by,bm,bd);
            Calendar cDate = Calendar.getInstance();
            cDate.set(cy,cm,cd);

            int flag = bDate.compareTo(cDate);

            int d,m,y;

            if(flag==0){
                output = "0 Day";

            }else if(flag<0){

                if(bd>cd)
                {
                    cm=cm-1;
                    cd=cd+30;
                }
                if(bm>cm)
                {
                    cy=cy-1;
                    cm=cm+12;
                }

                d=cd-bd;
                m=cm-bm;
                y=cy-by;

                String da,mo,ye;
                da= Integer.toString(d);
                mo= Integer.toString(m);
                ye= Integer.toString(y);
                //printf("current age is \n day %d \n month %d \n year %d ",d3,m3,y3);
                output= "Your age is\n"+ ye+"Years "+mo+"Months "+da+"Days";

            }else if(flag>0){
                output="Can't born in future!!";
            }
        }

        ageShow.setText(output);
    }

    public void onRefreshA(View view){
        /*Intent refresh = new Intent(this, Simple.class);  //This is
        startActivity(refresh);                             //the method for
        this.finish();*/                                    //reloading an activity
        clearForm((ViewGroup) findViewById(R.id.AgeLayout));
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
