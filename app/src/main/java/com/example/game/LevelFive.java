package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
public class LevelFive extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayerView;
    Button bn;
    Button quiz;
    YouTubePlayer.OnInitializedListener on;
    YouTubePlayer.PlayerStateChangeListener p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        bn=(Button) findViewById(R.id.playvideo);
        quiz=(Button) findViewById(R.id.quiz);
        youTubePlayerView=(YouTubePlayerView) findViewById(R.id.youtubeplayerview);

        on=new YouTubePlayer.OnInitializedListener()
        {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("aFXQXPLYyXU");
               /* Handler handler;
                handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(LevelFive.this, LevelFiveNext.class);
                        startActivity(intent);
                    }
                }, 3000);*/
            }
                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                }
            };
            bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(PlayerConfig.API_KEY,on);
            }
        });
            quiz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LevelFive.this, LevelFiveNext.class);
                    startActivity(intent);
                }
            });
    }
    public void navigation(View view)
    {
        switch (view.getId()) {
            case R.id.home:
                startActivity(new Intent(LevelFive.this,LevelSelection.class));
                break;
            case R.id.next:
                startActivity(new Intent(LevelFive.this,LevelFiveNext.class));
                break;
        }
    }
}
