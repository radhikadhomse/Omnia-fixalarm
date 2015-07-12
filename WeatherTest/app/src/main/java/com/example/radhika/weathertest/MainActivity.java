package com.example.radhika.weathertest;

import android.speech.tts.Voice;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import java.util.Locale;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
public class MainActivity extends ActionBarActivity {
    TextToSpeech ttsobj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int status) {

            }
        }
        );
        ttsobj.setLanguage(Locale.US);
//        Voice defaultVoice = ttsobj.getDefaultVoice();
//        ttsobj.setVoice(defaultVoice);
    }
    public void onButtonClick(View v) {
        if(v.getId() == R.id.btn_login){
            String user = "";

            EditText tempEditText = (EditText)findViewById(R.id.fld_username);
            if(tempEditText.getText().toString() !=null)
                user = tempEditText.getText().toString();
            ttsobj.speak("Hello " +user + " My name is Omnia", TextToSpeech.QUEUE_FLUSH,null);
//
            Intent i  = new Intent(MainActivity.this, AddRoutineActivity.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
