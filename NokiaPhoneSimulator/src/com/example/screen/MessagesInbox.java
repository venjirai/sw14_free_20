package com.example.screen;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.nokiaphonesimulator.Sms;

public class MessagesInbox extends Screen
{
    private TextView menu_textview[];
    private TextView action;

    private ArrayList<Sms> sms_inbox;
    private int cursor_screen = 0;
    private int cursor_list = 0;

    public MessagesInbox(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.sms_inbox = nokia_phone.getIntent().getParcelableArrayListExtra("sms_inbox");

        this.menu_textview[0] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.menu_textview[1] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);
        this.menu_textview[2] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_three);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
    }
    
    private int getCursor(int pos)
    {
        pos += cursor_list - cursor_screen;
        
        if(pos >= sms_inbox.size())
            pos -= sms_inbox.size();
        else if(pos < 0)
            pos += sms_inbox.size();
               
        return pos;        
    }

    @Override
    public void update()
    {
        action.setText("Read");

        menu_textview[0].setText(sms_inbox.get(getCursor(0)).getContact());
        menu_textview[1].setText(sms_inbox.get(getCursor(1)).getContact());
        menu_textview[2].setText(sms_inbox.get(getCursor(2)).getContact());
        
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setBackgroundColor(Color.TRANSPARENT);
            menu_textview[i].setTextColor(Color.parseColor("#2C2328"));
        }
        
        menu_textview[cursor_screen].setBackgroundColor(Color.parseColor("#2C2328"));
        menu_textview[cursor_screen].setTextColor(Color.parseColor("#afc377"));
    }

    @Override
    public void show()
    {
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setVisibility(View.VISIBLE);
        }

        action.setVisibility(View.VISIBLE);

        //nokia_phone.setScreenId(ScreenId.MESSAGES_INBOX);        
    }

    @Override
    public void hide()
    {
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setVisibility(View.GONE);
            menu_textview[i].setBackgroundColor(Color.TRANSPARENT);
            menu_textview[i].setTextColor(Color.parseColor("#2C2328"));
        }

        action.setVisibility(View.GONE);
    }

    @Override
    public void enter()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void down()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void up()
    {
        // TODO Auto-generated method stub

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

}
