package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.nokiaphonesimulator.SplashScreen;
import com.robotium.solo.Solo;

public class MessagesTest extends ActivityInstrumentationTestCase2<SplashScreen> 
{
    private Solo solo;
    
    public MessagesTest() 
    {
        super(SplashScreen.class);
    }
    
    protected void setUp() throws Exception 
    {
        super.setUp();
        this.solo = new Solo(getInstrumentation(), getActivity());
    }

    protected void tearDown() throws Exception 
    {
        //super.tearDown();
        solo.finishOpenedActivities();
    }

    public void testMessagesInbox() throws Throwable
    {
        this.solo.waitForActivity(NokiaPhoneActivity.class);
        
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(1); // Key down
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(3); // Key up
        
        TextView output = (TextView) solo.getView(R.id.text_output);
        assertEquals("Sent:", output.getText().toString().substring(0, 5));
        
        this.solo.clickOnButton(3); // Key up
        
        assertEquals("Sender:", output.getText().toString().substring(0, 7));
    }
    
    public void testMessagesOutbox() throws Throwable
    {        
        this.solo.waitForActivity(NokiaPhoneActivity.class);
        
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(1); // Key down
        this.solo.clickOnButton(1); // Key down
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(3); // Key up
        
        TextView output = (TextView) solo.getView(R.id.text_output);
        assertEquals("Sent:", output.getText().toString().substring(0, 5));
        
        this.solo.clickOnButton(3); // Key up
        
        assertEquals("Receiver:", output.getText().toString().substring(0, 9));
    }
    
    public void testWriteMessage() throws Throwable
    {        
        this.solo.waitForActivity(NokiaPhoneActivity.class);
        
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(2); // Enter
        this.solo.clickOnButton(15); // toggle case
        this.solo.clickOnButton(11); // T
        this.solo.clickOnButton(15); // toggle case
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7); // h
        this.solo.sleep(2200);
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7); // i
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.clickOnButton(14); // space
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7); // i
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.clickOnButton(14); // space
        this.solo.clickOnButton(5); // a
        this.solo.clickOnButton(14); // space
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.clickOnButton(7);
        this.solo.clickOnButton(7); // h
        this.solo.clickOnButton(9);
        this.solo.clickOnButton(9);
        this.solo.clickOnButton(9); // o        
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // r
        this.solo.clickOnButton(11); // t
        this.solo.clickOnButton(14); // space
        this.solo.clickOnButton(11); // t
        this.solo.clickOnButton(6);
        this.solo.clickOnButton(6); // e
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.clickOnButton(11); // t
        this.solo.clickOnButton(14); // space
        this.solo.clickOnButton(9); // m  
        this.solo.clickOnButton(6);
        this.solo.clickOnButton(6); // e
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.sleep(2200);
        this.solo.clickOnButton(10); 
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10);
        this.solo.clickOnButton(10); // s
        this.solo.clickOnButton(5); // a
        this.solo.clickOnButton(7); // g
        this.solo.clickOnButton(6);
        this.solo.clickOnButton(6); // e
        this.solo.clickOnButton(4); 
        this.solo.clickOnButton(4);
        this.solo.clickOnButton(4);
        this.solo.clickOnButton(4);
        this.solo.clickOnButton(4); // !
        
        
        TextView output = (TextView) solo.getView(R.id.text_output);
        assertEquals("This is a short test message!", output.getText().toString());
    }
}
