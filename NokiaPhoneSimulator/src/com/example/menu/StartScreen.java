package com.example.menu;

import android.view.View;
import android.widget.ImageView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class StartScreen extends NokiaScreen 
{
    private ImageView battery_indicator;
    private ImageView signal_indicator;

    public StartScreen(NokiaPhoneActivity nokia_phone)
    {
        super();
        this.nokia_phone = nokia_phone;
        
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        
        this.init();
    }
    
    @Override
    protected void init()
    {
        super.init();
        
        // set visible elements
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);
        
        // set content
        action.setText("Menu");
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void enter()
    {
        nokia_phone.screen = new MainMenu(nokia_phone);       
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

}
