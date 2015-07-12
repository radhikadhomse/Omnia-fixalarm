package org.codelearn.codelearnlistexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Pranay Airan
 * 
 */
public class ListViewHome extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.codelearn_list_home);
		
		Button simpleAdapter = (Button)findViewById(R.id.button1);
		Button baseAdapter = (Button)findViewById(R.id.button2);
		Button listAct = (Button)findViewById(R.id.button3);
		
		simpleAdapter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent simple = new Intent(ListViewHome.this,ListViewWithSimpleAdapter.class);
				startActivity(simple);
				
			}
		});
		
		baseAdapter.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent base = new Intent(ListViewHome.this,ListViewWithBaseAdapter.class);
				startActivity(base);
				
			}
		});
		
		listAct.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent base = new Intent(ListViewHome.this,ListViewWithListActivity.class);
				startActivity(base);
				
			}
		});
	}

}
