package com.example.user.projectwork;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {


    EditText ed1,ed2;

    TextView numberofattempts;
    Button b1,b2 , showpass;
    private boolean showState = false;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        b1 = (Button)findViewById(R.id.login);
        showpass = (Button)findViewById(R.id.show);
        ed1 = (EditText)findViewById(R.id.userid);
        ed2 = (EditText)findViewById(R.id.password);
        showpass.setOnClickListener(new showOrHidePassword());

        getSupportActionBar().setTitle("ADMIN AUTH");

        b2 = (Button)findViewById(R.id.cancel);
        numberofattempts = (TextView)findViewById(R.id.numberofattempts);
        numberofattempts.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("cardoor") &&
                        ed2.getText().toString().equals("auth")) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(AdminLogin.this, DashBoard.class));
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),
                            "WRONG CREDENTIALS TRY AGAIN",Toast.LENGTH_SHORT).show();

                    numberofattempts.setVisibility(View.VISIBLE);
                    numberofattempts.setBackgroundColor(Color.RED);
                    counter--;
                    numberofattempts.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"You failed to authenticate yourself,TRY LATER",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class showOrHidePassword implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if (showState == false) {
                ed2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                showpass.setText("HIDE");
                showState = true;

            } else {

                ed2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                showpass.setText("SHOW");
                showState = false;
            }
        }
    }
}