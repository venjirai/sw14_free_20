package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class NokiaPhoneActivity extends Activity {
	
	String phone_number = "";
	TextView output1;	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
		
		btn_zero.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("0");
			}});
		
		btn_one.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("1");
			}});
		
		btn_two.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("2");
			}});
		
		btn_three.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("3");
			}});
		
		btn_four.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("4");
			}});
		
		btn_five.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("5");
			}});
		
		btn_six.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("6");
			}});
		
		btn_seven.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("7");
			}});
		
		btn_eight.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("8");
			}});
		
		btn_nine.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				digitButton("9");
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
    
    private void call(String phone_number) {
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
            startActivity(callIntent);
    }
}
