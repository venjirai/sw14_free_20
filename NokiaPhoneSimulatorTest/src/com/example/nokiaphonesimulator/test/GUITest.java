package com.example.nokiaphonesimulator.test;

import com.example.nokiaphonesimulator.*;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class GUITest extends
		ActivityInstrumentationTestCase2<NokiaPhoneActivity> {

	private Solo solo;

	public GUITest() {
		super(NokiaPhoneActivity.class);	
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testNumbers() {
		this.solo.clickOnButton("enter");
		this.solo.clickOnButton("*");
		this.solo.clickOnButton("0");
		this.solo.clickOnButton("#");
		this.solo.clickOnButton("7");
		this.solo.clickOnButton("8");
		this.solo.clickOnButton("9");
		this.solo.clickOnButton("4");
		this.solo.clickOnButton("5");
		this.solo.clickOnButton("6");
		this.solo.clickOnButton("1");
		this.solo.clickOnButton("2");
		this.solo.clickOnButton("3");
		this.solo.clickOnButton("clear");
		this.solo.clickOnButton("down");
		this.solo.clickOnButton("up");

	}


}
