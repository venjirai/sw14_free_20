package com.example.screen.messages;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.nokiaphonesimulator.Sms;
import com.example.screen.Screen;

public class MessagesOutbox extends Screen
{
    private TextView menu_textview[];
    private TextView action;
    private TextView menu_number;

    private ArrayList<Sms> sms_outbox;
    private int cursor_screen = 0;
    private int cursor_list = 0;

    public MessagesOutbox(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.sms_outbox = nokia_phone.getIntent().getParcelableArrayListExtra("sms_sent");

        this.menu_textview = new TextView[3];
        this.menu_textview[0] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.menu_textview[1] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);
        this.menu_textview[2] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_three);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.menu_number = (TextView) nokia_phone.findViewById(R.id.header_right);
    }

    private int getCursor(int pos)
    {
        pos += cursor_list - cursor_screen;

        if (pos >= sms_outbox.size())
            pos -= sms_outbox.size();
        else if (pos < 0)
            pos += sms_outbox.size();

        return pos;
    }

    @Override
    public void update()
    {
        action.setText("Read");
        menu_number.setText("1-2-" + String.valueOf(cursor_list + 1));

        menu_textview[0].setText(sms_outbox.get(getCursor(0)).getContact());
        menu_textview[1].setText(sms_outbox.get(getCursor(1)).getContact());
        menu_textview[2].setText(sms_outbox.get(getCursor(2)).getContact());

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
        menu_number.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.MESSAGES_OUTBOX);
    }

    @Override
    public void hide()
    {
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setVisibility(View.INVISIBLE);
            menu_textview[i].setBackgroundColor(Color.TRANSPARENT);
            menu_textview[i].setTextColor(Color.parseColor("#2C2328"));
        }

        action.setVisibility(View.INVISIBLE);
        menu_number.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        this.hide();

        ((ReadMessage) screens.get(ScreenId.READ_MESSAGE)).setCursor(cursor_list, ReadMessage.OUTBOX);
        screens.get(ScreenId.READ_MESSAGE).show();

    }

    @Override
    public void clear()
    {
        cursor_screen = 0;
        cursor_list = 0;
        
        this.hide();
        screens.get(ScreenId.MESSAGES_MENU).show();
    }

    @Override
    public void down()
    {
        cursor_list++;
        if (cursor_list >= sms_outbox.size())
            cursor_list = 0;

        cursor_screen++;
        if (cursor_screen > 2)
            cursor_screen = 2;

    }

    @Override
    public void up()
    {
        cursor_list--;
        if (cursor_list < 0)
            cursor_list = sms_outbox.size() - 1;

        cursor_screen--;
        if (cursor_screen < 0)
            cursor_screen = 0;

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
