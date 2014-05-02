package com.example.nokiaphonesimulator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;

public class SplashScreen extends Activity
{
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ((AnimationDrawable) ((ImageView) this.findViewById(R.id.loading)).getDrawable()).start();
        this.context = this.getApplicationContext();
        new LoadData().execute();
    }

    private class LoadData extends AsyncTask<Void, Void, Void>
    {
        private ArrayList<Contact> contacts;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            getContacts();

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            Intent nokia_phone = new Intent(SplashScreen.this, NokiaPhoneActivity.class);
            nokia_phone.putParcelableArrayListExtra("contacts", contacts);
            startActivity(nokia_phone);

            // close this activity
            finish();
        }

        private void getContacts()
        {
            contacts = new ArrayList<Contact>();

            String id;
            String given_name = null;
            String family_name = null;
            String phone_number = null;

            ContentResolver content_resolver = context.getContentResolver();
            Cursor contact_cursor = content_resolver.query(ContactsContract.Contacts.CONTENT_URI, // query destination
                    null, ContactsContract.Contacts.HAS_PHONE_NUMBER + " != ?", // query
                    new String[] { "0" }, // query variables
                    null);

            contact_cursor.moveToFirst();

            if (contact_cursor.getCount() > 0)
            {
                while (contact_cursor.moveToNext())
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
            contact_cursor.close();
        }

    }

}
