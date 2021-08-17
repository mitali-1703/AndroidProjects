package com.example.android.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    TimePicker timePicker;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datepicker);
        timePicker = findViewById(R.id.timepicker);
        textView1 = findViewById(R.id.t1);
        textView2 = findViewById(R.id.t2);

        //For DatePicker---->
        Calendar calendar = Calendar.getInstance();

        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int exactMonth = monthOfYear + 1;
                textView1.setText("You selected: " + dayOfMonth+"-" + exactMonth + "-"+year);
            }
        });


        //For TimePicker---->
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                textView2.setText("Hour: "+hourOfDay+"\nMinutes: "+minute);
            }
        });
    }
}