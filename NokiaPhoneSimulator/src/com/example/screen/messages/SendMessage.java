package com.example.screen.messages;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.Contact;
import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen;
import com.example.screen.Screen.ScreenId;

public class SendMessage extends Screen
{

    private TextView action;
    private TextView number;
    private TextView name;

    private ArrayList<Contact> contacts;
    private int cursor = 0;

    public SendMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.number = (TextView) nokia_phone.findViewById(R.id.input);
        this.name = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);

        this.contacts = nokia_phone.getIntent().getParcelableArrayListExtra("contacts");
    }

    @Override
    public void update()
    {
        name.setText(contacts.get(cursor).getName());
        number.setText(contacts.get(cursor).getNumber());
    }

    @Override
    public void show()
    {
        action.setVisibility(View.VISIBLE);
        number.setVisibility(View.VISIBLE);
        name.setVisibility(View.VISIBLE);

        action.setText("Send");

        nokia_phone.setScreenId(ScreenId.SEND_MESSAGE);
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.INVISIBLE);
        number.setVisibility(View.INVISIBLE);
        name.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {        
        String phoneNumber = contacts.get(cursor).getNumber();
        String message = ((WriteMessage)screens.get(ScreenId.WRITE_MESSAGE)).getMessage();

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> parts = smsManager.divideMessage(message);
        smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null);
        
        ((WriteMessage)screens.get(ScreenId.WRITE_MESSAGE)).setMessage("");
        
        this.hide();
        screens.get(ScreenId.MESSAGES_MENU).show();
    }

    @Override
    public void clear()
    {        
        this.hide();
        screens.get(ScreenId.WRITE_MESSAGE).show();
    }

    @Override
    public void down()
    {
        cursor++;
        if (cursor >= contacts.size())
            cursor = 0;
    }

    @Override
    public void up()
    {
        cursor--;
        if (cursor < 0)
            cursor = contacts.size() - 1;
    }

    @Override
    public void zero()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void one()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void two()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void three()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void four()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void five()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void six()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void seven()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void eight()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void nine()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void pound()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void star()
    {
        // TODO Auto-generated method stub

    }

    private void call(String phone_number)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
        nokia_phone.startActivity(callIntent);
    }

}
