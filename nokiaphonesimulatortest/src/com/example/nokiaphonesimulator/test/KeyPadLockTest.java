package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.robotium.solo.Solo;

public class KeyPadLockTest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
  private Solo solo;
  
  public KeyPadLockTest() 
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

  public void testKeyLock() throws Throwable
  {
    this.solo.clickOnButton(2); // Enter
    this.solo.clickOnButton(13); // *  
    
    // check if keypad is locked
    TextView output = (TextView) solo.getView(R.id.action);
    assertEquals("Unlock", output.getText().toString());
  }
}