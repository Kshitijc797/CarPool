package com.example.user.projectwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Subjects extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;

    Button Book,Give,currloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");

        auth = FirebaseAuth.getInstance();

        Book=findViewById(R.id.button2);
        Give=findViewById(R.id.button3);
        currloc=findViewById(R.id.button);

        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Subjects.this,Book_a_ride.class);
               startActivity(intent);



              //  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });

        Give.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects.this,Give_a_ride.class);
                startActivity(intent);
              //  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });

        currloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects.this,CurrentLoc.class);
                startActivity(intent);
                  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    //To change fragment tool bar name
    public  void  setActionBarTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed()
    {
        getSupportActionBar().setTitle("Home");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.subjects, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home)
        {
            Intent intent = new Intent(this,Subjects.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


         if (id == R.id.tips)
        {
            Intent intent = new Intent(Subjects.this,Tips.class);
            startActivity(intent);
        }
        else if (id == R.id.settings)
        {
            Intent intent = new Intent(Subjects.this,Settings.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.feedback)
        {
            Intent intent = new Intent(Subjects.this,Feedback.class);
            startActivity(intent);
        }
        else if (id == R.id.about_us)
        {

            Intent intent = new Intent(Subjects.this,AboutUs.class);
            startActivity(intent);
        }
         else if (id == R.id.quiz)
         {

             Intent intent = new Intent(Subjects.this,Frst_Test_Level.class);
             startActivity(intent);
         }

        else if (id == R.id.score)
        {
            Intent intent = new Intent(Subjects.this,ScoreCard.class);
            startActivity(intent);
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
