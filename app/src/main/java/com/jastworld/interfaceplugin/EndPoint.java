package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class EndPoint extends Activity {
    Controller controller;
    MediaPlayer endpoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        controller= new Controller();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_point);
        Toast.makeText(EndPoint.this,
                controller.getStartPoint(), Toast.LENGTH_SHORT).show();

        endpoint = MediaPlayer.create(EndPoint.this,R.raw.endpoint);
        endpoint.start();
    }


    public void nearBy(View view){
        endpoint.stop();

        Intent i = new Intent(getApplicationContext(), FloorSelect.class);

        i.putExtra("ancestor","endPoint");
        startActivity(i);
        //startActivity(new Intent(EndPoint.this,FloorSelect.class));

    }

    public void roomSelect(View view){
        endpoint.stop();

        Intent i = new Intent(getApplicationContext(), FloorSelect.class);
        i.putExtra("ancestor","endPoint");
        startActivity(i);
    }

}
