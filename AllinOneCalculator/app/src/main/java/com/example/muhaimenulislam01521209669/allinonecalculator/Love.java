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

public class Love extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_love);
    }

    public static int BirthNo(int num){
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 9)
        {
            sum = BirthNo(sum);
        }
        return sum;

    }

    public void onCalLove(View view){

        final EditText bName = (EditText) findViewById(R.id.bName);
        final EditText bBirth = (EditText) findViewById(R.id.bBirth);
        final EditText gName = (EditText) findViewById(R.id.gName);
        final EditText gBirth = (EditText) findViewById(R.id.gBirth);

        if (TextUtils.isEmpty(bName.getText().toString())) {
            bName.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(bBirth.getText().toString())) {
            bBirth.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(gName.getText().toString())) {
            gName.setError("Invalid Input");
            return;
        }
        if (TextUtils.isEmpty(gBirth.getText().toString())) {
            gBirth.setError("Invalid Input");
            return;
        }

        Intent i = new Intent(this,LoveResult.class);

        String b = bName.getText().toString();
        int bb = Integer.parseInt(bBirth.getText().toString());
        String g = gName.getText().toString();
        int gb = Integer.parseInt(gBirth.getText().toString());

        final int[][] a = new int[][]{
                { 50, 75, 75, 20, 20, 100, 75, 50, 75 },
                { 75, 100, 50, 75, 20, 50, 75, 50, 100 },
                { 75, 50, 20, 50, 75, 50, 50, 20, 100 },
                { 20, 75, 50, 100, 50, 100, 75, 75, 75 },
                { 20, 20, 75, 50, 20, 50, 50, 50, 50 },
                { 75, 100, 100, 100, 50, 100, 75, 75, 100 },
                { 75, 75, 50, 75, 50, 50, 100, 50, 100 },
                { 50, 50, 20, 75, 50, 50, 50, 50, 50 },
                { 75, 100, 100, 75, 50, 100, 100, 75, 100 }
        };


        String output=null;
        int per,len,x,y;
        x=BirthNo(bb);
        y=BirthNo(gb);
        per = a[y-1][x-1];
        String temp1 = b+g;
        String temp = temp1.toUpperCase();
        len=temp.length();


        int flag=1;
        if(bb>31 || bb<1){
            flag =2;
        }else if(gb>31 || gb<1){
            flag=3;
        }
        for (int j=0;j<len-1;j++){
            if(temp.charAt(j)<'A' && temp.charAt(j)!=' '){
                flag=0;
            }else if( temp.charAt(j)>'Z'){
                flag=0;
            }
        }

        String s = null;

        if(flag==1){
            String lname="";
            char ch1,ch2;
            int sum=0,ans=0;
            for(int j=0; j<len-1; j++)
            {
                ch1=temp.charAt(j); // Extracting the first character
                ch2=temp.charAt(j+1); // Extracting the next character
                // Adding the first extracted character to the result if the current and the next characters are different
                if(ch1!=ch2)
                {
                    lname = lname + ch1;
                }
            }
            lname=lname+temp.charAt(len-1);

            for(int j=0;j<lname.length();j++){
                sum=sum+(int)lname.charAt(j);
            }

            ans=(sum%16)+(per-15);

            output=Integer.toString(ans);

            s="ok";
            i.putExtra("check",s);
            i.putExtra("loveRes",output);
            i.putExtra("bn",b);
            i.putExtra("gn", g);

        }else if(flag==2){ // boy's birth problem
            s ="boy";
            i.putExtra("check",s);
        }else if(flag==3){ //girl's birth problem
            s = "girl";
            i.putExtra("check",s);

        }else if(flag==0){ //name problem
            s = "name";
            i.putExtra("check",s);
        }

        startActivity(i);

    }


    public void onRefreshL(View view){
        clearForm((ViewGroup) findViewById(R.id.loveLayout));
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
