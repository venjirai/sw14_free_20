package com.example.nokiaphonesimulator.test;

import junit.framework.TestCase;
import com.example.nokiaphonesimulator.Contact;

public class ContactTest extends TestCase 
{
	public ContactTest() 
	{
		super();
	}

	public void testConstructor() throws Throwable
	{
		String id = "321";
		String given_name = "Max";
		String family_name = "Jedermann";
		String phone_number = "1234567890";
		
        Contact contact = new Contact(id, given_name, family_name, phone_number);

	    assertEquals("id must be 321", id, contact.getId());
	    assertEquals("given_name must be Max", given_name, contact.getGivenName());
	    assertEquals("family_name must be Jedermann", family_name, contact.getFamilyName());
	    assertEquals("phone_number must be 1234567890", phone_number, contact.getPhoneNumber());
	} 
}
