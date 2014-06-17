package com.example.screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class StartScreen extends Screen
{
    private ImageView battery_indicator;
    private ImageView signal_indicator;
    private TextView action;
    private TextView clock_view;
    private TextView telephone_number;

    private String action_text;
    private String number_text = "";
    private int phone_number_length = 0;

    private Boolean locked = false;
    private Boolean lock_time_passed = false;
    private Boolean unlock_time_passed = true;
    private Boolean enter_pressed = false;
    
    private Handler handler;
    
    private TextView menu_line_1, menu_line_2;

    public StartScreen(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        // get display elements
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.clock_view = (TextView) nokia_phone.findViewById(R.id.clock_view);
        this.telephone_number = (TextView) nokia_phone.findViewById(R.id.number_input);
        
        this.menu_line_1 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.menu_line_2 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);

        handler = new Handler();     
        
        action_text = "Menu";
    }

    private void digitButton(String digit)
    {
        if (locked)
        {
            this.hide();
            screens.get(ScreenId.POPUP).show();
            handler.removeCallbacks(timer_for_unlocking);
            ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");               
        }
        
        else if (phone_number_length < 20)
        {
            number_text += digit;
            phone_number_length++;
        }
    }

    @Override
    public void update()
    {
        lock_time_passed = false;
            
        if (locked)
            action_text = "Unlock";  
        else if (phone_number_length == 0)
            action_text = "Menu";
        else
            action_text = "Call";
               
        action.setText(action_text);
        telephone_number.setText(number_text);
        
    }

    @Override
    public void show()
    {   
        menu_line_1.setVisibility(View.INVISIBLE);
        menu_line_2.setVisibility(View.INVISIBLE);
        
        if (enter_pressed)
        {
            menu_line_1.setText("  Now");
            menu_line_2.setText("  press *");
            action_text = "Unlock";
            menu_line_1.setVisibility(View.VISIBLE);
            menu_line_2.setVisibility(View.VISIBLE);
            unlock_time_passed = false;
            handler.removeCallbacks(timer_for_unlocking);
            handler.postDelayed(timer_for_unlocking, 2000);
            enter_pressed = false;
        }
        else if (locked)
        {
            action_text = "Unlock";  
            menu_line_1.setText("  Now");
            menu_line_2.setText("  press *");
        }
        else
        {
            action_text = "Menu";   
        }

        action.setText(action_text);
        
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);
        clock_view.setVisibility(View.VISIBLE);
        telephone_number.setVisibility(View.VISIBLE);

        
        nokia_phone.setScreenId(ScreenId.START_SCREEN);
    }

    public void setEnterPressed(Boolean value)
    {
        enter_pressed = value;
    }
    
    
    @Override
    public void hide()
    {
        battery_indicator.setVisibility(View.INVISIBLE);
        signal_indicator.setVisibility(View.INVISIBLE);
        action.setVisibility(View.INVISIBLE);
        clock_view.setVisibility(View.INVISIBLE);
        telephone_number.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        if (locked)
        {      
            menu_line_1.setVisibility(View.VISIBLE);
            menu_line_2.setVisibility(View.VISIBLE);
            unlock_time_passed = false;
            handler.removeCallbacks(timer_for_unlocking);
            handler.postDelayed(timer_for_unlocking, 2000);                           
        }
        
        else if (phone_number_length == 0)
        {
            this.hide();
            
            handler.removeCallbacks(timer_for_locking);
            handler.postDelayed(timer_for_locking, 3000);     
            screens.get(ScreenId.MAIN_MENU).show();
        }
        else
        {
            call(number_text);
        }
    }

    
    public Boolean getLock()
    {
        return locked;
    }

    public Boolean getLockTimePassed()
    {
        return lock_time_passed;
    }
    
    public void setLock(boolean value)
    {
        locked = value;
    }
    
    Runnable timer_for_unlocking = new Runnable()
    {
        @Override
        public void run()
        {
            unlock_time_passed = true;
            menu_line_1.setVisibility(View.INVISIBLE);
            menu_line_2.setVisibility(View.INVISIBLE);
        }
    };
    
    
    Runnable timer_for_locking = new Runnable()
    {
        @Override
        public void run()
        {
            lock_time_passed = true;
        }
    };
    
    @Override
    public void clear()
    {
        if (locked)
        {
            this.hide();
            screens.get(ScreenId.POPUP).show();
            handler.removeCallbacks(timer_for_unlocking);
            ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");               
        }
        
        else if (phone_number_length > 0)
        {
            phone_number_length--;
            number_text = number_text.substring(0, number_text.length() - 1);
        }
    }

    @Override
    public void down()
    {
        if (locked)
        {
            this.hide();
            screens.get(ScreenId.POPUP).show();
            handler.removeCallbacks(timer_for_unlocking);
            ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");                 
        }
        else
        {
          this.hide();
          screens.get(ScreenId.CONTACT_SCREEN).show();
        }
    }

    @Override
    public void up()
    {
        if (locked)
        {
            this.hide();
            screens.get(ScreenId.POPUP).show();
            handler.removeCallbacks(timer_for_unlocking);
            ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");                
        }

    }

    @Override
    public void zero()
    {
        digitButton("0");
    }

    @Override
    public void one()
    {
        digitButton("1");
    }

    @Override
    public void two()
    {
        digitButton("2");
    }

    @Override
    public void three()
    {
        digitButton("3");
    }

    @Override
    public void four()
    {
        digitButton("4");
    }

    @Override
    public void five()
    {
        digitButton("5");
    }

    @Override
    public void six()
    {
        digitButton("6");
    }

    @Override
    public void seven()
    {
        digitButton("7");
    }

    @Override
    public void eight()
    {
        digitButton("8");
    }

    @Override
    public void nine()
    {
        digitButton("9");
    }

    @Override
    public void pound()
    {
        if (locked)
        {
            this.hide();
            screens.get(ScreenId.POPUP).show();
            handler.removeCallbacks(timer_for_unlocking);
            ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");                
        }

    }

    @Override
    public void star()
    {
        if (locked)
        {
            if (unlock_time_passed)
            {
              this.hide();
              screens.get(ScreenId.POPUP).show();
              ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Press", "Unlock", "and then *", "press");    
            }
            else
            {
                handler.removeCallbacks(timer_for_unlocking);
                locked = false;
                this.hide();
                screens.get(ScreenId.POPUP).show();
                ((Popup) screens.get(ScreenId.POPUP)).setPopupText("Keypad", "active", "", "unlocked"); 
                
            }
        }


    }


    private void call(String phone_number)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
        nokia_phone.startActivity(callIntent);
    }

}
