package com.example.radhika.omnia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TimePicker;
import android.widget.Toast;

public class TimeAndDay extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_day);
    }
    public void onButtonClick(View v) {
        /**
         * to get current time:
         * import java.util.Calendar;
         * Calendar curr = Calendar.getInstance();
         * int h = curr.get(Calendar.HOUR_OF_DAY);
         * int m = curr.get(Calendar.MINUTE);
         *
         */
        if(((CheckBox)findViewById(R.id.checkbox_mon)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_tues)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_wed)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_thurs)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_fri)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_sat)).isChecked()
                || ((CheckBox)findViewById(R.id.checkbox_sun)).isChecked()
                ) {
            Intent i = new Intent(TimeAndDay.this, CreateSubroutine.class);
            TimePicker tp = (TimePicker)findViewById(R.id.timePicker);
            int hour = tp.getCurrentHour();
            int min = tp.getCurrentMinute();
            i.putExtra("Hour",hour);
            i.putExtra("Minute",min);
            startActivity(i);
        }
        else {
            Toast.makeText(TimeAndDay.this, "Please select at least one day.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_and_day, menu);
        return true;
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
}
