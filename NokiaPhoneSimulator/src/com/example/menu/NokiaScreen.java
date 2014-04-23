package com.example.menu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public abstract class NokiaScreen
{
    protected NokiaPhoneActivity nokia_phone;
    
    protected ImageView battery_indicator;
    protected ImageView signal_indicator;

    protected TextView action;
    protected TextView title;
    
    abstract public void zero();
    abstract public void one();
    abstract public void two();
    abstract public void three();
    abstract public void four();
    abstract public void five();
    abstract public void six();
    abstract public void seven();
    abstract public void eight();
    abstract public void nine();
    
    abstract public void clear();
    abstract public void enter();
    abstract public void down();
    abstract public void up();
    
    protected void init()
    {
        // get the display elements
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.title = (TextView) nokia_phone.findViewById(R.id.titel);
        
        // set all elements gone(invisible)
        battery_indicator.setVisibility(View.GONE);
        signal_indicator.setVisibility(View.GONE);
        action.setVisibility(View.GONE);
        title.setVisibility(View.GONE);
    }
}
