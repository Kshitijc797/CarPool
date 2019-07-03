package com.example.user.projectwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RideDetails extends AppCompatActivity {

    //a list to store all the products
    List<AdminRide> rideList;

    //the recyclerview
    RecyclerView recyclerView;
    RideAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        rideList = new ArrayList<>();

        loadRide();
    }

    private void loadRide(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AdminURL.URL_RIDE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray users = new JSONArray(response);

                            for(int i=0; i<users.length();i++){
                                JSONObject userObject = users.getJSONObject(i);

                                String pick = userObject.getString("pickup");
                                String drop = userObject.getString("dropoff");
                                String email = userObject.getString("email");
                                String pdate = userObject.getString("pdate");
                                String rdate = userObject.getString("rdate");

                                AdminRide ride = new AdminRide(pick, drop, email, pdate, rdate);

                                rideList.add(ride);
                            }

                            adapter = new RideAdapter(RideDetails.this, rideList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RideDetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
