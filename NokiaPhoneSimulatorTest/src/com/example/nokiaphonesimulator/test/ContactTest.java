package com.example.nokiaphonesimulator.test;

import junit.framework.TestCase;
import com.example.nokiaphonesimulator.Contact;

public class ContactTest extends TestCase 
{
	public ContactTest() 
	{
		super();
	}

	public void testDefaultConstructor() 
	{
        Contact default_contact = new Contact();
        
	    assertEquals("id must be emtpy", "", default_contact.getId());
	    assertEquals("given_name must be emtpy", "", default_contact.getGivenName());
	    assertEquals("family_name must be emtpy", "", default_contact.getFamilyName());
	    assertEquals("phone_number must be emtpy", "", default_contact.getPhoneNumber());
	} 
}
