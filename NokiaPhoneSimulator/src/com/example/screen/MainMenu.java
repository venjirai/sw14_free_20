package com.example.screen;

import java.util.ArrayList;

import android.view.View;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class MainMenu extends NokiaScreen
{
    private ArrayList<String> menu_titles;
    
    public MainMenu(NokiaPhoneActivity nokia_phone)
    {
        super();
        this.nokia_phone = nokia_phone;
        
        // get content
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
        
        this.init();
    }
    
    @Override
    protected void init()
    {
        super.init();
        
        // set visible elements
        action.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
        
        // set content
        action.setText("Select");
        title.setText(menu_titles.get(0));
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
    public void clear()
    {
        nokia_phone.screen = new StartScreen(nokia_phone);
    }

    @Override
    public void enter()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void down()
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

    @Override
    public void up()
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
