package com.example.nokiaphonesimulator.test;

import junit.framework.TestCase;

import com.example.nokiaphonesimulator.Contact;
import com.example.nokiaphonesimulator.Sms;

public class ClassesTest extends TestCase 
{
	public ClassesTest() 
	{
		super();
	}

	public void testContact() throws Throwable
	{
		String id = "321";
		String name = "Max Jedermann";
		String phone_number = "1234567890";
		
        Contact contact = new Contact(id, name, phone_number);

	    assertEquals("id must be 321", id, contact.getId());
	    assertEquals("name must be 'Max Jedermann'", name, contact.getName());
	    assertEquals("phone_number must be 1234567890", phone_number, contact.getNumber());
	} 
	
	public void testSms() throws Throwable
    {
	    String id = "321";
	    String address = "1234567890";
	    String contact = "Max Jedermann";
	    String date = "100000000000";          
	    String read = "1";   
	    String body = "Test message";
        
        Sms sms = new Sms(id, address, contact, date, read, body);

        assertEquals("id must be 321", id, sms.getId());
        assertEquals("address must be 1234567890", address, sms.getAddress());
        assertEquals("name must be 'Max Jedermann'", contact, sms.getContact());
        assertEquals("date must be 100000000000", date, sms.getDate());
        assertEquals("read must be 1", read, sms.getRead());
        assertEquals("body must be 1", body, sms.getBody());
    }
}
