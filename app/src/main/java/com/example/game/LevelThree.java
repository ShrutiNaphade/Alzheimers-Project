package com.example.game;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class LevelThree extends Collection {
    int score=0;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_three);
        final MediaPlayer right=MediaPlayer.create(this,R.raw.correct);
        final MediaPlayer chuk = MediaPlayer.create(this,R.raw.wr);
        b1= findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        b3= findViewById(R.id.b3);
        b4= findViewById(R.id.b4);
        b5= findViewById(R.id.b5);
        b6= findViewById(R.id.b6);
        b7= findViewById(R.id.b7);
        b8= findViewById(R.id.b8);
        b9= findViewById(R.id.b9);
        b10= findViewById(R.id.b10);
        b11= findViewById(R.id.b11);
        submit= findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int finalscore=score/2;
               level3score = finalscore;
                AlertDialog alert = new AlertDialog.Builder(LevelThree.this).create();
                alert.setTitle("You Scored : ");
                alert.setMessage(" "+score);
                alert.setCancelMessage(null);
                alert.show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b1.setEnabled(false);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b2.setEnabled(false);
               /* chuk.start();
                Toast.makeText(levelone.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                b2.setEnabled(false);*/

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuk.start();
                // Toast.makeText(LevelThree.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                b3.setEnabled(false);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b4.setEnabled(false);

            }
        });


        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b5.setEnabled(false);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b6.setEnabled(false);

            }
        });


        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b7.setEnabled(false);

            }
        });


        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b8.setEnabled(false);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score++;
                right.start();
                //Toast.makeText(LevelThree.this,"score is:"+score,Toast.LENGTH_SHORT).show();
                b9.setEnabled(false);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuk.start();
                //Toast.makeText(LevelThree.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                b10.setEnabled(false);

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chuk.start();
                //Toast.makeText(LevelThree.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
                b11.setEnabled(false);

            }
        });

    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelThree.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelThree.this,LevelFour.class));
                break;
        }
    }
}
