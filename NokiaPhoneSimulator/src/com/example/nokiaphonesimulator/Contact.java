package com.example.nokiaphonesimulator;

// class representing a single contact
public class Contact {
	
	// member
	private String id;
	private String first_name;
	private String last_name;
	private String phone_number;
	
	// default constructor
	public Contact()
	{
		id = "";
		first_name = "";
		last_name = "";
		phone_number = "";
	}
	
	// constructor
	public Contact(String id, String first_name, String last_name, String phone_number)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
	}
	
	// setter
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public void setPhoneNumber(String phone_number)
	{
		this.phone_number = phone_number;
	}
	
	// getter
	public String getId()
	{
		return id;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public String getPhoneNumber()
	{
		return phone_number;
	}

}

