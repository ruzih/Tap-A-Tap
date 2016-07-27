package com.example.ruiz.tappamole;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rh185147 on 7/27/2016.
 */
public class Pop extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_instructions);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.9));

        Handler handle = new Handler();
        Handler handle1 = new Handler();
        Handler handle2 = new Handler();
        Handler handle3 = new Handler();
        Handler handle4 = new Handler();
        Handler handle5 = new Handler();
        Handler handle6 = new Handler();

        //TextView instTitle = (TextView) findViewById(R.id.textView5);
        final TextView inst1 = (TextView) findViewById(R.id.textView6);
        final TextView inst2 = (TextView) findViewById(R.id.textView7);
        final TextView inst3 = (TextView) findViewById(R.id.textView8);
        final TextView inst4 = (TextView) findViewById(R.id.textView9);
        final TextView inst5 = (TextView) findViewById(R.id.textView10);
        final TextView inst6 = (TextView) findViewById(R.id.textView11);
        final TextView inst7 = (TextView) findViewById(R.id.textView12);

        //instTitle.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst1.setText("Choose a theme from the top right");
                inst1.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 100);
        handle1.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst2.setText("Choose your difficulty");
                inst2.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 100);
        handle2.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst3.setText("Tap!");
                inst3.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 100);
        handle3.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst4.setText("You can gain a max score of:");
                inst4.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 1000);
        handle4.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst5.setText("10 on EASY");
                inst5.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 1500);
        handle5.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst6.setText("20 on MEDIUM");
                inst6.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 2000);
        handle6.postDelayed(new Runnable() {
            @Override
            public void run() {
                inst7.setText("30 on HARD");
                inst7.startAnimation(AnimationUtils.loadAnimation(Pop.this, android.R.anim.slide_in_left));
            }
        }, 2500);

    }
}
