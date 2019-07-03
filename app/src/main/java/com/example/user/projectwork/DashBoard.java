package com.example.user.projectwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    Button btnuser, btnride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        getSupportActionBar().setTitle("ADMIN DASHBOARD");
        //buttons ko get krlio apne accordingly

        btnuser = findViewById(R.id.ViewUser);
        btnride = findViewById(R.id.ViewRide);

        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(DashBoard.this,UserDetails.class);
                startActivity(intent);
                //  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });

        btnride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(DashBoard.this,RideDetails.class);
                startActivity(intent);
                //  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
