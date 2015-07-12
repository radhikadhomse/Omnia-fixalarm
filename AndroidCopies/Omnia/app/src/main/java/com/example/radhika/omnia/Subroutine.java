package com.example.radhika.omnia;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created  by Radhika on 7/11/2015.
 */

public class Subroutine implements Serializable {
    private final int ALARM = 0;
    private final int NEWS = 1;
    private final int MESSAGES = 2;
    private final int VIDEO = 3;
    private final int WEATHER = 4;
    private int hour;
    private int min;
    private ArrayList<Integer> tasks;
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private String name;
    public Subroutine(String n, int h, int m, ArrayList<Integer> taskList) {
        n = name;
        hour = h;
        min = m;
        tasks = taskList;
    }
    public void createAlarm() {

    }
    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return min;
    }
}
