package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class StartPoint extends Activity {
    Controller controller;
    MediaPlayer startpoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_point);
        controller = new Controller();

        startpoint = MediaPlayer.create(StartPoint.this,R.raw.startpoint);
        startpoint.start();
    }

    public void roomSelect(View view){
        startpoint.stop();

        Intent i = new Intent(getApplicationContext(), FloorSelect.class);

        i.putExtra("ancestor","startPoint");
        startActivity(i);
    }


    public void entrance(View view){
        startpoint.stop();
        controller.setStartPoint("exit1");
        // Old Code
        // startActivity(new Intent(this,MainMenu.class));
        // New Code
        startActivity(new Intent(this, EndPoint.class));
    }


}
