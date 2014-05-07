package com.example.screen;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class MainMenu extends Screen
{
    private TextView action;
    private TextView title;
    private TextView menu_number;

    private String action_text;

    private List<String> menu_titles;
    private int cursor = 0;

    public MainMenu(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        // get content
        this.menu_titles = new ArrayList<String>();
        // menu_titles.add(nokia_phone.getString(R.string.phone_book));
        menu_titles.add(nokia_phone.getString(R.string.messages));
        // menu_titles.add(nokia_phone.getString(R.string.chat));
        // menu_titles.add(nokia_phone.getString(R.string.call_register));
        // menu_titles.add(nokia_phone.getString(R.string.tones));
        // menu_titles.add(nokia_phone.getString(R.string.settings));
        // menu_titles.add(nokia_phone.getString(R.string.call_divert));
        // menu_titles.add(nokia_phone.getString(R.string.games));
        menu_titles.add(nokia_phone.getString(R.string.calculator));
        // menu_titles.add(nokia_phone.getString(R.string.reminders));
        // menu_titles.add(nokia_phone.getString(R.string.clock));
        // menu_titles.add(nokia_phone.getString(R.string.profiles));

        // get display elements      
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.title = (TextView) nokia_phone.findViewById(R.id.title);
        this.menu_number = (TextView) nokia_phone.findViewById(R.id.header_right);

        action_text = "Select";
    }

    @Override
    public void update()
    {
        action.setText(action_text);
        title.setText(menu_titles.get(cursor));
        menu_number.setText(String.valueOf(cursor + 1));
    }

    @Override
    public void show()
    {
        action.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        menu_number.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.MAIN_MENU);
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.INVISIBLE);
        title.setVisibility(View.INVISIBLE);
        menu_number.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        switch (cursor)
        {
            case 0:
                this.hide();
                screens.get(ScreenId.MESSAGES_MENU).show();
                break;
            case 1:
                this.hide();
                screens.get(ScreenId.CALCULATOR).show();
                break;
        }
    }

    @Override
    public void clear()
    {
        this.hide();
        screens.get(ScreenId.START_SCREEN).show();
    }

    @Override
    public void down()
    {
        cursor++;
        if (cursor > menu_titles.size() - 1)
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
