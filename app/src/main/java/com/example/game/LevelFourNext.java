package com.example.game;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
public class LevelFourNext extends Collection{
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four_next);
        final SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        final String value = sharedPreferences.getString("value", "");
        final EditText e = (EditText) findViewById(R.id.e1);
        final Button b = (Button) findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((e.getText().toString()).equals(value)) {
                    //Toast.makeText(LevelFourNext.this, "Correct!Good memory strength :)", Toast.LENGTH_LONG).show();
                    AlertDialog alert = new AlertDialog.Builder(LevelFourNext.this).create();
                    alert.setTitle("Good !");
                    alert.setMessage("Keep going");
                    alert.setCancelMessage(null);
                    alert.show();
                    score = 2;
                }
                else {
                    //Toast.makeText(LevelFourNext.this, "Opps!Wrong number", Toast.LENGTH_LONG).show();
                    AlertDialog alert = new AlertDialog.Builder(LevelFourNext.this).create();
                    alert.setTitle("OOPS!");
                    alert.setMessage("Wrong number");
                    alert.setCancelMessage(null);
                    alert.show();
                    score = 0;
                }
                level4score = score;
                /*SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("level4",""+score);
                editor.apply();*/
            }
        });
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelFourNext.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelFourNext.this,LevelFive.class));
                break;
        }
    }
}