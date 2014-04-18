package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.media.SoundPool;
import android.media.AudioManager;


public class NokiaPhoneActivity extends Activity implements OnClickListener
{
	private Context context;
	
	private String phone_number = "";
	private int text_length = 0;
	
  private SoundPool sp;
	//private ContactList contact_list;
	private int cursor;
		
	private TextView output1;
	
	private TextView output2;
	private TextView output3;
	
	int displayWidth, displayHeight;
	
	int[] sounds = new int[10];
	
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
  	
  	//output2 = (TextView) this.findViewById(R.id.textView_output2);
  	//output3 = (TextView) this.findViewById(R.id.textView_output3);
  
  	//contact_list = new ContactList(context);
  	
 
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
    
    btn_zero.setOnClickListener(this);
    btn_one.setOnClickListener(this);
    btn_two.setOnClickListener(this);
    btn_three.setOnClickListener(this);
    btn_four.setOnClickListener(this);
    btn_five.setOnClickListener(this);
    btn_six.setOnClickListener(this);
    btn_seven.setOnClickListener(this);
    btn_eight.setOnClickListener(this);
    btn_nine.setOnClickListener(this);
    
    btn_star.setOnClickListener(this);
    btn_pound.setOnClickListener(this);
    btn_clear.setOnClickListener(this);
    btn_enter.setOnClickListener(this);
    btn_down.setOnClickListener(this);
    btn_up.setOnClickListener(this);
    
  }



  private void LoadSounds()
  {
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
  	//output2.setText("");
  	//output3.setText("");
  }
  
  private void call(String phone_number) 
  {
  	Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + output1.getText()));
    	startActivity(callIntent);
  }



  @Override
  public void onClick(View v)
  {
    if (v.getId() == R.id.btn_zero)
    {
      text_length++;
      digitButton("0");
      sp.play(sounds[0], 1, 1, 0, 0, 1);   
    }
    
    else if (v.getId() == R.id.btn_one)
    {
      text_length++;
      digitButton("1");
      sp.play(sounds[1], 1, 1, 0, 0, 1);   
    }
    
    else if (v.getId() == R.id.btn_two)
    {
      text_length++;
      digitButton("2");
      sp.play(sounds[2], 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_three)
    {
      text_length++;
      digitButton("3");
      sp.play(sounds[3], 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_four)
    {
      text_length++;
      digitButton("4");
      sp.play(sounds[4], 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_five)
    {
      text_length++;
      digitButton("5");
      sp.play(sounds[5], 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_six)
    {
      text_length++;
      digitButton("6");
      sp.play(sounds[6], 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_seven)
    {
      text_length++;
      digitButton("7");
      sp.play(sounds[7], 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_eight)
    {
      text_length++;
      digitButton("8");
      sp.play(sounds[8], 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_nine)
    {
      text_length++;
      digitButton("9");
      sp.play(sounds[9], 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_star)
    {
    
      
    }
    
    else if (v.getId() == R.id.btn_pound)
    {
    
      
    }
    
    else if (v.getId() == R.id.btn_clear)
    {
      if(phone_number.length() > 0)
      {
        phone_number = phone_number.substring(0, phone_number.length() - 1);
        output1.setText(phone_number);
        text_length--;
      }
      
    }
    
    else if (v.getId() == R.id.btn_enter)
    {
      call(phone_number);
    }
    else if (v.getId() == R.id.btn_down)
    {
      /*
      if(cursor < contact_list.size()-1)
        cursor++;
        
      Contact contact = contact_list.getContact(cursor);
      output1.setText(contact.getPhoneNumber());
      output2.setText(contact.getGivenName());
      output3.setText(contact.getFamilyName());     
       
       */
      
    }
    else if (v.getId() == R.id.btn_up)
    {
      /*
      if(cursor > 0)
        cursor--;
      
      Contact contact = contact_list.getContact(cursor);
        output1.setText(contact.getPhoneNumber());
        output2.setText(contact.getGivenName());
        output3.setText(contact.getFamilyName());
      */
    }
    
    
  }
}
