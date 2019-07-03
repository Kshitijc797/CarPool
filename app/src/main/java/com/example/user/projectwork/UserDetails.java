package com.example.user.projectwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
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

public class UserDetails extends AppCompatActivity {

    //a list to store all the products
    List<AdminUser> userList;

    //the recyclerview
    RecyclerView recyclerView;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        userList = new ArrayList<>();

        loadUser();
    }
    private void loadUser(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, AdminURL.URL_USER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray users = new JSONArray(response);

                            for(int i=0; i<users.length();i++){
                                JSONObject userObject = users.getJSONObject(i);

                                String firstname = userObject.getString("firstname");
                                String lastname = userObject.getString("lastname");
                                String email = userObject.getString("email");
                                String username = userObject.getString("username");
                                String mobile = userObject.getString("mobile");

                                AdminUser user = new AdminUser(firstname, lastname, email, username, mobile);

                                userList.add(user);
                            }

                            adapter = new UserAdapter(UserDetails.this, userList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserDetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
