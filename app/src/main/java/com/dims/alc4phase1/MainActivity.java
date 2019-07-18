package com.dims.alc4phase1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Button mAboutALC;
    Button mMyProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.alc_home);

        mAboutALC = findViewById(R.id.about_alc);
        mMyProfile = findViewById(R.id.my_profile);

        mAboutALC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aboutALCIntent = new Intent(getApplicationContext(),AboutALC.class);
                startActivity(aboutALCIntent);
            }
        });

        mMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProfileIntent = new Intent(getApplicationContext(),MyProfile.class);
                startActivity(myProfileIntent);
            }
        });
    }
}
