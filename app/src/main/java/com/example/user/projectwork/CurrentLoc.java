package com.example.user.projectwork;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class CurrentLoc extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, ActivityCompat.OnRequestPermissionsResultCallback {


    Button locationgmaps, sharelocation;
    TextView tvAddress,tvEmpty;

    RelativeLayout rlPick;

    private Location mLastLocation;

    double latitude;
    double longitude;

    LocationHelper locationHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_loc);

        getSupportActionBar().setTitle("Current Location");
        locationHelper=new LocationHelper(this);
        locationHelper.checkpermission();

        locationgmaps = findViewById(R.id.gmaps);
        sharelocation = findViewById(R.id.share);
        rlPick = findViewById(R.id.rlPickLocation);

        tvAddress =findViewById(R.id.tvAddress);
        tvEmpty =findViewById(R.id.tvEmpty);

        rlPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mLastLocation=locationHelper.getLocation();

                if (mLastLocation != null) {
                    latitude = mLastLocation.getLatitude();
                    longitude = mLastLocation.getLongitude();
                    getAddress();

                } else {



                    showToast("Couldn't get the location. Make sure location is enabled on the device");
                }
            }
        });



        sharelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String sharingloc = tvAddress.getText().toString();
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND_MULTIPLE);
                shareintent.putExtra(Intent.EXTRA_TEXT,"My Current Location is:   "+sharingloc);
                shareintent.setType("text/plain");
                startActivity(shareintent);
            }
        });

        locationgmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double latitude = 28.5354;
                double longitude = 77.2639;

                String label = "Current Location";

                String uriBegin = "geo:" + latitude + "," + longitude;

                String query = latitude + "," + longitude + "(" + label + ")";

                String encodedQuery = Uri.encode(query);

                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";

                Uri uri = Uri.parse(uriString);

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                startActivity(intent);


            }
        });

        // check availability of play services
        if (locationHelper.checkPlayServices()) {

            // Building the GoogleApi client
            locationHelper.buildGoogleApiClient();
        }

    }


    public void getAddress()
    {
        Address locationAddress;

        locationAddress=locationHelper.getAddress(latitude,longitude);

        if(locationAddress!=null)
        {

            String address = locationAddress.getAddressLine(0);
            String address1 = locationAddress.getAddressLine(1);
            String city = locationAddress.getLocality();
            String state = locationAddress.getAdminArea();
            String country = locationAddress.getCountryName();
            String postalCode = locationAddress.getPostalCode();


            String currentLocation;

            if(!TextUtils.isEmpty(address))
            {
                currentLocation=address;

                if (!TextUtils.isEmpty(address1))
                    currentLocation+="\n"+address1;

                if (!TextUtils.isEmpty(city))
                {
                    currentLocation+="\n"+city;

                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation+=" - "+postalCode;
                }
                else
                {
                    if (!TextUtils.isEmpty(postalCode))
                        currentLocation+="\n"+postalCode;
                }

                if (!TextUtils.isEmpty(state))
                    currentLocation+="\n"+state;

                if (!TextUtils.isEmpty(country))
                    currentLocation+="\n"+country;

                tvEmpty.setVisibility(View.GONE);
                tvAddress.setText(currentLocation);
                tvAddress.setVisibility(View.VISIBLE);




            }

        }
        else
            showToast("Something went wrong");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        locationHelper.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    protected void onResume() {
        super.onResume();
        locationHelper.checkPlayServices();
    }

    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i("Connection failed:", " ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location
        mLastLocation=locationHelper.getLocation();
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        locationHelper.connectApiClient();
    }


    // Permission check functions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // redirects to utils
        locationHelper.onRequestPermissionsResult(requestCode,permissions,grantResults);

    }

    public void showToast(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }



}
