package com.example.nokiaphonesimulator;

import android.telephony.SmsManager;

public class SmsSender 
{
	private SmsManager sms_manager;
	
	
	public SmsSender()
	{
		this.sms_manager = SmsManager.getDefault();
	}
	
	public void sendSms(String phone_number, String message)
	{
		try 
		{
			sms_manager.sendTextMessage(phone_number, null, message, null, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
