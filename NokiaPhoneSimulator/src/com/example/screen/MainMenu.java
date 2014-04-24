package com.example.screen;

import java.util.ArrayList;
import java.util.List;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class MainMenu extends NokiaScreen
{
    private List<String> menu_titles;
    private int position = 0;
    
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
        action_text = "Select";

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
        this.hide();
        next_screen_id = ScreenIds.START_SCREEN;
    }

    @Override
    public void enter()
    {
        next_screen_id = ScreenIds.MAIN_MENU;
    }

    @Override
    public void down()
    {
        position--;
        if (position < 0)
            position = menu_titles.size() - 1;               
    }

    
    @Override
    public void up()
    {
        position++;
        if (position >= menu_titles.size())
            position = 0;    
             
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
    

    @Override
    public void show()
    {        
        action.setText(action_text);
        title.setText(menu_titles.get(position));      
    }

    @Override
    public void hide()
    {
        action.setText("");
        title.setText("");     
    }


}
