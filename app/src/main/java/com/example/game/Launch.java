package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ImageView imageView = findViewById(R.id.nav_header_img);
        Glide.with(this).load(R.drawable.lauch).into(imageView);
        ImageView imageView2= findViewById(R.id.name);
        Glide.with(this).load(R.drawable.amy).into(imageView2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Launch.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2800);
    }
}
