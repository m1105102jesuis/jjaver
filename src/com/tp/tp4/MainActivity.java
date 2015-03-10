package com.tp.tp4;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;


public class MainActivity extends Activity {

	private MediaPlayer mPlayer = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public void onPause() {
	        super.onPause();
	    if(mPlayer != null) {
	        mPlayer.stop();
	        mPlayer.release();
	    }
	}
	public void printhour(View view){
		Context context = getApplicationContext();
		TimePicker t =new TimePicker(context);
		String s = t.getCurrentHour().toString()+":"+t.getCurrentMinute();
		//CharSequence text = "test";
		int duration = Toast.LENGTH_SHORT;
		 playSound(R.raw.alarme);
		Toast toast = Toast.makeText(context, s, duration);
		toast.show();
	}
	
	public void changeView(View view){
        Intent it = new Intent(this, Quizz.class);
        playSound(R.raw.alarme);
        startActivity(it);
        this.finish();
	}
	
	private void playSound(int resId) {
	    if(mPlayer != null) {
	        mPlayer.stop();
	        mPlayer.release();
	    }
	    mPlayer = MediaPlayer.create(this, resId);
	    mPlayer.start();
	}
}
