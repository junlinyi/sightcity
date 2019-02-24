package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends Activity {
    Button endPointButton;
    Button startPointButton;

    Controller controller;
    MediaPlayer mainmenu;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        //Toast.makeText(MainMenu.this, control.getDetail()+"", Toast.LENGTH_LONG).show();
        endPointButton = (Button) findViewById(R.id.endPoint);//Gives the end button a declaration and tags it to end Point
        startPointButton = (Button) findViewById(R.id.startPoint);//Gives the end button a declaration and tags it to start Point
        controller =  new Controller();
        Log.e("ERROR",controller.getDetail());
        Log.e("ERROR",controller.getMenuColor());
        Log.e("ERROR",controller.getUnit());
        Log.e("ERROR",controller.getMusic()+"");

        mainmenu = MediaPlayer.create(MainMenu.this,R.raw.mainmenu);
        mainmenu.start();

        //The Start Point Button onClick Event
        startPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Uses Lambda to create the new intent
                mainmenu.stop();

                Intent intent=new Intent(MainMenu.this, StartPoint.class);//choose the current place and destination for the content
                startActivity(intent);//executes the button intent
            }
        });

        //The End Point Button onClick Event
        endPointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Uses Lambda to create the new intent
                mainmenu.stop();

                Intent intent=new Intent(MainMenu.this, EndPoint.class);//choose the current place and destination for the ontent
                startActivity(intent);//executes the button intent
            }
        });


        displayMap();


    }

    public void mapSelect(View view){
        mainmenu.stop();

        this.view = view;
        startActivity(new Intent(MainMenu.this,MapSelect.class));


    }

    public void settings(View view){
        mainmenu.stop();

        this.view = view;
        startActivity(new Intent(MainMenu.this, Settings.class));

    }
    public  void displayMap(){
        String from = controller.getMapSelect();
        Toast.makeText(MainMenu.this,
                from, Toast.LENGTH_LONG).show();
        Toast.makeText(MainMenu.this,
                controller.getStartPoint().toString(), Toast.LENGTH_LONG).show();

        Toast.makeText(MainMenu.this,
                controller.getEndPoint().toString(), Toast.LENGTH_LONG).show();


    }

    public void playNav(View view){
        mainmenu.stop();

        if(controller.allSet())
            startActivity(new Intent(this,UnityPlayerActivity.class));

    }
}
