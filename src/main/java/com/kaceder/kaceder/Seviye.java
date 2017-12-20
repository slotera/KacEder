package com.kaceder.kaceder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Seviye extends Activity{
	public final static String EXTRA_MESSAGE = "com.example.kaceder.MESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seviye);
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		Button btn3 = (Button) findViewById(R.id.button3);

		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seviye.this,Game.class);
				   i.putExtra(EXTRA_MESSAGE, "0");
				   i.putExtra("seviye","1" );
				   startActivity(i);
				   finish();
			}
		});
		btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seviye.this,Game.class);
				   i.putExtra(EXTRA_MESSAGE, "0");
				   i.putExtra("seviye","2" );
				   startActivity(i);
				   finish();
			}
		});
		btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seviye.this,Game.class);
				   i.putExtra(EXTRA_MESSAGE, "0");
				   i.putExtra("seviye","3" );
				   startActivity(i);
				   finish();
			}
		}); 
		  
		
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent a = new Intent(Seviye.this,MainActivity.class);
		startActivity(a);
		finish();
	}
}
