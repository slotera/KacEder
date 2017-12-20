package com.kaceder.kaceder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

public class Puan extends Activity {

	public Puan() throws IOException {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puan);
		ImageButton img = (ImageButton) findViewById(R.id.imageButton1);
















		TextView tv = (TextView) findViewById(R.id.tvPuan);
		tv.setText(getIntent().getStringExtra("puan"));
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent a = new Intent(Puan.this,MainActivity.class);
				startActivity(a);
				finish();
				
			}
		});
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent a = new Intent(Puan.this,MainActivity.class);
		startActivity(a);
		finish();
	}










}
