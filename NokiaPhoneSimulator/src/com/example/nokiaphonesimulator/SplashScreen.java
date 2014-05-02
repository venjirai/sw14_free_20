package com.example.nokiaphonesimulator;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
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
        private ArrayList<Sms> sms_inbox;

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            getContacts();
            getSmsInbox();

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            Intent nokia_phone = new Intent(SplashScreen.this, NokiaPhoneActivity.class);
            nokia_phone.putParcelableArrayListExtra("contacts", contacts);
            nokia_phone.putParcelableArrayListExtra("sms_inbox", sms_inbox);
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
                    new String[] { ContactsContract.Contacts._ID }, // requested columns
                    ContactsContract.Contacts.HAS_PHONE_NUMBER + " != ?", // query
                    new String[] { "0" }, // query variables
                    null);

            contact_cursor.moveToFirst();

            if (contact_cursor.getCount() > 0)
            {
                while (contact_cursor.moveToNext())
                {
                    id = contact_cursor.getString(0);

                    // Using the contact ID we will get contact phone number
                    Cursor phone_cursor = content_resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, // query destination
                            new String[] { ContactsContract.CommonDataKinds.Phone.NUMBER }, // requested columns
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?", // query
                            new String[] { id }, // query variables
                            null);

                    if (phone_cursor.moveToFirst())
                    {
                        phone_number = phone_cursor.getString(0);
                    }
                    phone_cursor.close();

                    // Using the contact ID we will get contact name                    
                    Cursor name_cursor = content_resolver.query(ContactsContract.Data.CONTENT_URI, // query destination
                            new String[] { ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME }, // requested columns
                            ContactsContract.Data.MIMETYPE + " = ? AND " + ContactsContract.CommonDataKinds.StructuredName.CONTACT_ID + " = ?", // query
                            new String[] { ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE, id }, // query variables
                            null);

                    if (name_cursor.moveToFirst())
                    {
                        given_name = name_cursor.getString(0);
                        family_name = name_cursor.getString(1);
                    }
                    name_cursor.close();

                    contacts.add(new Contact(id, given_name, family_name, phone_number));

                }
            }
            contact_cursor.close();
        }

        private void getSmsInbox()
        {
            sms_inbox = new ArrayList<Sms>();
            
            /* * * * * * * * * * * * * *
             * Column ID - Column Name *
             *                         *
             *  0 : _id                *
             *  1 : thread_id          *
             *  2 : address            *
             *  3 : person             *
             *  4 : date               *
             *  5 : protocol           *
             *  6 : read               *
             *  7 : status             *
             *  8 : type               *
             *  9 : reply_path_present *
             * 10 : subject            *
             * 11 : body               *
             * 12 : service_center     *
             * 13 : locked             *
             * * * * * * * * * * * * * */

            Cursor cursor = context.getContentResolver().query(Uri.parse("content://sms/inbox"), // query destination
                    new String[] { "_id", "address", "person", "date", "read", "body" }, // requested columns
                    null, null, null);
            cursor.moveToFirst();

            if (cursor.getCount() > 0)
            {
                while (cursor.moveToNext())
                {
                    sms_inbox.add(new Sms(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
                }
                cursor.close();
            }
        }

    }

}
