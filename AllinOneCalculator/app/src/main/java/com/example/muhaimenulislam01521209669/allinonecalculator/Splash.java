package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.*;
import android.view.Window;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        Thread startTimer = new Thread(){
            public void run(){
                try{
                    sleep(3000); //6 sec
                    Intent i = new Intent(Splash.this,Option.class);
                    startActivity(i);
                    finish();

                }catch (InterruptedException e){
                    e.printStackTrace();

                }
            }
        };
        startTimer.start();
    }
}
