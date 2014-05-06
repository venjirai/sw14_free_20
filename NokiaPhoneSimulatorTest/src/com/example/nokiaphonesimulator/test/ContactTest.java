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
		String name = "Max Jedermann";
		String phone_number = "1234567890";
		
        Contact contact = new Contact(id, name, phone_number);

	    assertEquals("id must be 321", id, contact.getId());
	    assertEquals("name must be 'Max Jedermann'", name, contact.getName());
	    assertEquals("phone_number must be 1234567890", phone_number, contact.getNumber());
	} 
}
