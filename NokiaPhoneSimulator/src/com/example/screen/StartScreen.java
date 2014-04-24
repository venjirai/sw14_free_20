package com.example.screen;

import android.view.View;
import android.widget.ImageView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class StartScreen extends NokiaScreen 
{    
    protected ImageView battery_indicator;
    protected ImageView signal_indicator;
    
    public StartScreen(NokiaPhoneActivity nokia_phone)
    {
        super();
        this.nokia_phone = nokia_phone;
        
        this.init();
    }

    @Override
    public void init()
    {
        super.init();
        action_text = "Menu";     
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        
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
    public int clear()
    {
        return Screen.START_SCREEN;    
    }

    @Override
    public int enter()
    {
        this.hide();
        return Screen.MAIN_MENU;     
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
    public void show(int origin)
    {
        this.origin = origin;
        action.setText(action_text);
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
    }
    
    @Override
    public void hide()
    {
        battery_indicator.setVisibility(View.GONE);
        signal_indicator.setVisibility(View.GONE);
       
    }



}
