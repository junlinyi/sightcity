package com.jastworld.interfaceplugin;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class Settings extends Activity {

    Controller controller;
    MediaPlayer settings;
    Button saveButton;

    String detailChoice;
    String unitChoice;
    String colorChoice;

    boolean music;
    boolean voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        controller = new Controller();
        //boolean ask = controller.getMenuColor();
        saveButton = (Button) findViewById(R.id.settingSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Uses Lambda to create the new intent
                settings.stop();

                Log.e("ASDF", colorChoice);
                Log.e("ASDF", detailChoice);
                Log.e("ASDF", unitChoice);
                Log.e("ASDF", music+"");
                controller.setMenuColor(colorChoice);
                controller.setDetail(detailChoice);
                controller.setUnit(unitChoice);
                controller.setMusic(music);
                controller.setVoiceOver(voice);
                Intent intent=new Intent(Settings.this, MainMenu.class);//choose the current place and destination for the ontent
                startActivity(intent);//executes the button intent
            }
        });

        settings = MediaPlayer.create(Settings.this, R.raw.settings);
        settings.start();


        /*----------------------------------------------------------------------------/
        /Music Select Checkbox controller
        /-----------------------------------------------------------------------------*/
        CheckBox musiclevel = (CheckBox)findViewById(R.id.musicChoice);
        musiclevel.setChecked(true);
        music=true;
        if(musiclevel.isChecked()){
            music = true;
        }
        else
            music = false;

         /*----------------------------------------------------------------------------/
        /Voice Over Checkbox controller
        /-----------------------------------------------------------------------------*/
        CheckBox voiceOverCheck = (CheckBox)findViewById(R.id.voiceOverChoice);
        voiceOverCheck.setChecked(true);
        voice=true;
        if(voiceOverCheck.isChecked()){
            voice = true;
        }
        else
            voice = false;

        /*----------------------------------------------------------------------------/
        /Color Select Checkbox controller
        /-----------------------------------------------------------------------------*/
        final CheckBox defaultColor = (CheckBox) findViewById(R.id.defaultColor);
        final CheckBox brightColor = (CheckBox) findViewById(R.id.brightColor);
        defaultColor.setChecked(true);
        colorChoice = "default";
        //This is the functions that select the default color or bright color
        defaultColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(Settings.this, "Default Color Selected", Toast.LENGTH_LONG).show();

                brightColor.setChecked(false);
                colorChoice = "default";
                defaultColor.setChecked(b);
                //Toast.makeText(Settings.this, "Default Color DeSelected", Toast.LENGTH_LONG).show();

            }
        });
        brightColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(Settings.this, "Bright Color Selected", Toast.LENGTH_LONG).show();
                defaultColor.setChecked(false);

                brightColor.setChecked(b);
                colorChoice = "bright";
            }
        });


        /*----------------------------------------------------------------------------/
        /Unit Select Checkbox controller
        /-----------------------------------------------------------------------------*/
        final CheckBox metersUnit = (CheckBox) findViewById(R.id.metersUnit);
        final CheckBox feetsUnit = (CheckBox) findViewById(R.id.feetsUnit);
        //This is the functions that select the default color or bright color
        feetsUnit.setChecked(true);
        unitChoice = "feets";

        metersUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                feetsUnit.setChecked(false);
                unitChoice = "meters";
                metersUnit.setChecked(b);

            }
        });
        feetsUnit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(Settings.this, "Bright Color Selected", Toast.LENGTH_LONG).show();
                metersUnit.setChecked(false);
                feetsUnit.setChecked(b);
                unitChoice = "feets";
            }
        });



        /*----------------------------------------------------------------------------/
        /Detail Select Checkbox controller
        /-----------------------------------------------------------------------------*/
        final CheckBox lowDetail = (CheckBox) findViewById(R.id.lowDetail);
        final CheckBox highDetail = (CheckBox) findViewById(R.id.highDetail);
        highDetail.setChecked(true);
        detailChoice = "high";
        lowDetail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                highDetail.setChecked(false);
                //      detailChoice[0] = false;
                detailChoice = "low";
                lowDetail.setChecked(b);
                //Toast.makeText(Settings.this, "Default Color DeSelected", Toast.LENGTH_LONG).show();

            }
        });
        highDetail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //Toast.makeText(Settings.this, "Bright Color Selected", Toast.LENGTH_LONG).show();
                lowDetail.setChecked(false);
                detailChoice = "high";
                highDetail.setChecked(b);
                //        detailChoice[0] = true;
                //    Toast.makeText(Settings.this, "Bright Color DeSelected", Toast.LENGTH_LONG).show();
            }
        });


    }

}
