package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.robotium.solo.Solo;

public class GUITest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
	private Solo solo;
	
	public GUITest() 
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

	public void testNumbers() throws Throwable
	{
		this.solo.clickOnButton(4);
		this.solo.clickOnButton(5);
		this.solo.clickOnButton(6);
		this.solo.clickOnButton(7);
		this.solo.clickOnButton(8);
		this.solo.clickOnButton(9);
		this.solo.clickOnButton(10);
		this.solo.clickOnButton(11);
		this.solo.clickOnButton(12);
		this.solo.clickOnButton(14);
	}
}
