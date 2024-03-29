package com.example.radhika.omnia;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

//package com.example.loaner.omnia_3;
import android.app.ActionBar;
import android.app.Activity;
//import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by loaner on 6/30/15.
 */
//public class Display extends ActionBarActivity {
//    @Override
//    protected void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.display);
//        String username = getIntent().getStringExtra("Username");
//        TextView tv = (TextView)findViewById(R.id.TVusername);
//    }
//}

public class Home extends ActionBarActivity {
    public static String user_name = "";
    public static String zipcd = "20148";
    // public static String current_weather = "weather2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String activity_From = getIntent().getStringExtra("ActivityFrom");
        if (activity_From != null && activity_From.toString().equals("Login_screen"))
        {
            String username = getIntent().getStringExtra("Username");
            user_name = username;
        }
        if(activity_From != null && activity_From.toString().equals("SettingsActivity"))
        {
            String weather = getIntent().getStringExtra("Weather");
            TextView tv2 = (TextView) findViewById(R.id.weather);
            tv2.setText(weather);
        }
        TextView tv = (TextView) findViewById(R.id.TVusername);
        tv.setText(tv.getText() + " " + user_name + ".");
        TextView dt = (TextView) findViewById(R.id.today_is);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat getDate = new SimpleDateFormat("dd");
        int date = Integer.parseInt(getDate.format(c.getTime()));
        String ordinal = "";
        switch (date % 10) {
            case 1:
                ordinal = "st";
                break;
            case 2:
                ordinal = "nd";
                break;
            case 3:
                ordinal = "rd";
                break;
            default:
                ordinal = "th";
                break;
        }
        SimpleDateFormat df = new SimpleDateFormat("E, MMM d");
        String formattedDate = df.format(c.getTime());
        dt.setText(dt.getText() + " " + formattedDate + ordinal + ".");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    public void goToSettings(View v) {
        if (v.getId() == R.id.settings_button) {
            Intent i = new Intent(Home.this, Settings.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goToHelp(View v) {
        if (v.getId() == R.id.help_button) {
            Intent i = new Intent(Home.this, Help.class);
            startActivity(i);
        }
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.add_button) {
            Intent i = new Intent(Home.this, AddSubroutine.class);
            startActivity(i);
        }
    }


}