package com.example.nokiaphonesimulator;

import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.Stack;

public class DisplayIO
{
    private NokiaPhoneActivity nokia_phone;
    private String menu = "Start";
    private Stack<String> history;
    private ArrayList<String> menu_titles;

    private ImageView battery_indicator;
    private ImageView signal_indicator;

    private TextView action;
    private TextView title;

    DisplayIO(NokiaPhoneActivity nokia_phone_activity)
    {
        this.nokia_phone = nokia_phone_activity;

        this.history = new Stack<String>();
        this.menu_titles = new ArrayList<String>();

        menu_titles.add(nokia_phone.getString(R.string.phone_book));
        menu_titles.add(nokia_phone.getString(R.string.messages));
        menu_titles.add(nokia_phone.getString(R.string.chat));
        menu_titles.add(nokia_phone.getString(R.string.call_register));
        menu_titles.add(nokia_phone.getString(R.string.tones));
        menu_titles.add(nokia_phone.getString(R.string.settings));
        menu_titles.add(nokia_phone.getString(R.string.call_divert));
        menu_titles.add(nokia_phone.getString(R.string.games));
        menu_titles.add(nokia_phone.getString(R.string.calculator));
        menu_titles.add(nokia_phone.getString(R.string.reminders));
        menu_titles.add(nokia_phone.getString(R.string.clock));
        menu_titles.add(nokia_phone.getString(R.string.profiles));

        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.title = (TextView) nokia_phone.findViewById(R.id.titel);
    }

    // Button logic:

    public void enter()
    {
        // add cases when enter is pressed
        if (menu.equals("Start"))
        {
            history.push(menu);

            menu(menu);

            menu = "Menu";
        }
        else if (menu.equals("Menu"))
        {

        }

    }

    public void clear()
    {
        // add cases when clear is pressed
        if (!history.empty())
        {
            String previous = history.pop();

            if (previous.equals("Start"))
            {
                startScreen();
            }

            menu = "Start";
        }
    }

    public void down()
    {
        // add cases when down is pressed
        if (menu.equals("Menu"))
        {
            String current_titel = (String) title.getText();
            for (int i = 0; i < menu_titles.size(); i++)
            {
                if (current_titel.equals(menu_titles.get(i)))
                {
                    i++;
                    i %= menu_titles.size();

                    title.setText(menu_titles.get(i));
                    break;
                }
            }
        }
    }

    public void up()
    {
        // add cases when up is pressed
        if (menu.equals("Menu"))
        {
            String current_titel = (String) title.getText();
            for (int i = 0; i < menu_titles.size(); i++)
            {
                if (current_titel.equals(menu_titles.get(i)))
                {
                    i--;
                    if (i < 0)
                        i = menu_titles.size() - 1;

                    title.setText(menu_titles.get(i));
                    break;
                }
            }
        }
    }

    // define screens:

    // shows the start screen
    private void startScreen()
    {
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
        title.setVisibility(View.GONE);

        action.setText(nokia_phone.getString(R.string.menu));
    }

    // shows the main menu, call with previous menu 
    private void menu(String previous)
    {
        battery_indicator.setVisibility(View.GONE);
        signal_indicator.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);

        action.setText(nokia_phone.getString(R.string.select));

        if (previous.equals("Start"))
        {
            title.setText(menu_titles.get(0));
        }
        else
        {
            title.setText(previous);
        }
    }

}
