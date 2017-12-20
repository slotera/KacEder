package com.kaceder.kaceder;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.VideoView;

public class SplashActivity extends Activity {
	VideoView videoHolder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		try{
	        videoHolder = new VideoView(this);
			setContentView(videoHolder);


			videoHolder.setOnCompletionListener(new OnCompletionListener() {
	
				public void onCompletion(MediaPlayer mp) {
					jump();
				}
				
			});
			videoHolder.start();
		} catch(Exception ex) {
			jump();
		}
    }

	private void jump() {
		if(isFinishing())
			return;
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Intent a = new Intent(SplashActivity.this,MainActivity.class);
		startActivity(a);
		finish();
		return super.onTouchEvent(event);
		
	}
}