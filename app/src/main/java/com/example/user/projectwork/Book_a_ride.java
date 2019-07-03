package com.example.user.projectwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book_a_ride extends AppCompatActivity {
    EditText pick, drop;
    Button btnfind;
    ProgressBar progressBar;
    List<Users> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_a_ride);
        progressBar = findViewById(R.id.progressBar);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search a Ride");
        pick = findViewById(R.id.TextPickup);
        drop = findViewById(R.id.TextDropOff);
        btnfind = findViewById(R.id.buttonFind);

        usersList = new ArrayList<>();

        /*findViewById(R.id.buttonFind).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                findRide();
            }
        });*/

        btnfind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                final String pickup = pick.getText().toString().trim();
                final String dropoff = drop.getText().toString().trim();

                if (TextUtils.isEmpty(pickup)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Pick Location!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (TextUtils.isEmpty(dropoff)) {
                    Toast.makeText(getApplicationContext(), "Enter Your Drop Location!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(Book_a_ride.this,Ride_list.class);
                startActivity(intent);

                pick.setText("");
                drop.setText("");
                //  Toast.makeText(Subjects.this,"Your Current Location Finder",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*private void findRide(){
        final String pickup = pick.getText().toString().trim();
        final String dropoff = drop.getText().toString().trim();

        if (TextUtils.isEmpty(pickup)) {
            pick.setError("Please enter Pick Location");
            pick.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(dropoff)) {
            drop.setError("Please enter Drop Location");
            drop.requestFocus();
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_FIND,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject usersJson = obj.getJSONObject("users");

                                //creating a new user object
                                Users user = new Users(
                                        usersJson.getString("firstname"),
                                        usersJson.getString("lastname"),
                                        usersJson.getString("mobile")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userView(user);
                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), Ride_list.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("pickup", pickup);
                params.put("dropoff", dropoff);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }*/
}