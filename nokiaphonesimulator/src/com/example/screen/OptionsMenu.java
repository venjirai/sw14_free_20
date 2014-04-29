package com.example.screen;

import java.util.ArrayList;
import java.util.List;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.NokiaScreen.ScreenId;

import android.R.color;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

//import com.example.nokiaphonesimulator.NokiaPhoneActivity;

public class OptionsMenu extends NokiaScreen
{
    private List<String> options_titles;
    
    private TextView action;
    private TextView options_menu_titles[];

    
    private String action_text;
    
    private int position_end = 2;
    private int position = 0;
    
    private boolean option_selected = false;
    
    private int origin;
    
    public OptionsMenu(NokiaPhoneActivity nokia_phone)
    {
        super();
        this.nokia_phone = nokia_phone;
        
        action_text = "OK";
        
        options_menu_titles = new TextView[3];
        
             
        this.options_menu_titles[0] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_one);
        this.options_menu_titles[1] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_two);
        this.options_menu_titles[2] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_three);
        
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        
    }
    
    public void configureMenu(List<String> titles, int origin)
    {      
        this.options_titles = titles;
        this.origin = origin;
        
        position = 0;
        position_end = options_titles.size() - 1;
        
    }
    
    
    public int getPosition()
    { 
        if (option_selected)
            return position;
        else
            return -1;
    }
    
    public void setPosition(int position)
    {
        this.position = position;
    }
    

    @Override
    public void refresh()
    {     
        option_selected = false;
        action.setVisibility(View.VISIBLE);
        
        for (int i = 0; i < 3; i++)
        {
            options_menu_titles[i].setVisibility(View.VISIBLE); 
            options_menu_titles[i].setText(options_titles.get(i));
            options_menu_titles[i].setBackgroundColor(Color.parseColor("#afc377"));
            options_menu_titles[i].setTextColor(Color.BLACK);
        }
        
        options_menu_titles[position].setBackgroundColor(Color.BLACK);
        options_menu_titles[position].setTextColor(Color.parseColor("#afc377"));
        
        action.setText(action_text);
        
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.GONE);
        for (int i = 0; i < 3; i++)
        {
            options_menu_titles[i].setVisibility(View.GONE); 
        }
        
        if (!option_selected)
            position = 0;
        
    }
    
    
    @Override
    public void enter()
    {
        option_selected = true;
        this.hide(); 
        nokia_phone.setScreenId(origin);
        
    }

    @Override
    public void clear()
    {
        this.hide();
        nokia_phone.setScreenId(origin);
        
    }

    @Override
    public void up()
    {
        position--;
        if (position < 0)
            position = position_end;     
    }

    @Override
    public void down()
    {
        position++;
        if (position > position_end)
            position = 0;  
        
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
