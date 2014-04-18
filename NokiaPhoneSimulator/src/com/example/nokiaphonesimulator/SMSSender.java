package com.example.nokiaphonesimulator;

import android.telephony.SmsManager;

public class SMSSender 
{

	public void sendSMS(String phone_number, String message)
	{
		try 
		{
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(phone_number, null, message, null, null);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
