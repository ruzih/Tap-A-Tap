package com.example.ruiz.tappamole;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class PlayMenu extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        // Do Here what ever you want do on back press;
    }

    //boolean toggleCheck = false;
    boolean checkedBefore = false;
    int state = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_menu);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3692242272677226~3334299192");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
       /* AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("761316502B9C618E72C35A0DF4275F3F")
                .build();*/
        mAdView.loadAd(adRequest);


        final Toast themeToggle1 = Toast.makeText(PlayMenu.this, "Ant Theme", Toast.LENGTH_SHORT);
        themeToggle1.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 10);
        final Toast themeToggle2 = Toast.makeText(PlayMenu.this, "Classic Theme", Toast.LENGTH_SHORT);
        themeToggle2.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 10);
        final Toast themeToggle3 = Toast.makeText(PlayMenu.this, "Cloud Theme", Toast.LENGTH_SHORT);
        themeToggle3.setGravity(Gravity.TOP|Gravity.RIGHT, 0, 10);
/*
        final ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && !checkedBefore) {
                    checkedBefore = true;
                    themeToggle1.show();
                    toggleCheck = true;
                }else if (isChecked && checkedBefore) {
                    // The toggle is enabled
                    themeToggle2.cancel();
                    themeToggle1.show();
                    toggleCheck = true;

                } else {
                    // The toggle is disabled
                    themeToggle1.cancel();
                    themeToggle2.show();
                    toggleCheck = false;
                }
            }
        });
*/
        final TextView title1 = (TextView) findViewById(R.id.textView);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Bungee.ttf");
        title1.setTypeface(face);
/*
        Button menuBut = (Button)findViewById(R.id.menuPlay);
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), Gameplay.class);
                    startActivity(intent);
                } else if (toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplay.class);
                    startActivity(intent);
                }
            }
        });

        Button menuBut2 = (Button)findViewById(R.id.menuPlay2);
        menuBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), GameplayMED.class);
                    startActivity(intent);
                } else if (toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplayMED.class);
                    startActivity(intent);
                }
            }
        });
        Button menuBut3 = (Button)findViewById(R.id.menuPlay3);
        menuBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), GameplayEZ.class);
                    startActivity(intent);
                } else if (toggleCheck) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplayEZ.class);
                    startActivity(intent);
                }
            }
        });
        */

        final ImageButton toggleButton = (ImageButton) findViewById(R.id.imagebuttontoggle);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0 && checkedBefore) {
                    state = 1;
                    toggleButton.setImageResource(R.drawable.toggle_classic_style);
                    themeToggle3.cancel();
                    themeToggle2.show();
                } else if (state == 1 && !checkedBefore) {
                    checkedBefore = true;
                    state = 2;
                    toggleButton.setImageResource(R.drawable.ant_idle_new);
                    themeToggle1.show();
                } else if (state == 1 && checkedBefore) {
                    state = 2;
                    toggleButton.setImageResource(R.drawable.ant_idle_new);
                    themeToggle2.cancel();
                    themeToggle1.show();
                } else if (state == 2 && checkedBefore) {
                    state = 0;
                    toggleButton.setImageResource(R.drawable.cloud_idle);
                    themeToggle1.cancel();
                    themeToggle3.show();
                }
            }
        });

        Button menuBut = (Button)findViewById(R.id.menuPlay);
        menuBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), CLOUDGameplay.class);
                    startActivity(intent);
                } else if (state == 1) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), Gameplay.class);
                    startActivity(intent);
                } else if (state == 2) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplay.class);
                    startActivity(intent);
                }
            }
        });

        Button menuBut2 = (Button)findViewById(R.id.menuPlay2);
        menuBut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), CLOUDGameplayMED.class);
                    startActivity(intent);
                } else if (state == 1) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), GameplayMED.class);
                    startActivity(intent);
                } else if (state == 2) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplayMED.class);
                    startActivity(intent);
                }
            }
        });

        Button menuBut3 = (Button)findViewById(R.id.menuPlay3);
        menuBut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == 0) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), CLOUDGameplayEZ.class);
                    startActivity(intent);
                } else if (state == 1) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), GameplayEZ.class);
                    startActivity(intent);
                } else if (state == 2) {
                    themeToggle1.cancel();
                    themeToggle2.cancel();
                    themeToggle3.cancel();
                    Intent intent = new Intent(getApplicationContext(), ANTGameplayEZ.class);
                    startActivity(intent);
                }
            }
        });
    }
}
