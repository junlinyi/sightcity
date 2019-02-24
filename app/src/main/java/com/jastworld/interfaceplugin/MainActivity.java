package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;

import java.util.HashMap;

public class MainActivity extends Activity {
    Button navButton;
    Button trainButton;

    Controller controller;
    Settings settings;
    MediaPlayer welcome ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navButton = (Button) findViewById(R.id.gamePlay);//Gives the button a declaration and tags it to nav_button
        trainButton=(Button) findViewById(R.id.training);

        welcome = MediaPlayer.create(MainActivity.this,R.raw.welcome);
        welcome.start();

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Uses Lambda to create the new intent
                welcome.stop();

                Intent intent=new Intent(MainActivity.this, MainMenu.class);;//choose the current place and destination for the ontent
                startActivity(intent);//executes the button intent
            }
        });

        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Uses Lambda to create the new intent
                Intent intent=new Intent(MainActivity.this, MainMenu.class);;//choose the current place and destination for the ontent
                startActivity(intent);//executes the button intent
            }
        });

    }
}
