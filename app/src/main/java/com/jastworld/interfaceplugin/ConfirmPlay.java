package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ConfirmPlay extends Activity {
    Controller controller;
    MediaPlayer confirmplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_play);
        controller= new Controller();

        confirmplay = MediaPlayer.create(ConfirmPlay.this,R.raw.confirmplay);
        confirmplay.start();
    }


    public void startGame(View view) {
        confirmplay.stop();
        Intent i = new Intent(this,UnityPlayerActivity.class);
        startActivity(i);

    }

    public void goBack(View view) {
        confirmplay.stop();
        Intent i = new Intent(this, MainMenu.class);
        startActivity(i);

    }

}
