package com.jastworld.interfaceplugin;

import android.util.Log;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Tayo on 7/27/2016.
 */
public class Controller {
    public static String mapSelect;
    public static String floorSelect;
    public static String startPoint=null;
    public static String endPoint=null;
    public String TAG = "ERROR";
    public static boolean isMusic;
    public static boolean isVoice;
    public static String isDetail;
    public static String isColor;
    public static String isUnit;

    public String[][] getCCNYRooms(){

        String [][] cityCollegeOfNewYork=
                {       {"exit1","Exit One"}, {"exit2", "Exit Two"},{"exit3","Exit Three"}, {"exit4","Exit Four"},
                        {"elevator","Elevator"}, {"escalator","Escalator"}, {"staira","Stair A"}, {"stairb","Stair B"},
                        {"conference", "Conference"}, {"waiting","Waiting Room"}, {"office","Office"}, {"lecture","Lecture Theater"},
                        {"bathroom", "Bathroom"}, {"utility", "Utility Room"}, {"lockerroom","Locker Room"},{"medical", "Medical Room"}
                };

        return cityCollegeOfNewYork;
    
    }

    public void setMapSelect(String mapChoice){
        mapSelect=mapChoice;
    }


    public String getMapSelect(){
        if(mapSelect!=null){
            //return mapSelect;
            return "cityCollegeOfNewYork";
        }else
        {
            //String error= "No Map Selected";
            //Log.e(TAG, error);
            return "cityCollegeOfNewYork";

        }
    }

    public void setFloorSelect(String floorChoice){
        floorSelect=floorChoice;
    }

    public String getFloorSelect(){
        if(floorSelect!=null){
            return floorSelect;
        }else
        {
            String error= "No Floor Selected";
            Log.e(TAG, error);
            return error;
        }

    }
    public void setStartPoint(String startChoice) {

        startPoint=startChoice;
    }

    public String getStartPoint(){
        if(startPoint!=null){
            return startPoint;
        }else
        {
            String error= "No Start Point Selected";
            Log.e(TAG, error);
            return error;
        }

    }

    public void setEndPoint(String endChoice){
        endPoint=endChoice;
    }
    public String getEndPoint(){
        if(endPoint!=null){
            return endPoint;
        }else
        {
            String error= "No End Point Selected";
            Log.e(TAG, error);
            return error;

        }

    }

    public void setMusic(boolean setMusic) { isMusic = setMusic;}
    public boolean getMusic(){
        if(isMusic)
            return true;
        else
            return false;
    }

    public void setVoiceOver(boolean setVoice){
        isVoice = setVoice;
    }
    public boolean getVoiceOver(){
        if(isVoice)
            return true;
        else
            return false;
    }


    public void setMenuColor(String setColor){
        isColor = setColor;

    }
    public String getMenuColor(){
        if(isColor!=null) {
            return isColor;
        }else
            return "No color selected yet";
    }


    public void setUnit(String setUnit){
        isUnit = setUnit;
    }

    public String getUnit(){
        if(isUnit!=null){
            return isUnit;}else
        {
            return "No Unit selected";
        }
    }

    public void setDetail(String setDetail) {
        isDetail = setDetail;
    }
    public String getDetail(){
        if(isDetail!=null)
            return isDetail;
        else
            return "No level of detail selected";
    }



    public boolean allSet(){
        if(startPoint!=null&&endPoint!=null)
            return true;
        return false;
    }

}
