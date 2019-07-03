package com.example.user.projectwork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ScoreCard extends AppCompatActivity {




    TextView high_scr,high_scr_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("ScoreCard");



        high_scr=findViewById(R.id.textView2);
        high_scr_no= findViewById(R.id.textView3);





                SharedPreferences pref = getSharedPreferences("sharedPrefs_OS", MODE_PRIVATE);
                int highScore = pref.getInt("keyHighscore",0);
                high_scr_no.setText(String.valueOf(highScore));





    }

}
