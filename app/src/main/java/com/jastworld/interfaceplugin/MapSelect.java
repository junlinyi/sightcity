package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MapSelect extends Activity {
    Controller controller;
    MediaPlayer mapselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_select);

        controller = new Controller();

        mapselect = MediaPlayer.create(MapSelect.this, R.raw.mapselect);
        mapselect.start();
    }

    public void sfHotel(View view){
        mapselect.stop();

        controller.setMapSelect("sanFrancisco");
        startActivity(new Intent(this,MainMenu.class));


    }
    public void ccny(View view){
        mapselect.stop();

        controller.setMapSelect("cityCollegeOfNewYork");
        startActivity(new Intent(this,MainMenu.class));

    }
    public void bmccNY(View view){
        mapselect.stop();

        controller.setMapSelect("bmccNY");
        startActivity(new Intent(this,MainMenu.class));
    }
}
