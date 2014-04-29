package com.example.screen;

import java.util.List;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;


public abstract class NokiaScreen
{
    protected NokiaPhoneActivity nokia_phone;
    protected List<NokiaScreen> screens;
    
    public NokiaScreen(NokiaPhoneActivity nokia_phone)
    {
        this.nokia_phone = nokia_phone;
        this.screens = nokia_phone.getScreens();
    }
    
    abstract public void update();
    abstract public void show();
    abstract public void hide();
    
    abstract public void enter();
    abstract public void clear();
    
    abstract public void down();
    abstract public void up();  
    
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
    
    abstract public void pound();
    public abstract void star();
       

    // add your screens number in List here
    static class ScreenId
    {
        public static final int OPTIONS_MENU = 0;
        public static final int START_SCREEN = 1;
        public static final int MAIN_MENU = 2;
       
        
        // menus
        public static final int CALCULATOR = 3;  
        
    }
}
