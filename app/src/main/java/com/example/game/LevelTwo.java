package com.example.game;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
public class LevelTwo extends Collection {
    private static Button date, time;
    private static TextView set_date, set_time;
    private static final int Date_id = 0;
    private static final int Time_id = 1;
    //MediaPlayer correct,wrong;
    int score=0;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_two);
        check = findViewById(R.id.button);
        date = (Button) findViewById(R.id.selectdate);
        time = (Button) findViewById(R.id.selecttime);
        set_date = (TextView) findViewById(R.id.set_date);
        set_time = (TextView) findViewById(R.id.set_time);
        //correct=MediaPlayer.create(this,R.raw.applause);
        //wrong=MediaPlayer.create(this,R.raw.wrong);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level2score=score;
                AlertDialog alert = new AlertDialog.Builder(LevelTwo.this).create();
                alert.setTitle("You Scored : ");
                alert.setMessage(" "+score);
                alert.setCancelMessage(null);
                alert.show();
            }
        });
        date.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show Date dialog
                showDialog(Date_id);
            }
        });
        time.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Show time dialog
                showDialog(Time_id);
            }
        });
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelTwo.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelTwo.this,LevelThree.class));
                break;
        }
    }
    protected Dialog onCreateDialog(int id)
    {// Get the calander
        Calendar c = Calendar.getInstance();
        // From calander get the year, month, day, hour, minute
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        switch (id)
        {
            case Date_id:
                // Open the datepicker dialog
                return new DatePickerDialog(LevelTwo.this, date_listener, year,month, day);
            case Time_id:
                // Open the timepicker dialog
                return new TimePickerDialog(LevelTwo.this, time_listener, hour,minute, false);

        }
        return null;
    }
    // Date picker dialog
    DatePickerDialog.OnDateSetListener date_listener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            // store the data in one string and set it to text
            month=month+1;
            String date1 = String.valueOf(day) + "/" + String.valueOf(month)
                    + "/" + String.valueOf(year);
            //String part1;
            if(date1.equals("3/4/2020"))
            {
                Toast.makeText(LevelTwo.this,"Correct date",Toast.LENGTH_SHORT).show();
                score++;
                //correct.start();
                //part1="1";
            }
            else
            {
                Toast.makeText(LevelTwo.this,"Wrong date",Toast.LENGTH_SHORT).show();
                //wrong.start();
              //  part1="0";
            }
            set_date.setText("You selected "+date1);
            /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("level2part1", ""+part1);
            editor.apply();*/
        }
    };
    TimePickerDialog.OnTimeSetListener time_listener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            // store the data in one string and set it to text
            String time1 = String.valueOf(hour) + ":" + String.valueOf(minute);
            String part2;
            if(time1.equals("13:15"))
            {
                Toast.makeText(LevelTwo.this,"Correct time",Toast.LENGTH_SHORT).show();
                //correct.start();
                score++;
                part2="1";
            }
            else
            {
                Toast.makeText(LevelTwo.this,"Incorrect time",Toast.LENGTH_SHORT).show();
                //wrong.start();
                part2="0";
            }
            set_time.setText("You Selected " +time1);
            /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("level2part2", ""+part2);
            editor.apply();*/
        }
    };

}
