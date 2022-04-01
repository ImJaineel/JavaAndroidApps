package com.example.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private Button button;
    private MediaPlayer mediaPlayer;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);
        button = findViewById(R.id.button);
        mediaPlayer = MediaPlayer.create(this,R.raw.music);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    button.setText("PLAY");
                }
                else {
                    mediaPlayer.start();
                    button.setText("PAUSE");
                }
                playCycle();
            }
        });

        mediaPlayer.setOnPreparedListener(mp ->  {
            mp.start();
            playCycle();
            seekBar.setMax(mediaPlayer.getDuration());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    if (b){
                        mp.seekTo(i);
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        });
    }

    public void playCycle(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if(mediaPlayer.isPlaying())
        {
            runnable =new Runnable()
            {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable, 100);

        }
    }
}