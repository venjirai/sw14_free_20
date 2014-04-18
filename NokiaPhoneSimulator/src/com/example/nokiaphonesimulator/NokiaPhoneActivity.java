package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.media.SoundPool;
import android.media.AudioManager;


public class NokiaPhoneActivity extends Activity implements OnTouchListener
{
	private Context context;
	
	private String phone_number = "";
	
	private ContactList contact_list;
	private int cursor = 0;
	
	private int text_length = 0;
	
    private SoundPool sp;
	private TextView output1;
	
	int displayWidth, displayHeight;
	
	int[] sounds = new int[10];
	int tastenton;
	
  @Override
  protected void onCreate(Bundle savedInstanceState) 
  {
      
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nokia_phone);
    
    context = this.getApplicationContext();

    DisplayMetrics metrics = context.getResources().getDisplayMetrics();
    displayWidth = metrics.widthPixels;
    displayHeight = metrics.heightPixels;

    sp = new SoundPool(99, AudioManager.STREAM_MUSIC, 0);
    LoadSounds();
    
    InitializeButtons();
 
    
    Typeface font = Typeface.createFromAsset(getAssets(), "nokiafc22.ttf");
  	output1 = (TextView) this.findViewById(R.id.textView_output1);
  	output1.setTypeface(font);
  	
  	contact_list = new ContactList(context);
  	
 
  }
  

  
  private void InitializeButtons()
  {
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
    
    btn_zero.setOnTouchListener(this);

    btn_one.setOnTouchListener(this);
    btn_two.setOnTouchListener(this);
    btn_three.setOnTouchListener(this);
    btn_four.setOnTouchListener(this);
    btn_five.setOnTouchListener(this);
    btn_six.setOnTouchListener(this);
    btn_seven.setOnTouchListener(this);
    btn_eight.setOnTouchListener(this);
    btn_nine.setOnTouchListener(this);
    
    btn_star.setOnTouchListener(this);
    btn_pound.setOnTouchListener(this);
    btn_clear.setOnTouchListener(this);
    btn_enter.setOnTouchListener(this);
    btn_down.setOnTouchListener(this);
    btn_up.setOnTouchListener(this);
    
    
  }



  private void LoadSounds()
  {
    tastenton = sp.load(this, R.raw.tastenton, 1);
    sounds[0] = sp.load(this, R.raw.s0, 1);
    sounds[1] = sp.load(this, R.raw.s1, 1);
    sounds[2] = sp.load(this, R.raw.s2, 1);
    sounds[3] = sp.load(this, R.raw.s3, 1);
    sounds[4] = sp.load(this, R.raw.s4, 1);
    sounds[5] = sp.load(this, R.raw.s5, 1);
    sounds[6] = sp.load(this, R.raw.s6, 1);
    sounds[7] = sp.load(this, R.raw.s7, 1);
    sounds[8] = sp.load(this, R.raw.s8, 1);
    sounds[9] = sp.load(this, R.raw.s9, 1);
  }



  @Override
  public void onWindowFocusChanged(boolean hasFocus) 
  {
      super.onWindowFocusChanged(hasFocus);

      if(hasFocus) 
      {
      	new LayoutScaler(displayWidth, displayHeight, this);
      	LayoutScaler.scaleContents(findViewById(R.id.contents), findViewById(R.id.container));
      }
  }
  
  
  
  private void digitButton(String digit)
  {
    if (text_length <= 80)
      phone_number += digit;
    else
      text_length--;

      	
  	output1.setText(phone_number);
  }
  
  private void call(String phone_number) 
  {
  	Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + output1.getText()));
    	startActivity(callIntent);
  }




  @Override
  public boolean onTouch(View v, MotionEvent event)
  {

    if(event.getAction() == MotionEvent.ACTION_DOWN)
    {
      if (v.getId() == R.id.btn_zero)
      {
        text_length++;
        digitButton("0");
        sp.play(tastenton, 1, 1, 0, 0, 1);   
      }
      else if (v.getId() == R.id.btn_one)
      {
        text_length++;
        digitButton("1");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
      }
      
      else if (v.getId() == R.id.btn_two)
      {
        text_length++;
        digitButton("2");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        
      }
      
      else if (v.getId() == R.id.btn_three)
      {
        text_length++;
        digitButton("3");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
      }
      
      else if (v.getId() == R.id.btn_four)
      {
        text_length++;
        digitButton("4");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
      }
      
      else if (v.getId() == R.id.btn_five)
      {
        text_length++;
        digitButton("5");
        sp.play(tastenton, 1, 1, 0, 0, 1);  
        
      }
      
      else if (v.getId() == R.id.btn_six)
      {
        text_length++;
        digitButton("6");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        
      }
      
      else if (v.getId() == R.id.btn_seven)
      {
        text_length++;
        digitButton("7");
        sp.play(tastenton, 1, 1, 0, 0, 1);  
      }
      
      else if (v.getId() == R.id.btn_eight)
      {
        text_length++;
        digitButton("8");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
      }
      
      else if (v.getId() == R.id.btn_nine)
      {
        text_length++;
        digitButton("9");
        sp.play(tastenton, 1, 1, 0, 0, 1); 
      }
      
      else if (v.getId() == R.id.btn_star)
      {
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        
      }
      
      else if (v.getId() == R.id.btn_pound)
      {
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        
      }
      
      else if (v.getId() == R.id.btn_clear)
      {
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        if(phone_number.length() > 0)
        {
          phone_number = phone_number.substring(0, phone_number.length() - 1);
          output1.setText(phone_number);
          text_length--;
        }
        
      }
      
      else if (v.getId() == R.id.btn_enter)
      {
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        call(phone_number);
      }
      else if (v.getId() == R.id.btn_down)
      {
        sp.play(tastenton, 1, 1, 0, 0, 1); 
        
        if(cursor < contact_list.size()-1)
          cursor++;
          
        Contact contact = contact_list.getContact(cursor);
        if(contact != null)
        	output1.setText(contact.getPhoneNumber() + contact.getGivenName() + contact.getFamilyName());
         
        
      }
      else if (v.getId() == R.id.btn_up)
      {
          sp.play(tastenton, 1, 1, 0, 0, 1); 
        
          if(cursor > 0)
            cursor--;
        
          Contact contact = contact_list.getContact(cursor);
          if(contact != null)
        	  output1.setText(contact.getPhoneNumber() + contact.getGivenName() + contact.getFamilyName());
      }
      
      
      
    }
     
    return false;
  }

}
