package com.example.screen;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;


public abstract class NokiaScreen
{
    protected NokiaPhoneActivity nokia_phone;
    
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
    
    abstract public void show();
    abstract public void hide();
    
    // needs update if layout changes!
    protected void init()
    {
        // get the display elements        
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.title = (TextView) nokia_phone.findViewById(R.id.title);

        action.setVisibility(View.VISIBLE);
        title.setVisibility(View.VISIBLE);
    }
}
