package com.example.user.projectwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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

public class Ride_list extends AppCompatActivity {
    //a list to store all the products
    List<Riders> ridersList;

    //the recyclerview
    RecyclerView recyclerView;
    RidersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        ridersList = new ArrayList<>();

        loadUser();
    }
    private void loadUser(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLs.URL_FIND,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray users = new JSONArray(response);

                            for(int i=0; i<users.length();i++){
                                JSONObject userObject = users.getJSONObject(i);

                                String firstname = userObject.getString("firstname");
                                String lastname = userObject.getString("lastname");
                                String mobile = userObject.getString("mobile");

                                Riders user = new Riders(firstname, lastname, mobile);

                                ridersList.add(user);
                            }

                            adapter = new RidersAdapter(Ride_list.this, ridersList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Ride_list.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
