package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
public class LevelOne extends Collection {
    ImageView instrument,utensil;
    ImageView inst1,inst2,inst3,inst4,inst5;
    ImageView ut1,ut2,ut3,ut4,ut5;
    int instruscore,utensilscore;
    MediaPlayer wrong;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one);
        wrong=MediaPlayer.create(this,R.raw.wrong);
        instruscore=0;utensilscore=0;
        b=findViewById(R.id.process);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totscore=(instruscore+utensilscore);
                int finalscore=totscore/2;
                level1score = finalscore;
                Toast.makeText(LevelOne.this,"Score is "+totscore,Toast.LENGTH_SHORT).show();
            }
        });
        instrument=(ImageView) findViewById(R.id.instrument);
        utensil=(ImageView) findViewById(R.id.utensil);

        inst1=(ImageView) findViewById(R.id.inst1);
        inst2=(ImageView) findViewById(R.id.inst2);
        inst3=(ImageView) findViewById(R.id.inst3);
        inst4=(ImageView) findViewById(R.id.inst4);
        inst5=(ImageView) findViewById(R.id.inst5);

        ut1=(ImageView) findViewById(R.id.ut1);
        ut2=(ImageView) findViewById(R.id.ut2);
        ut3=(ImageView) findViewById(R.id.ut3);
        ut4=(ImageView) findViewById(R.id.ut4);
        ut5=(ImageView) findViewById(R.id.ut5);

        instrument.setOnDragListener(new ChoiceDragListener());
        utensil.setOnDragListener(new ChoiceDragListener());
        //iv1.setOnDragListener(new ChoiceDragListener());
        inst1.setOnTouchListener(new ChoiceTouchListener());
        inst2.setOnTouchListener(new ChoiceTouchListener());
        inst3.setOnTouchListener(new ChoiceTouchListener());
        inst4.setOnTouchListener(new ChoiceTouchListener());
        inst5.setOnTouchListener(new ChoiceTouchListener());

        ut1.setOnTouchListener(new ChoiceTouchListener());
        ut2.setOnTouchListener(new ChoiceTouchListener());
        ut3.setOnTouchListener(new ChoiceTouchListener());
        ut4.setOnTouchListener(new ChoiceTouchListener());
        ut5.setOnTouchListener(new ChoiceTouchListener());
        //iv2.setOnDragListener(new ChoiceDragListener());*/
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelOne.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelOne.this,LevelTwo.class));
                break;
        }
    }
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN && ((ImageView) view).getDrawable() != null) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
            //return false;
        }
    }
    private class ChoiceDragListener implements View.OnDragListener
    {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            switch(dragEvent.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:
                    ImageView v =(ImageView) dragEvent.getLocalState();//the source image
                    if((ImageView)view == (ImageView)findViewById(R.id.instrument))
                    {
                        if(((ImageView)v) == (ImageView)findViewById(R.id.inst1))
                        {
                            instruscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.inst2))
                        {
                            instruscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.inst3))
                        {
                            instruscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.inst4))
                        {
                            instruscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.inst5))
                        {
                            instruscore++;
                        }
                        else
                        {
                            wrong.start();
                        }
                    }
                    if((ImageView)view == (ImageView)findViewById(R.id.utensil))

                    {
                        if(((ImageView)v) == (ImageView)findViewById(R.id.ut1))
                        {
                            utensilscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.ut2))
                        {
                            utensilscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.ut3))
                        {
                            utensilscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.ut4))
                        {
                            utensilscore++;
                        }
                        else if(((ImageView)v) == (ImageView)findViewById(R.id.ut5))
                        {
                            utensilscore++;
                        }
                        else
                        {
                            wrong.start();
                        }
                    }
                    ((ImageView)view).setImageDrawable(getResources().getDrawable(R.drawable.basket));
                    ((ImageView)v).setImageDrawable(null);//replace the soource by empty
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
            }
            return true;
        }
    }

}
