package com.example.user.projectwork;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class Bookride extends AppCompatActivity {
  //  DB_RECORD db;
    EditText calendar,pickup,drop,carid;
    Button confirm,btn2,btn3,btn4,btn5;
    int day,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookride);
        calendar=findViewById(R.id.editText);
        pickup=findViewById(R.id.editText5);
        drop=findViewById(R.id.editText6);
        carid=findViewById(R.id.editText7);
        confirm=findViewById(R.id.button);
    //    btn2=findViewById(R.id.button2);
    //    btn3=findViewById(R.id.button3);
    //    btn4=findViewById(R.id.button4);
     //   btn5=findViewById(R.id.button5);

      //  db= new DB_RECORD(this);

        getSupportActionBar().setTitle("Book Ride");

        calendar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Calendar ca = Calendar.getInstance();       // for current date

                day=ca.get(Calendar.DAY_OF_MONTH);
                month=ca.get(Calendar.MONTH);
                year=ca.get(Calendar.YEAR);

                new DatePickerDialog(Bookride.this,date,ca.get(Calendar.YEAR),ca.get(Calendar.MONTH),ca.get(Calendar.DAY_OF_MONTH)).show();   //if we want to use date picker dialog in android project we hav to call 5 parameters type constructor of date picker dialog class
                // parameters are 1. context type 2. On dateSetListener 3. integer type year 4. integer type month, 5.integer type day of month
            }
        }); // instead of null in above mentioned code we'll write date



    }

 //to use the fn of calendar

    DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {   // month +1 cause of indexing issue for ex to get july we will write of june

            calendar.setText(d+" / "+(m+1)+" / "+y);

            day=d;
            month=m+1;
            year=y;      //this code block will show the same date when we close the calendar




        }
    };
}
