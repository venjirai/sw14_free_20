package com.example.nokiaphonesimulator;

import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NokiaPhoneActivity extends Activity {
	
	private String phone_number = "";
	private TextView output1;	
	
	private MediaPlayer mp;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nokia_phone);
        
        Button btn_zero = (Button) this.findViewById(R.id.btn_zero);
		Button btn_one = (Button) this.findViewById(R.id.btn_one);
		Button btn_two = (Button) this.findViewById(R.id.btn_two);
		Button btn_three = (Button) this.findViewById(R.id.btn_three);
		Button btn_four = (Button) this.findViewById(R.id.btn_four);
		Button btn_five = (Button) this.findViewById(R.id.btn_five);
		Button btn_six = (Button) this.findViewById(R.id.btn_six);
		Button btn_seven = (Button) this.findViewById(R.id.btn_seven);
		Button btn_eight = (Button) this.findViewById(R.id.btn_eight);
		Button btn_nine = (Button) this.findViewById(R.id.btn_nine);
		
		Button btn_star = (Button) this.findViewById(R.id.btn_star);
		Button btn_pound = (Button) this.findViewById(R.id.btn_pound);
		Button btn_clear = (Button) this.findViewById(R.id.btn_clear);
		Button btn_enter = (Button) this.findViewById(R.id.btn_enter);
		Button btn_down = (Button) this.findViewById(R.id.btn_down);
		Button btn_up = (Button) this.findViewById(R.id.btn_up);
		
		output1 = (TextView) this.findViewById(R.id.textView_output1);

		mp = new MediaPlayer();
		
		btn_zero.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("0");
				playSound("cell-phone-0.mp3");
			}});
		
		btn_one.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("1");
				playSound("cell-phone-1.mp3");
			}});
		
		btn_two.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("2");
				playSound("cell-phone-2.mp3");
			}});
		
		btn_three.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("3");
				playSound("cell-phone-3.mp3");
			}});
		
		btn_four.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("4");
				playSound("cell-phone-4.mp3");
			}});
		
		btn_five.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("5");
				playSound("cell-phone-5.mp3");
			}});
		
		btn_six.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("6");
				playSound("cell-phone-6.mp3");
			}});
		
		btn_seven.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("7");
				playSound("cell-phone-7.mp3");
			}});
		
		btn_eight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("8");
				playSound("cell-phone-8.mp3");
			}});
		
		btn_nine.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("9");
				playSound("cell-phone-9.mp3");
			}});
		
		btn_star.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}});
		
		btn_pound.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}});
		
		btn_clear.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(phone_number.length() > 0){
					phone_number = phone_number.substring(0, phone_number.length() - 1);
					output1.setText(phone_number);
				}
			}});
		
		btn_enter.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				call(phone_number);
			}});
		
		btn_down.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}});
		
		btn_up.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}});
				
    }
    
    private void digitButton(String digit){
		phone_number += digit;
		output1.setText(phone_number);
	}
    
    private void playSound(String sound_name){
    	 if(mp.isPlaying())  
             mp.stop();

         mp.reset();
         AssetFileDescriptor afd;
    	 try {
             afd = getAssets().openFd(sound_name);
             mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
             mp.prepare();
             mp.start();
         } catch (IllegalStateException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    private void call(String phone_number) {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
            startActivity(callIntent);
    }
}
