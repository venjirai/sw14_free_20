package com.example.nokiaphonesimulator;

// class representing a single contact
public class Contact 
{	
	// member
	private String id;
	private String given_name;
	private String family_name;
	private String phone_number;
	
	// default constructor
	public Contact()
	{
		id = "";
		given_name = "";
		family_name = "";
		phone_number = "";
	}
	
	// constructor
	public Contact(String id, String given_name, String family_name, String phone_number)
	{
		this.id = id;
		this.given_name = given_name;
		this.family_name = family_name;
		this.phone_number = phone_number;
	}
	
	// setter
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void setGivenName(String first_name)
	{
		this.given_name = first_name;
	}
	
	public void setFamilyName(String last_name)
	{
		this.family_name = last_name;
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
	
	public String getGivenName()
	{
		return given_name;
	}
	
	public String getFamilyName()
	{
		return family_name;
	}
	
	public String getPhoneNumber()
	{
		return phone_number;
	}

}
