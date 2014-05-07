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
    private String operator;
    private int option_selected;
    private List<String> menu_options;
    private String[] number_string;
    private float[] number;
    private int index = 0;
        
    public Calculator(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);
        
        number_string = new String[2];
        number = new float[2];

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.input = (TextView) nokia_phone.findViewById(R.id.input);
        
        action_text = "Options";
        number_string[0] = "0";
        number_string[1] = "";
        operator = "NONE_SELECTED";

    }

    @Override
    public void update()
    {
        option_selected = ((CalculatorMenu) screens.get(ScreenId.CALCULATOR_MENU)).getOptionSelected();
        ((CalculatorMenu) screens.get(ScreenId.CALCULATOR_MENU)).setOptionSelected(-1);
        
        switch (option_selected)
        {
            case 0:
                operator = "=";
                break;
            case 1:
                operator = "+";
                number_string[index] += "\n+\n";
                break;
            case 2:
                operator = "-";
                break;
        }

        input.setText(number_string[index]);
        action.setText(action_text);
    }

    @Override
    public void show()
    {
        input.setVisibility(View.VISIBLE);
        action.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.CALCULATOR);
    }

    @Override
    public void hide()
    {
        input.setVisibility(View.INVISIBLE);
        action.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        this.hide();
        screens.get(ScreenId.CALCULATOR_MENU).show();
    }

    @Override
    public void clear()
    {
        if (number_string[index] != "0")
        {
            number_string[index] = number_string[index].substring(0, number_string[index].length() - 1);
            if (index == 0 && number_string[index].length() == 0)
                number_string[index] = "0";
            
        }
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
        if (number_string[index].length() < 9)
        {       
          if (number_string[index] != "0")
              number_string[index] += digit;
          else
              number_string[index] = digit;
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


    }

    @Override
    public void star()
    {


    }

}
