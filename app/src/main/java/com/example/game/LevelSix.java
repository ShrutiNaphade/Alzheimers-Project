package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class LevelSix extends Collection {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_six);
        final Button b = (Button) findViewById(R.id.process);
        final RadioButton r2 = (RadioButton) findViewById(R.id.r2);
        final RadioButton r21 = (RadioButton) findViewById(R.id.r21);
        final RadioButton r32 = (RadioButton) findViewById(R.id.r32);
        final RadioButton r13 = (RadioButton) findViewById(R.id.r13);
        final RadioButton r34 = (RadioButton) findViewById(R.id.r34);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (r2.isChecked()) {
                    count++;

                    //  Toast.makeText(SecondActivity.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                }
                if (r21.isChecked()) {
                    count++;
                    //  Toast.makeText(SecondActivity.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                }
                if (r32.isChecked()) {
                    count++;
                    //  Toast.makeText(SecondActivity.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                }
                if (r13.isChecked()) {
                    count++;
                    //  Toast.makeText(SecondActivity.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                }
                if (r34.isChecked()) {
                    count++;
                    //  Toast.makeText(SecondActivity.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                }
                //Toast.makeText(LevelSix.this, String.valueOf(count), Toast.LENGTH_LONG).show();
                // r34.setEnabled(false);
                b.setEnabled(false);
                r2.setTextColor(Color.parseColor("#03AC13"));
                r21.setTextColor(Color.parseColor("#03AC13"));
                r32.setTextColor(Color.parseColor("#03AC13"));
                r13.setTextColor(Color.parseColor("#03AC13"));
                r34.setTextColor(Color.parseColor("#03AC13"));
                /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("level6",""+count);
                editor.apply();*/
                level6score = count;
                AlertDialog alert = new AlertDialog.Builder(LevelSix.this).create();
                alert.setTitle("You Scored : ");
                alert.setMessage(" "+count);
                alert.setCancelMessage(null);
                alert.show();
            }
        });
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelSix.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelSix.this,LevelSeven.class));
                break;
        }
    }
}
