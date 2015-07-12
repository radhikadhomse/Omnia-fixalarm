package com.example.radhika.weathertest;
// should be AddSubroutineActivity
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
public class AddRoutineActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_routine);
        Spinner condition_spinner = (Spinner)findViewById(R.id.condition_dropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.condition_type_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition_spinner.setAdapter(adapter);

        Spinner task_spinner = (Spinner)findViewById(R.id.task_dropdown);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.task_options, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        task_spinner.setAdapter(adapter1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_routine, menu);
        return true;
    }

    public void backButton(View v)
    {
        if(v.getId() == R.id.back_button_1)
        {
            Intent i = new Intent(AddRoutineActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
    public void onButtonClick(View v) {
        if(v.getId() == R.id.create_button) {
            Intent i = new Intent(AddRoutineActivity.this, CreateSub.class);
            startActivity(i);

        }
        else if (v.getId() == R.id.load_button){
            Intent i = new Intent(AddRoutineActivity.this,CreateSub.class );
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
}