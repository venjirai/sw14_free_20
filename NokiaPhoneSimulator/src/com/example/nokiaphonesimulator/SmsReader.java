package com.example.nokiaphonesimulator;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class SmsReader
{
    private List<String> sms;

    public SmsReader(Context context)
    {
        Uri sms_uri = Uri.parse("content://sms/inbox");
        Cursor cursor = context.getContentResolver().query(sms_uri, null, null, null, null);
        cursor.moveToFirst();

        while (cursor.moveToNext())
        {
            sms.add("From: " + cursor.getString(2) + " : " + cursor.getString(11));
        }
    }
}
