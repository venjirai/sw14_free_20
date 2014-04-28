package com.example.screen;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class StartScreen extends NokiaScreen
{
    private ImageView battery_indicator;
    private ImageView signal_indicator;
    private TextView action;
    private TextView clock_view;

    private String action_text;
    private int phone_number_length = 0;


    public StartScreen(NokiaPhoneActivity nokia_phone)
    {
        super();
        this.nokia_phone = nokia_phone;

        // get display elements
        this.battery_indicator = (ImageView) nokia_phone.findViewById(R.id.battery_indicator);
        this.signal_indicator = (ImageView) nokia_phone.findViewById(R.id.signal_indicator);
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.clock_view = (TextView) nokia_phone.findViewById(R.id.clock_view);

        action_text = "Menu";
    }

    private void digitButton(String digit)
    {
        if (phone_number_length == 0)
            action_text = "";

        if (phone_number_length <= 30)
        {
            action_text += digit;
            phone_number_length++;
        }
    }

    @Override
    public void refresh()
    {
        battery_indicator.setVisibility(View.VISIBLE);
        signal_indicator.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);
        clock_view.setVisibility(View.VISIBLE);

        if (phone_number_length == 0)
            action.setText("Menu");
        else
            action.setText(action_text);
    }

    @Override
    public void hide()
    {
        battery_indicator.setVisibility(View.GONE);
        signal_indicator.setVisibility(View.GONE);
        action.setVisibility(View.GONE);
        clock_view.setVisibility(View.GONE);
    }

    @Override
    public void enter()
    {
        if (phone_number_length == 0)
        {
            this.hide();
            nokia_phone.setScreenId(ScreenId.MAIN_MENU);
        }
        else
        {
            call(action_text);
        }
    }

    @Override
    public void clear()
    {
        if (phone_number_length > 0)
        {
            phone_number_length--;
            action_text = action_text.substring(0, action_text.length() - 1);
        }
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
