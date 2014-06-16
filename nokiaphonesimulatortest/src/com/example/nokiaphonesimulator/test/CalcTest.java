package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.robotium.solo.Solo;

public class CalcTest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
  private Solo solo;
  
  public CalcTest() 
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

  public void testAddition() throws Throwable
  {
    // Go to the calculator
    this.solo.clickOnButton(2); // Enter
    this.solo.clickOnButton(1); // Key down
    this.solo.clickOnButton(2); // Enter
    
    // Test addition
    this.solo.clickOnButton(4); // 1
    
    // +
    this.solo.clickOnButton(2); // Enter
    this.solo.clickOnButton(1); // Key down
    this.solo.clickOnButton(2); // Enter
    
    this.solo.clickOnButton(5); // 2
    
    // =
    this.solo.clickOnButton(2); // Enter
    this.solo.clickOnButton(2); // Enter
    
    // check result 1 + 2 must be 3
    TextView output = (TextView) solo.getView(R.id.input);
    assertEquals("3", output.getText().toString());
  }
}