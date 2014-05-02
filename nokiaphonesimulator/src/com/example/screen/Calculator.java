package com.example.screen;

import java.util.List;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class Calculator extends Screen
{

    private TextView action;
    private TextView input;
    private String action_text;
    private String input_text;

    private int number_one = 0, number_two;
    private String operator;

    private int option_selected;
    private List<String> menu_options;

    public Calculator(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.input = (TextView) nokia_phone.findViewById(R.id.input);
        action_text = "Options";
        input_text = "0";

    }

    @Override
    public void update()
    {
        option_selected = ((SubMenu) screens.get(ScreenId.SUB_MENU)).getPosition();
        ((SubMenu) screens.get(ScreenId.SUB_MENU)).setPosition(0);

        switch (option_selected)
        {
            case 0:
                operator = "=";
                break;
            case 1:
                operator = "+";
                break;
            case 2:
                operator = "-";
                break;
        }

        input.setText(input_text);
        action.setText(action_text);
    }

    @Override
    public void show()
    {
        input.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.CALCULATOR);

        ((SubMenu) screens.get(ScreenId.SUB_MENU)).selectMenu(ScreenId.CALCULATOR);
    }

    @Override
    public void hide()
    {
        input.setVisibility(View.GONE);
        action.setVisibility(View.GONE);
    }

    @Override
    public void enter()
    {
        this.hide();
        screens.get(ScreenId.SUB_MENU).show();
    }

    @Override
    public void clear()
    {
        if (input_text != "0")
            input_text = "0";
        else
        {
            this.hide();
            screens.get(ScreenId.MAIN_MENU).show();
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


    private void digitButton(String digit)
    {
        if (input_text != "0")
            input_text += digit;
        else
            input_text = digit;
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


    }

    @Override
    public void star()
    {


    }

}