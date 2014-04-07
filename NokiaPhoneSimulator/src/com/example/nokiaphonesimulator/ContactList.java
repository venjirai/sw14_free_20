package com.example.nokiaphonesimulator;

import java.util.Vector;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;

public class ContactList 
{
	Context context;
	Vector<Contact> contacts = new Vector<Contact>();
	
	// call with ApplicationContext 
	public ContactList(Context context)
	{
		this.context = context;
		new LoadContacts().execute("");
	}
	
	private class LoadContacts extends AsyncTask<String, Void, String> 
	{
		@Override
        protected String doInBackground(String... params) 
        {        	
        	String id = "";
    		String first_name = "";
    		String last_name = "";
    		String phone_number = "";
    		
        	ContentResolver content_resolver = context.getContentResolver();		
            Cursor contact_cursor = content_resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            contact_cursor.moveToFirst();
            
            if (contact_cursor.getCount() > 0) 
            {
                while (contact_cursor.moveToNext()) 
                {
                	if (Integer.parseInt(contact_cursor.getString(contact_cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) 
                    {
                		id = contact_cursor.getString(contact_cursor.getColumnIndex(ContactsContract.Contacts._ID));
                		
                		// Using the contact ID we will get contact phone number
                		Cursor phone_cursor = content_resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,    // query destination
                				              null, 
                				              ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",  // query
                				              new String[] { id },                                         // query variables 
                				              null);
                 
                        if (phone_cursor.moveToFirst()) 
                        {
                            phone_number = phone_cursor.getString(phone_cursor
                            		.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phone_cursor.close();     
                                    		
                		// Using the contact ID we will get contact name
                        String whereName = ContactsContract.Data.MIMETYPE + " = ? AND "
                                         + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ?";
                        
                        String[] whereNameParams = new String[] { ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, id };
                        
                        Cursor name_cursor = content_resolver.query(ContactsContract.Data.CONTENT_URI,          //query destination
                                             null,
                                             whereName,                // query
                                             whereNameParams,          // query variables
                                             null);
                        
                        if (name_cursor.moveToFirst()) {
                            first_name = name_cursor.getString(name_cursor
                                            .getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME));
                            last_name = name_cursor.getString(name_cursor
                                            .getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME));
                        }
                        name_cursor.close();
                                  		
                        contacts.add(new Contact(id, first_name, last_name, phone_number));                       
                    }
                }
            }
            
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
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
