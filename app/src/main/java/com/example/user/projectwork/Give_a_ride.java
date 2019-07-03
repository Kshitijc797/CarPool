package com.example.user.projectwork;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Give_a_ride extends AppCompatActivity {

    EditText Pick, Drop, Email, Pdate, Rdate;
    int day,month,year;    Button confirm;
    ProgressBar progressBar;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_a_ride);
        progressBar = findViewById(R.id.progressBar);

        Pick = findViewById(R.id.TextPickup);
        Drop = findViewById(R.id.TextDropOff);
        Email = findViewById(R.id.TextEmail);
        Pdate = findViewById(R.id.Textpdate);
        Rdate = findViewById(R.id.Textrdate);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Give Ride");

        confirm = findViewById(R.id.buttonGive);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                giveRide();
            }
        });

        Pdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Calendar ca = Calendar.getInstance();       // for current date

                day=ca.get(Calendar.DAY_OF_MONTH);
                month=ca.get(Calendar.MONTH);
                year=ca.get(Calendar.YEAR);

                new DatePickerDialog(Give_a_ride.this,date,ca.get(Calendar.YEAR),ca.get(Calendar.MONTH),ca.get(Calendar.DAY_OF_MONTH)).show();   //if we want to use date picker dialog in android project we hav to call 5 parameters type constructor of date picker dialog class
                // parameters are 1. context type 2. On dateSetListener 3. integer type year 4. integer type month, 5.integer type day of month
            }
        }); // instead of null in above mentioned code we'll write date


        Rdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Calendar cal = Calendar.getInstance();       // for current date

                day=cal.get(Calendar.DAY_OF_MONTH);
                month=cal.get(Calendar.MONTH);
                year=cal.get(Calendar.YEAR);

                new DatePickerDialog(Give_a_ride.this,dates,cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)).show();   //if we want to use date picker dialog in android project we hav to call 5 parameters type constructor of date picker dialog class
                // parameters are 1. context type 2. On dateSetListener 3. integer type year 4. integer type month, 5.integer type day of month
            }
        });



    }



    private void giveRide(){

        final String pick = Pick.getText().toString().trim();
        final String drop = Drop.getText().toString().trim();
        final String email = Email.getText().toString().trim();
        final String pdate = Pdate.getText().toString().trim();
        final String rdate = Rdate.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_GIVE,
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
                                JSONObject rideJson = obj.getJSONObject("ride");

                                //creating a new user object
                                Ride ride = new Ride(
                                        rideJson.getString("pick"),
                                        rideJson.getString("drop"),
                                        rideJson.getString("email"),
                                        rideJson.getString("pdate"),
                                        rideJson.getString("rdate")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).rideGive(ride);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), Subjects.class));
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
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("pick", pick);
                params.put("drop", drop);
                params.put("email", email);
                params.put("pdate", pdate);
                params.put("rdate", rdate);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


        startActivity(new Intent(Give_a_ride.this, Subjects.class));   //intent code to go on to next page
        finish();                                // pehle current class ka naam aaega jisme tum ho and baad me jis class me jaana hai
    }

    DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {   // month +1 cause of indexing issue for ex to get july we will write of june

            Pdate.setText(d+" / "+(m+1)+" / "+y);


            day=d;
            month=m+1;
            year=y;      //this code block will show the same date when we close the calendar




        }
    };

    DatePickerDialog.OnDateSetListener dates =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {   // month +1 cause of indexing issue for ex to get july we will write of june

            Rdate.setText(d+" / "+(m+1)+" / "+y);


            day=d;
            month=m+1;
            year=y;      //this code block will show the same date when we close the calendar




        }
    };

}

