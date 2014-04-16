package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
  private SoundPool sp;
	//private ContactList contact_list;
	private int cursor;
		
	private TextView output1;
	private TextView output2;
	private TextView output3;
	
	int zero = 0;
	int one = 0;
	int two = 0;
	int three = 0;
	int four = 0;
	int five = 0;
	int six = 0;
	int seven = 0;
	int eight = 0;
	int nine = 0;
	
  @Override
  protected void onCreate(Bundle savedInstanceState) 
  {
      
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_nokia_phone);
    
    context = this.getApplicationContext();
    
    sp = new SoundPool(99, AudioManager.STREAM_MUSIC, 0);
    
    zero = sp.load(this, R.raw.s0, 1);
    one = sp.load(this, R.raw.s1, 1);
    two = sp.load(this, R.raw.s2, 1);
    three = sp.load(this, R.raw.s3, 1);
    four = sp.load(this, R.raw.s4, 1);
    five = sp.load(this, R.raw.s5, 1);
    six = sp.load(this, R.raw.s6, 1);
    seven = sp.load(this, R.raw.s7, 1);
    eight = sp.load(this, R.raw.s8, 1);
    nine = sp.load(this, R.raw.s9, 1);
    
    
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
  	
  	output1 = (TextView) this.findViewById(R.id.textView_output1);
  	output2 = (TextView) this.findViewById(R.id.textView_output2);
  	output3 = (TextView) this.findViewById(R.id.textView_output3);
  
  	
  	//contact_list = new ContactList(context);
  	
 
  }
  

  
  @Override
  public void onWindowFocusChanged(boolean hasFocus) 
  {
      super.onWindowFocusChanged(hasFocus);

      if(hasFocus) 
      {
      	new LayoutScaler();
      	LayoutScaler.scaleContents(findViewById(R.id.contents), findViewById(R.id.container));
      }
  }
  
  
  
  private void digitButton(String digit)
  {
  	phone_number += digit;
  	output1.setText(phone_number);
  	output2.setText("");
  	output3.setText("");
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
      digitButton("0");
      sp.play(zero, 1, 1, 0, 0, 1);   
    }
    
    else if (v.getId() == R.id.btn_one)
    {
      digitButton("1");
      sp.play(one, 1, 1, 0, 0, 1);   
    }
    
    else if (v.getId() == R.id.btn_two)
    {
      digitButton("2");
      sp.play(two, 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_three)
    {
      digitButton("3");
      sp.play(three, 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_four)
    {
      digitButton("4");
      sp.play(four, 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_five)
    {
      digitButton("5");
      sp.play(five, 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_six)
    {
      digitButton("6");
      sp.play(six, 1, 1, 0, 0, 1); 
      
    }
    
    else if (v.getId() == R.id.btn_seven)
    {
      digitButton("7");
      sp.play(seven, 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_eight)
    {
      digitButton("8");
      sp.play(eight, 1, 1, 0, 0, 1); 
    }
    
    else if (v.getId() == R.id.btn_nine)
    {
      digitButton("9");
      sp.play(nine, 1, 1, 0, 0, 1); 
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
