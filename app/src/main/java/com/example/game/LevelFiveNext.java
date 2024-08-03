package com.example.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class LevelFiveNext extends Collection {
    int count;
    MediaPlayer tune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five_next);
        tune=MediaPlayer.create(this,R.raw.level5sound);
        tune.start();
        final Button b=(Button) findViewById(R.id.process);
        final RadioButton r2=(RadioButton) findViewById(R.id.r2);
        final RadioButton r21=(RadioButton) findViewById(R.id.r21);
        final RadioButton r32=(RadioButton) findViewById(R.id.r32);
        final RadioButton r13=(RadioButton) findViewById(R.id.r13);
        final RadioButton r34=(RadioButton) findViewById(R.id.r34);

        count=0;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tune.stop();
                if(r2.isChecked())
                {   count++;
                }
                if(r21.isChecked())
                {   count++;
                }
                if(r32.isChecked())
                {   count++;
                }
                if(r13.isChecked())
                {   count++;
                }
                if(r34.isChecked())
                {   count++;
               }
                //Toast.makeText(LevelFiveNext.this,String.valueOf(count),Toast.LENGTH_LONG).show();
                b.setEnabled(false);
                r2.setTextColor(Color.parseColor("#03AC13"));
                r21.setTextColor(Color.parseColor("#03AC13"));
                r32.setTextColor(Color.parseColor("#03AC13"));
                r13.setTextColor(Color.parseColor("#03AC13"));
                r34.setTextColor(Color.parseColor("#03AC13"));
               /* SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("level5",""+count);
                editor.apply();*/
               level5score = count;
                AlertDialog alert = new AlertDialog.Builder(LevelFiveNext.this).create();
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
                tune.stop();
                startActivity(new Intent(LevelFiveNext.this,LevelSelection.class));
                break;
            case R.id.next:
                tune.stop();
                startActivity(new Intent(LevelFiveNext.this,LevelSix.class));
                break;
        }
    }
}
