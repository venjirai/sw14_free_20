package com.example.nokiaphonesimulator;

import java.util.Vector;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

public class ContactList
{
    // member
    private Context context;
    private Vector<Contact> contacts = new Vector<Contact>();

    // default constructor
    public ContactList()
    {

    }

    // call with ApplicationContext
    public ContactList(Context context)
    {
        this.context = context;

        new LoadContacts().execute();
    }

    private class LoadContacts extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected Void doInBackground(Void... voids)
        {
            String id = "";
            String given_name = "";
            String family_name = "";
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
                        Cursor phone_cursor = content_resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, // query destination
                                null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", // query
                                new String[] { id }, // query variables
                                null);

                        if (phone_cursor.moveToFirst())
                        {
                            phone_number = phone_cursor.getString(phone_cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        }
                        phone_cursor.close();

                        // Using the contact ID we will get contact name
                        String whereName = ContactsContract.Data.MIMETYPE + " = ? AND " + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ?";

                        String[] whereNameParams = new String[] { ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, id };

                        Cursor name_cursor = content_resolver.query(ContactsContract.Data.CONTENT_URI, // query destination
                                null, whereName, // query
                                whereNameParams, // query variables
                                null);

                        if (name_cursor.moveToFirst())
                        {
                            given_name = name_cursor.getString(name_cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME));
                            family_name = name_cursor.getString(name_cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME));
                        }
                        name_cursor.close();

                        contacts.add(new Contact(id, given_name, family_name, phone_number));
                    }
                }
            }
            Log.d("ContactList", String.valueOf(contact_cursor.getCount()) + " contacts loaded");
            contact_cursor.close();
                     
            return null;
        }

        @Override
        protected void onPreExecute()
        {

        }

        @Override
        protected void onProgressUpdate(Void... values)
        {

        }
    }

    public Contact getContact(int index)
    {
        if (contacts.size() == 0)
            return null;
        else
            return contacts.get(index);
    }

    public int size()
    {
        return contacts.size();
    }

}
