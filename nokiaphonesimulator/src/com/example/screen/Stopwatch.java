package com.example.screen;


import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen.ScreenId;

public class Stopwatch extends Screen
{

    private TextView action;
    private TextView time;
    private String action_text;
    
    private String time_text;
    
    private Boolean stopwatch_running = false;
    private Boolean was_running = false;
    private int intervall_ms = 50;
    private int decisecond_increase;
    private Boolean exiting = false;
    
    private int deciseconds = 0;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    
    private int option_selected;
   
    private Handler handler;

      
    public Stopwatch(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);     
    
        decisecond_increase = intervall_ms / 10;
        handler = new Handler();
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.time = (TextView) nokia_phone.findViewById(R.id.stopwatch);       
        action_text = "Start";       
    }

    @Override
    public void update()
    {
        option_selected = ((StopwatchMenu) screens.get(ScreenId.STOPWATCH_MENU)).getOptionSelected();
        ((StopwatchMenu) screens.get(ScreenId.STOPWATCH_MENU)).setOptionSelected(-1);       
        
        switch (option_selected)
        {
            case 0:
                stopwatch_running = true;  
                was_running = true;
                handler.postDelayed(timer, intervall_ms);  
                break;
            case 1:
                was_running = false;
                deciseconds = 0;
                seconds = 0;
                minutes = 0;
                hours = 0;
                break;
            case 2:
                this.hide();
                exiting = true;
                screens.get(ScreenId.START_SCREEN).show();
                break;
                            
        }
        
        if (!exiting)
        {                                           
          updateStopwatch();
          
          if (stopwatch_running)
              action_text = "Stop";
          else if (!stopwatch_running & was_running)
              action_text = "Options";
          else
              action_text = "Start";
                       
          action.setText(action_text);
        }
        
    }
    
    public void updateStopwatch()
    {
        time_text = 
                hours + ":" + 
                String.format("%02d", minutes) + 
                ":" + String.format("%02d", seconds) + 
                "." + String.format("%02d", deciseconds); 
        
        time.setText(time_text);  
    }
    

    Runnable timer = new Runnable()
    {
        @Override
        public void run()
        {      
            handler.postDelayed(timer, intervall_ms);            
                      
            deciseconds += decisecond_increase;
            if (deciseconds >= 100)
            {               
                deciseconds = 0;
                seconds++;
                if (seconds >= 60)
                {
                    seconds = 0;
                    minutes++;
                    if (minutes >= 60)
                    {
                        minutes = 0;
                        hours++;                      
                    }                   
                }               
            } 
            
            updateStopwatch();          
        }
    };
    
    @Override
    public void show()
    {
        exiting = false;
        time.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.STOPWATCH);
    }

    @Override
    public void hide()
    {
        time.setVisibility(View.INVISIBLE);
        action.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        if (stopwatch_running)
        {
          stopwatch_running = false;  
          handler.removeCallbacks(timer);
            
        }
        else if (!stopwatch_running & was_running)
        {
            this.hide();
            screens.get(ScreenId.STOPWATCH_MENU).show();
        }
        else
        {        
            stopwatch_running = true;  
            was_running = true;
            handler.postDelayed(timer, intervall_ms);  
        }
    }

    @Override
    public void clear()
    {
        this.hide();
        screens.get(ScreenId.CLOCK_MENU).show();  
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
    public void zero()
    {

    }

    @Override
    public void one()
    {

    }

    @Override
    public void two()
    {

    }

    @Override
    public void three()
    {

    }

    @Override
    public void four()
    {

    }

    @Override
    public void five()
    {

    }

    @Override
    public void six()
    {

    }

    @Override
    public void seven()
    {

    }

    @Override
    public void eight()
    {

    }

    @Override
    public void nine()
    {

    }

    @Override
    public void pound()
    {


    }

    @Override
    public void star()
    {


    }

}
