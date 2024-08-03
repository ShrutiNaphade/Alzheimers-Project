package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class LevelSeven extends Collection {
    Button submit;
    MediaPlayer fruit,person,place,prof;
    MediaPlayer correctchoice,wrongchoice;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_seven);
        submit=findViewById(R.id.submit);
        fruit=MediaPlayer.create(this,R.raw.pineapple);
        person=MediaPlayer.create(this,R.raw.narendramodi);
        place=MediaPlayer.create(this,R.raw.tajmahal);
        prof=MediaPlayer.create(this,R.raw.doctor);
        correctchoice=MediaPlayer.create(this,R.raw.correctlevel7);
        wrongchoice=MediaPlayer.create(this,R.raw.deeperror);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("level7",""+score);
                editor.apply();*/
                level7score = score;
                AlertDialog alert = new AlertDialog.Builder(LevelSeven.this).create();
                alert.setTitle("You Scored : ");
                alert.setMessage(" "+score);
                alert.setCancelMessage(null);
                alert.show();
            }
        });
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelSeven.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelSeven.this,LevelEight.class));
                break;
        }
    }
    public void playRec(View view)
    {
        switch(view.getId())
        {
            case R.id.fruitrec:
                fruit.start();
                break;
            case R.id.personrec:
                person.start();
                break;
            case R.id.placerec:
                place.start();
                break;
            case R.id.profrec:
                prof.start();
                break;
        }
    }
    public void answerCheck(View view)
    {
        switch(view.getId())
        {
            case R.id.fru2:
            case R.id.per1:
            case R.id.place3:
            case R.id.prof1:
                correctchoice.start();
                score++;
                findViewById(view.getId()).setEnabled(false);
                break;
            case R.id.fru1:
            case R.id.fru3:
            case R.id.fru4:
                findViewById(view.getId()).setEnabled(false);
                findViewById(R.id.fru2).setEnabled(false);
                wrongchoice.start();
                break;
            case R.id.per2:
            case R.id.per3:
            case R.id.per4:
                findViewById(view.getId()).setEnabled(false);
                findViewById(R.id.per1).setEnabled(false);
                wrongchoice.start();
                break;
            case R.id.place1:
            case R.id.place2:
            case R.id.place4:
                findViewById(view.getId()).setEnabled(false);
                findViewById(R.id.place3).setEnabled(false);
                wrongchoice.start();
                break;
            case R.id.prof2:
            case R.id.prof3:
            case R.id.prof4:
                findViewById(view.getId()).setEnabled(false);
                findViewById(R.id.prof1).setEnabled(false);
                wrongchoice.start();
                break;
        }
    }
}
