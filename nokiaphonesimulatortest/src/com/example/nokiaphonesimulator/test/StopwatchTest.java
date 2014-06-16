package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.robotium.solo.Solo;

public class StopwatchTest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
  private Solo solo;
  
  public StopwatchTest() 
  {
    super(NokiaPhoneActivity.class);
  }
  
  protected void setUp() throws Exception 
  {
    super.setUp();
    this.solo = new Solo(getInstrumentation(), getActivity());
  }

  protected void tearDown() throws Exception 
  {
    super.tearDown();
  }

  public void testStopwatch() throws Throwable
  {
    // Go to stopwatch
    this.solo.clickOnButton(2); // Enter  
    this.solo.clickOnButton(1); // Down  
    this.solo.clickOnButton(1); // Down  
    this.solo.clickOnButton(2); // Enter 
    this.solo.clickOnButton(2); // Enter  
    
    // Start stopwatch
    this.solo.clickOnButton(2); // Enter
    solo.sleep(5000);
    this.solo.clickOnButton(2); // Enter
    
      
    TextView output = (TextView) solo.getView(R.id.stopwatch);
    String output_string = output.getText().toString();
    
    char second_1 = output_string.charAt(5);
    char second_2 = output_string.charAt(6);
    
    assertEquals('0', second_1);
    assertEquals('5', second_2);
         
  }
  

}