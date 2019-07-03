package com.example.user.projectwork;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "volleyride";
    private static final String KEY_PICK = "keypick";
    private static final String KEY_DROPOFF = "keydropoff";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_PDATE = "keypdate";
    private static final String KEY_RDATE = "keyrdate";
    private static final String KEY_FIRSTNAME = "keyfirstname";
    private static final String KEY_LASTNAME = "keylastname";
    private static final String KEY_MOBILE = "keymobile";
    private static SharedPrefManager mInstance;
    private static Context ctx;

    private SharedPrefManager(Context context) {
        ctx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public void rideGive(Ride ride){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PICK, ride.getPick());
        editor.putString(KEY_DROPOFF, ride.getDrop());
        editor.putString(KEY_EMAIL, ride.getEmail());
        editor.putString(KEY_PDATE, ride.getPick_date());
        editor.putString(KEY_RDATE, ride.getReturn_date());
        editor.apply();
    }

    public void userView(Users user) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_FIRSTNAME, user.getFirstname());
        editor.putString(KEY_LASTNAME, user.getLastname());
        editor.putString(KEY_MOBILE, user.getMobile());
        editor.apply();
    }

    public Users getUser(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Users(
                sharedPreferences.getString(KEY_FIRSTNAME,null),
                sharedPreferences.getString(KEY_LASTNAME,null),
                sharedPreferences.getString(KEY_MOBILE,null)
        );
    }
}

