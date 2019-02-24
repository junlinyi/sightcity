package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class RoomSelect extends Activity {
    Controller controller;
    MediaPlayer roomselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RoomSelect helper = new RoomSelect();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_select);

        controller = new Controller();

        roomselect = MediaPlayer.create(RoomSelect.this, R.raw.roomselect);
        roomselect.start();

        final String[][] ccnyRoomList = controller.getCCNYRooms();

        LinearLayout roomList = (LinearLayout) findViewById(R.id.roomList);
        int size = ccnyRoomList.length;

        int k=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <ccnyRoomList[i].length ; j++) {

                if(j==0){
                    final Button btn = new Button(this);
                    btn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        btn.setBackground(getResources().getDrawable(R.drawable.border_list));
                    }

                    // Access this id from AudioController?
                    btn.setId(k);
                    k++;

                    btn.setText(ccnyRoomList[i][++j]);

                    final int selectedI = i;
                    final int selectedJ=0;
                    btn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Bundle extras = getIntent().getExtras();
                        if (extras != null) {
                            String value = extras.getString("ancestor");
                            //The key argument here must match that used in the other activity

                            if(value.equals("startPoint")) {
                                roomselect.stop();

                                controller.setStartPoint(ccnyRoomList[selectedI][0]);
                                startActivity(new Intent(RoomSelect.this, MainMenu.class));
                                Toast.makeText(RoomSelect.this, "Button " + ccnyRoomList[selectedI][selectedJ] + " for start point clicked", Toast.LENGTH_SHORT).show();

                            } else if(value.equals("endPoint")){
                                roomselect.stop();

                                controller.setEndPoint(ccnyRoomList[selectedI][0]);
                                Toast.makeText(RoomSelect.this, "Button " + ccnyRoomList[selectedI][selectedJ] + " for end point clicked", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RoomSelect.this, ConfirmPlay.class));
                            }
                        }

                    }
                });

                roomList.addView(btn);

            }

            }
        }
    }

    public void dialogMessage(String title,String message){
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"OK", new 	 DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                alertDialog.cancel();

            }
        });
        alertDialog.show();
    }


}
