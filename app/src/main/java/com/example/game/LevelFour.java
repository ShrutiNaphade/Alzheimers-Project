package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.TextView;
import java.util.*;
public class LevelFour extends AppCompatActivity {
    MediaPlayer m;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
          m=MediaPlayer.create(this,R.raw.letsplay);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four);

          Random rnd = new Random();
          int number = rnd.nextInt(999999);
          Handler handler1;
          handler1=new Handler();
          m.start();
          handler1.postDelayed(new Runnable() {
              @Override
              public void run() {
                  m.stop();
              }
          }, 5000);

          TextView x=(TextView) findViewById(R.id.no);
          x.setText(String.format("%06d", number));
          String value=x.getText().toString();
          SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
          SharedPreferences.Editor editor = sharedPref.edit();
          editor.putString("value", value);
          editor.apply();
          Handler handler;
          handler = new Handler();
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {

                  Intent intent = new Intent(LevelFour.this, LevelFourNext.class);
                  startActivity(intent);
              }
          }, 6000);
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                m.stop();
                startActivity(new Intent(LevelFour.this,LevelSelection.class));
                break;
            case R.id.next:
                m.stop();
                startActivity(new Intent(LevelFour.this,LevelFourNext.class));
                break;
        }
    }
}
