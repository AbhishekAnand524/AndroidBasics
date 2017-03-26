package com22yards.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final MediaPlayer mediaPlayer=MediaPlayer.create(this, R.raw.abcd);
        mediaPlayer.start();
        Thread thread = new Thread(){
          public void run(){
              try{
                sleep(3000);
              }
              catch (InterruptedException e){

              }
              finally {
                  Intent intent = new Intent(SplashScreen.this, HomeList.class);
                  startActivity(intent);
                  mediaPlayer.release();
                  finish();
              }
          }
        };
        thread.start();

    }
}
