package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.Random;
import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;
public class CustomLevel extends AppCompatActivity {
    DrawableView drawableView;
    DrawableViewConfig  config;
    Button color,erase,size1,size2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_level);
        color= (Button)findViewById(R.id.color) ;
        erase=(Button)findViewById(R.id.earse);
        size1=(Button)findViewById(R.id.size);
        size2=(Button)findViewById(R.id.size2);
        drawableView=(DrawableView)findViewById(R.id.paintView);
        config=new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true);
        config.setStrokeWidth(8f);
        config.setCanvasHeight(1580);
        config.setCanvasWidth(1920);
        drawableView.setConfig(config);

        size1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth()+10);

            }
        });
        size2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                config.setStrokeWidth(config.getStrokeWidth()-10);

            }
        });
        color.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Random random= new Random();
                config.setStrokeColor(Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256)));

            }
        });
        erase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawableView.clear();
            }
        });
    }
}
