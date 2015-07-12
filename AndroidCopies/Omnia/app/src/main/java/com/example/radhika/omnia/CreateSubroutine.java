package com.example.radhika.omnia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateSubroutine extends ActionBarActivity implements AdapterView.OnItemSelectedListener {
    private static int clicked = 0;
    private static int [] spinnerStates = new int[5];
    private static String subroutine_name = "";
    private static boolean save = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_subroutine);
        int hour = getIntent().getIntExtra("Hour",100);
        int min = getIntent().getIntExtra("Minute",100);
        Subroutine temp;
//        Toast.makeText(CreateSubroutine.this, hour, Toast.LENGTH_LONG).show();
        if(hour == 0)
            hour = 12;
        if(hour >= 13)
            hour = hour -12;
        String m = "";
        if(min <10)
            m += ("0" + min);
        else
            m+= min;
        if(!(hour == min && hour == 100)) {
            ((Button) findViewById(R.id.condition_button)).setText("" + hour + " : " + "" + m);
        }
        if (hour == 100 || min == 100)
            ((Button)findViewById(R.id.condition_button)).setText("Set Day and Time");
        setUpSpinners();
        ((Button) findViewById(R.id.minus_button_1)).setVisibility(View.INVISIBLE);
        resume();
        ((TextView)(findViewById(R.id.name_edit_text))).setText(subroutine_name);
    }
    public void resume(){
        if(clicked == 0)
            ((Spinner) findViewById(R.id.task_dropdown)).setVisibility(View.VISIBLE);
        if(clicked == 1){
            ((Spinner) findViewById(R.id.task_dropdown)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.VISIBLE);
        }
        if(clicked == 2){
            ((Spinner) findViewById(R.id.task_dropdown)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_3)).setVisibility(View.VISIBLE);
        }
        if(clicked == 3){
            ((Spinner) findViewById(R.id.task_dropdown)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_3)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_4)).setVisibility(View.VISIBLE);
        }
        if(clicked==4){
            ((Spinner) findViewById(R.id.task_dropdown)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_3)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_4)).setVisibility(View.VISIBLE);
            ((Spinner) findViewById(R.id.task_dropdown_5)).setVisibility(View.VISIBLE);
        }
        ((Spinner)findViewById(R.id.task_dropdown)).setSelection(spinnerStates[0]);
        ((Spinner)findViewById(R.id.task_dropdown_2)).setSelection(spinnerStates[1]);
        ((Spinner)findViewById(R.id.task_dropdown_3)).setSelection(spinnerStates[2]);
        ((Spinner)findViewById(R.id.task_dropdown_4)).setSelection(spinnerStates[3]);
        ((Spinner)findViewById(R.id.task_dropdown_5)).setSelection(spinnerStates[4]);
    }

    public void setUpSpinners() {
        Spinner task_spinner = (Spinner) findViewById(R.id.task_dropdown);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner.setAdapter(adapter1);
        task_spinner.setOnItemSelectedListener(this);

        Spinner task_spinner2 = (Spinner) findViewById(R.id.task_dropdown_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner2.setAdapter(adapter2);
        task_spinner2.setOnItemSelectedListener(this);
        task_spinner2.setVisibility(View.INVISIBLE);

        Spinner task_spinner3 = (Spinner) findViewById(R.id.task_dropdown_3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner3.setAdapter(adapter3);
        task_spinner3.setOnItemSelectedListener(this);
        task_spinner3.setVisibility(View.INVISIBLE);

        Spinner task_spinner4 = (Spinner) findViewById(R.id.task_dropdown_4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner4.setAdapter(adapter4);
        task_spinner4.setOnItemSelectedListener(this);
        task_spinner4.setVisibility(View.INVISIBLE);

        Spinner task_spinner5 = (Spinner) findViewById(R.id.task_dropdown_5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner5.setAdapter(adapter5);
        task_spinner5.setOnItemSelectedListener(this);
        task_spinner5.setVisibility(View.INVISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_subroutine, menu);
        return true;
    }

    public void plusButtonClicked(View v){
        if(v.getId() == R.id.plus_button_1){
            if(clicked < 4)
                clicked++;
            if(clicked == 1) {
                ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.VISIBLE);
                ((Button) findViewById(R.id.minus_button_1)).setVisibility(View.VISIBLE);
            }
            else if (clicked == 2) {
                ((Spinner) findViewById(R.id.task_dropdown_3)).setVisibility(View.VISIBLE);
            }
            else if (clicked == 3) {
                ((Spinner) findViewById(R.id.task_dropdown_4)).setVisibility(View.VISIBLE);
            }
            else if (clicked == 4){
                ((Spinner) findViewById(R.id.task_dropdown_5)).setVisibility(View.VISIBLE);
            }
        }
    }
    public void minusButtonClicked(View v){
        if(v.getId() == R.id.minus_button_1){
            if (clicked == 1){
                ((Spinner) findViewById(R.id.task_dropdown_2)).setVisibility(View.INVISIBLE);
                ((Button) findViewById(R.id.minus_button_1)).setVisibility(View.INVISIBLE);
            }
            else if(clicked == 2){
                ((Spinner) findViewById(R.id.task_dropdown_3)).setVisibility(View.INVISIBLE);
            }
            else if(clicked == 3){
                ((Spinner) findViewById(R.id.task_dropdown_4)).setVisibility(View.INVISIBLE);
            }
            else if (clicked == 4){
                ((Spinner) findViewById(R.id.task_dropdown_5)).setVisibility(View.INVISIBLE);
            }
            if (clicked >0)
                clicked--;

        }
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
    }
    public void onNothingSelected(AdapterView<?> parent){
    }
    public void confirmSubSave(View v){
        if(v.getId() == R.id.savebutton)
        {
            AlertDialog.Builder confirmSaveMessage = new AlertDialog.Builder(this);
            confirmSaveMessage.setMessage("Are you sure you want to save?");
            confirmSaveMessage.setCancelable(true);
            confirmSaveMessage.setTitle("Confirm save");
            confirmSaveMessage.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(CreateSubroutine.this, "Saved Successfully!", Toast.LENGTH_LONG).show();
                    subroutine_name = ((TextView)findViewById(R.id.name_edit_text)).getText().toString();
                    int hour = getIntent().getIntExtra("Hour",100);
                    int min = getIntent().getIntExtra("Minute",100);
                    ArrayList<Integer> tasks = getTasks();
                    Subroutine new_subroutine = new Subroutine(subroutine_name, hour, min, tasks);
                    Intent i = new Intent(CreateSubroutine.this, AlarmActivity.class);
                    i.putExtra("Subroutine Object", new_subroutine);
                    startActivity(i);
                    //finish();
//                    save = true;
//                    Intent intent = new Intent(CreateSubroutine.this, Home.class);
//                    startActivity(intent);
                }
            });
            confirmSaveMessage.setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id){
                    finish();
                }
            });
            AlertDialog alertDialog = confirmSaveMessage.create();
            alertDialog.show();
        }
    }
    public ArrayList<Integer> getTasks(){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < spinnerStates.length; i++){
            if (i == 0 && ((Spinner)findViewById(R.id.task_dropdown)).getVisibility()==View.VISIBLE)
                temp.add(spinnerStates[i]);
            if (i == 1 && ((Spinner)findViewById(R.id.task_dropdown)).getVisibility()==View.VISIBLE)
                temp.add(spinnerStates[i]);
            if (i == 2 && ((Spinner)findViewById(R.id.task_dropdown)).getVisibility()==View.VISIBLE)
                temp.add(spinnerStates[i]);
            if (i == 3 && ((Spinner)findViewById(R.id.task_dropdown)).getVisibility()==View.VISIBLE)
                temp.add(spinnerStates[i]);
            if (i == 4 && ((Spinner)findViewById(R.id.task_dropdown)).getVisibility()==View.VISIBLE)
                temp.add(spinnerStates[i]);
        }
        return temp;
    }
    public void onButtonClick(View v){
        Intent i = new Intent(CreateSubroutine.this, TimeAndDay.class);
        spinnerStates[0] = ((Spinner)findViewById(R.id.task_dropdown)).getSelectedItemPosition();
        spinnerStates[1] = ((Spinner)findViewById(R.id.task_dropdown_2)).getSelectedItemPosition();
        spinnerStates[2] = ((Spinner)findViewById(R.id.task_dropdown_3)).getSelectedItemPosition();
        spinnerStates[3] = ((Spinner)findViewById(R.id.task_dropdown_4)).getSelectedItemPosition();
        spinnerStates[4] = ((Spinner)findViewById(R.id.task_dropdown_5)).getSelectedItemPosition();
        startActivity(i);
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