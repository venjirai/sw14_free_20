package com.example.screen.messages;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen;

public class MessagesMenu extends Screen
{

    private TextView action;
    private TextView line1;
    private TextView line2;

    private List<String> menu_titles;
    private int cursor = 0;

    public MessagesMenu(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.menu_titles = new ArrayList<String>();
        this.menu_titles.add("Inbox");
        this.menu_titles.add("Outbox");

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.line1 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.line2 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);
    }

    @Override
    public void update()
    {
        line1.setText(menu_titles.get(cursor));

    }

    @Override
    public void show()
    {
        action.setVisibility(View.VISIBLE);
        line1.setVisibility(View.VISIBLE);
        // line2.setVisibility(View.VISIBLE);

        action.setText("Select");

        nokia_phone.setScreenId(ScreenId.MESSAGES_MENU);
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.INVISIBLE);
        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);

    }

    @Override
    public void enter()
    {
        switch (cursor)
        {
            case 0:
                this.hide();
                screens.get(ScreenId.MESSAGES_INBOX).show();
                break;
            case 1:
                this.hide();
                screens.get(ScreenId.MESSAGES_OUTBOX).show();
                break;
        }

    }

    @Override
    public void clear()
    {
        this.hide();
        screens.get(ScreenId.MAIN_MENU).show();

    }

    @Override
    public void down()
    {
        cursor++;
        if (cursor >= menu_titles.size())
            cursor = 0;
    }

    @Override
    public void up()
    {
        cursor--;
        if (cursor < 0)
            cursor = menu_titles.size() - 1;
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
