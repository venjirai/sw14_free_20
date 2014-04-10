package com.example.nokiaphonesimulator.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.nokiaphonesimulator.ContactList;
import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.robotium.solo.Solo;

public class ContactListTest extends ActivityInstrumentationTestCase2<NokiaPhoneActivity> 
{
	private Solo solo;
	
	public ContactListTest() 
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

	public void testConstructor() throws Throwable
	{
	    ContactList contact_list = new ContactList(this.solo.getCurrentActivity().getApplicationContext());
	    assertNotNull(contact_list);
	} 
	
	public void testGetSize() throws Throwable
	{
		ContactList contact_list = new ContactList(this.solo.getCurrentActivity().getApplicationContext());
		
	    int size = contact_list.size();
	    assertNotNull(size);
	}
}