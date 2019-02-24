package com.jastworld.interfaceplugin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClosePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView time = (TextView)findViewById(R.id.time);
        TextView collisions = (TextView)findViewById(R.id.collisions);

        Bundle extras = getIntent().getExtras();
        String timePassed="";
        String collisionPassed="";
        if (extras != null) {
            timePassed = extras.getString("time");
            collisionPassed=extras.getString("collision");
            //The key argument here must match that used in the other activity
        }

        time.setText("Time: "+timePassed);
        collisions.setText("Collision: "+collisionPassed);


        setContentView(R.layout.activity_close_page);
    }

    public void quit(View view){

    }

    public void restartDifferentGame(View view){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void restartSameGame(){
        startActivity(new Intent(this,UnityPlayerActivity.class));
    }
}
