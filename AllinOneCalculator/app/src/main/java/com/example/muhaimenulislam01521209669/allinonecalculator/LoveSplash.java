package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;

public class LoveSplash extends Activity {

    private GestureDetectorCompat gestureD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_love_splash);

        Thread startTimer = new Thread(){
            public void run(){
                try{
                    sleep(2000); //6 sec
                    Intent i = new Intent(LoveSplash.this,Love.class);
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
