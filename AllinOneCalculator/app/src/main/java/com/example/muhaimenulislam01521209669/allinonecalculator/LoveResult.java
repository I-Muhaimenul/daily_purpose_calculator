package com.example.muhaimenulislam01521209669.allinonecalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.*;
import android.view.Window;
import android.widget.TextView;

public class LoveResult extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_love_result);

        Bundle main = getIntent().getExtras();
        if(main==null){
            return;
        }

        TextView loveFinal = (TextView)findViewById(R.id.loveFinal);
        TextView pers = (TextView)findViewById(R.id.pers);
        String check = main.getString("check");

        String mainLove=null;

        if(check.equals("ok")){

            String loveRes = main.getString("loveRes");
            String bNm = main.getString("bn");
            String gNm = main.getString("gn");
            mainLove= "Love rating\nfor\n"+bNm+" & "+gNm+"\nis";
            pers.setText(loveRes+"%");

        }else if(check.equals("name")){
            mainLove= "Invalid Name!";
        }else if(check.equals("boy")){
            mainLove= "Invalid Boy's Birthday!\nBirthday shoud be between 1 to 31";
        }else if(check.equals("girl")){
            mainLove= "Invalid Girl's Birthday!\nBirthday shoud be between 1 to 31";
        }

        loveFinal.setText(mainLove);

    }
}
