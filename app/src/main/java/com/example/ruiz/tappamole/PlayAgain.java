package com.example.ruiz.tappamole;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import org.w3c.dom.Text;

public class PlayAgain extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3692242272677226~3334299192");

        AdView mAdView = (AdView) findViewById(R.id.adView3);
        //AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().build();
       /* AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("761316502B9C618E72C35A0DF4275F3F")
                .build();*/
        mAdView.loadAd(adRequest);

        final TextView scoreShow = (TextView) findViewById(R.id.textView3) ;
        Typeface face0 = Typeface.createFromAsset(getAssets(), "fonts/Crayon.ttf");
        scoreShow.setTypeface(face0);
/*
        Gameplay dataSteal = new Gameplay();
        scoreShow.setText("Your Score: " + String.format("%02d", dataSteal.points));*/
        scoreShow.setText("Your Score: " + String.format("%02d", Gameplay.POINTS));
        final TextView title1 = (TextView) findViewById(R.id.textView);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Bungee.ttf");
        title1.setTypeface(face);

        Button menuBut = (Button)findViewById(R.id.menuPlay);
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Gameplay.class);
                startActivity(intent);
            }
        });
        Button menuBut2 = (Button)findViewById(R.id.button);
        menuBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayMenu.class);
                startActivity(intent);
            }
        });
    }
}
