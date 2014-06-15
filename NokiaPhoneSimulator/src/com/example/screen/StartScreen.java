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
    
    private Handler handler;

    public StartScreen(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        // get display elements
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.clock_view = (TextView) nokia_phone.findViewById(R.id.clock_view);
        this.telephone_number = (TextView) nokia_phone.findViewById(R.id.number_input);

        handler = new Handler();
        
        action_text = "Menu";
    }

    private void digitButton(String digit)
    {
        if (phone_number_length < 20)
        {
            number_text += digit;
            phone_number_length++;
        }
    }

    @Override
    public void update()
    {
        if (phone_number_length == 0)
            action_text = "Menu";
        else
            action_text = "Call";
        
        action.setText(action_text);
        telephone_number.setText(number_text);
    }

    @Override
    public void show()
    {
        lock_time_passed = false;
        
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);
        clock_view.setVisibility(View.VISIBLE);
        telephone_number.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.START_SCREEN);
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
        if (phone_number_length == 0)
        {
            this.hide();
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable, 3000);     
            screens.get(ScreenId.MAIN_MENU).show();
        }
        else
        {
            call(number_text);
        }
    }


    public Boolean getLockTimePassed()
    {
        return lock_time_passed;
    }
    
    
    Runnable runnable = new Runnable()
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
        if (phone_number_length > 0)
        {
            phone_number_length--;
            number_text = number_text.substring(0, number_text.length() - 1);
        }
    }

    @Override
    public void down()
    {
        this.hide();
        screens.get(ScreenId.CONTACT_SCREEN).show();
    }

    @Override
    public void up()
    {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

    @Override
    public void star()
    {
        // TODO Auto-generated method stub

    }


    private void call(String phone_number)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone_number));
        nokia_phone.startActivity(callIntent);
    }

}
