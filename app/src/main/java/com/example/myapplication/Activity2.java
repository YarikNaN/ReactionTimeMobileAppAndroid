package com.example.myapplication;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    private LinearLayout b;
    private Button b1;
    static Handler h = new Handler();
    private int c=0,vvv=0;

    long timeTotal, timeWhileGreen;
    boolean tooEarly = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);





        // create random value between 2000 and 4500
        // This value will be used for the timed switch (in ms)
        long timeColorSwitch = ((long) (Math.random()*3.5)+2)*1000;



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // create a timed switch
        h.postDelayed(createSwitchTimer(), timeColorSwitch); //launch with delay


    }



    private Runnable createSwitchTimer() {
        return new Runnable() {
            @Override
            public void run() {
                // only enable green plane when red plane has not been pressed
                if (!tooEarly) {
                    // take a snapchat of current time for further subtraction
                    timeTotal = SystemClock.elapsedRealtime();
                    changeViewState(findViewById(R.id.greenPlane), true, View.VISIBLE);    // entry point, change to green

                }
            }
        };
    }




    private void changeViewState(View v, boolean clickable, int vis) {
        v.setClickable(clickable);
        v.setVisibility(vis);
    }

    private void changeViewState(View v, boolean clickable) {
        changeViewState(v, clickable, v.getVisibility());
    }



    public void failGame(View v) {
        tooEarly = true;
        vvv++;
        if(vvv==2){
            startActivity(new Intent(this, Activity2.class));
            finish();

        }
        c++;


        deliverEndTitle().setText("You failed");
        TextView textEndFail1 = findViewById(R.id.textEnd1);

        textEndFail1.setVisibility(View.VISIBLE);
    }

    public void winGame(View v) {
        vvv++;
        if(vvv==2){
            startActivity(new Intent(this, Activity2.class));
            finish();

        }

        // this calculates the time elasped while green plane was untouched
        timeWhileGreen = SystemClock.elapsedRealtime()-106 - timeTotal;
        if(vvv==1 & c==0){
        deliverEndTitle().setText(totalTimeToString());
            TextView textEndFail1 = findViewById(R.id.textEnd1);

            textEndFail1.setVisibility(View.VISIBLE);}


    }


    private TextView deliverEndTitle() {
        TextView textEndFail = findViewById(R.id.textEnd);

        textEndFail.setVisibility(View.VISIBLE);

        return textEndFail;
    }

    private String totalTimeToString() {
        return timeWhileGreen + " " + "ms";
    }



}






