package com.example.nokiaphonesimulator;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

public class ContactList {
	
	Context context;
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	
	// call with ApplicationContext 
	public ContactList(Context context)
	{
		this.context = context;
		
		String id = "";
		String first_name = "";
		String last_name = "";
		String phone_number = "";
		
		ContentResolver cr = context.getContentResolver();		
        Cursor id_cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        id_cursor.moveToFirst();
        
        if (id_cursor.getCount() > 0) 
        {
            while (id_cursor.moveToNext()) 
            {
            	if (Integer.parseInt(id_cursor.getString(id_cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) 
                {
            		id = id_cursor.getString(id_cursor.getColumnIndex(ContactsContract.Contacts._ID));
            		
            		// Using the contact ID now we will get contact phone number
                    Cursor cursor_phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},             
                                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? AND " +
                                    ContactsContract.CommonDataKinds.Phone.TYPE + " = " +
                                    ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE,
                                    new String[]{id}, null);
             
                    if (cursor_phone.moveToFirst()) {
                        phone_number = cursor_phone.getString(cursor_phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    cursor_phone.close();     
                                		
            		// Using the contact ID now we will get contact name
                    String whereName = ContactsContract.Data.MIMETYPE
                            + " = ? AND "
                            + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID
                            + " = ?";
                    String[] whereNameParams = new String[] {
                            ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE,
                            id };
                    Cursor nameCur = cr
                            .query(ContactsContract.Data.CONTENT_URI,
                                    null,
                                    whereName,
                                    whereNameParams,
                                    ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME);
                    
                    if (nameCur.moveToFirst()) {
                        first_name = nameCur
                                .getString(nameCur
                                        .getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME));
                        last_name = nameCur
                                .getString(nameCur
                                        .getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME));
                    }
                    nameCur.close();
                              		
                    contacts.add(new Contact(id, first_name, last_name, phone_number));
                   
                }
            }
        }
        
	}
	
    public Contact getContact(int index)
    {
    	return contacts.get(index);
    }
    
    public int size()
    {
    	return contacts.size();
    }

}
