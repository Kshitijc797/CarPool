package com.example.user.projectwork;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Feedback extends AppCompatActivity
{
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Feedback");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Feedback.this);
                dialog.setContentView(R.layout.callservice);
                ImageButton i1 =   dialog.findViewById(R.id.imageButton);
                ImageButton i2 =   dialog.findViewById(R.id.imageButton2);

                i1.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:9560477909"));
                        if (ActivityCompat.checkSelfPermission(Feedback.this, Manifest.permission.CALL_PHONE)
                                != PackageManager.PERMISSION_GRANTED)
                        {
                            ActivityCompat.requestPermissions(Feedback.this,new String[]{Manifest.permission.CALL_PHONE},0);
                            return;
                        }
                        startActivity(intent);
                    }
                });
                dialog.show();
                i2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:9560477909"));
                        startActivity(intent);

                    }
                });
                dialog.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Feedback.this);
                dialog.setContentView(R.layout.smsservice);
                final EditText ed = dialog.findViewById(R.id.editText);
                Button btn3 =   dialog.findViewById(R.id.button3);
                if(ActivityCompat.checkSelfPermission(Feedback.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(Feedback.this, new String[]{Manifest.permission.SEND_SMS},0);

                    return;
                }
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        String query =  ed.getText().toString();
                        String number = "9560477909";
                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(number,null,query,null,null);
                        Toast.makeText(Feedback.this, "SMS SENT...", Toast.LENGTH_SHORT).show();
                        ed.setText("");
                    }
                });
                dialog.show();
            }
        });
    }



}

