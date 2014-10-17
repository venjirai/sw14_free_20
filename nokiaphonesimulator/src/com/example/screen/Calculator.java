package com.example.screen;


import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import at.paul.nokiaphonesimulator.R;

public class Calculator extends Screen
{

    private TextView action;
    private TextView input;
    private String action_text;
    private char operator = 0;
    private int option_selected;
    private char mode = 0;
    
    private float result;
    
    private String input_text = "";
    private String operator_string = "";
    
    private Boolean additional_calculations = false;
    
    private String[] number_string;
    private float[] number;
        
    public Calculator(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);     
        number = new float[2];
        number_string = new String[2];       
        number_string[0] = "0";
        number_string[1] = "";       
        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.input = (TextView) nokia_phone.findViewById(R.id.input);       
        input_text = "0";
        action_text = "Options";       
    }

    @Override
    public void update()
    {
        option_selected = ((CalculatorMenu) screens.get(ScreenId.CALCULATOR_MENU)).getOptionSelected();
        ((CalculatorMenu) screens.get(ScreenId.CALCULATOR_MENU)).setOptionSelected(-1);
        
        switch (option_selected)
        {
            case 0:
                if (mode == 2)
                {
                   number[0] = Float.valueOf(number_string[0]);
                   number[1] = Float.valueOf(number_string[1]);  
                   result = getResult(number[0], number[1], operator);
                   mode = 3;
                }
                break;
            case 1:
                if (mode == 0)
                {
                    operator = '+';
                    operator_string = "\n" + operator;  
                    mode = 1;
                }
                else if (mode == 2)
                {
                    number[0] = Float.valueOf(number_string[0]);
                    number[1] = Float.valueOf(number_string[1]);  
                    result = getResult(number[0], number[1], operator);    
                    operator = '+';
                    additional_calculations = true;
                    mode = 3;                   
                }
                
                break;
            case 2:
                if (mode == 0)
                {
                    operator = '-';
                    operator_string = "\n" + operator;  
                    mode = 1;
                }
                else if (mode == 2)
                {
                    number[0] = Float.valueOf(number_string[0]);
                    number[1] = Float.valueOf(number_string[1]);                   
                    result = getResult(number[0], number[1], operator);                  
                    operator = '-';
                    additional_calculations = true;                 
                    mode = 3;                   
                }
                break;
            case 3:
                if (mode == 0)
                {
                    operator = '*';
                    operator_string = "\n" + operator;  
                    mode = 1;
                }
                else if (mode == 2)
                {
                    number[0] = Float.valueOf(number_string[0]);
                    number[1] = Float.valueOf(number_string[1]);
                    result = getResult(number[0], number[1], operator);    
                    operator = '*';
                    additional_calculations = true;
                    mode = 3;                   
                }
                break;
            case 4:
                if (mode == 0)
                {
                    operator = '/';
                    operator_string = "\n" + operator;  
                    mode = 1;
                }
                else if (mode == 2)
                {
                    number[0] = Float.valueOf(number_string[0]);
                    number[1] = Float.valueOf(number_string[1]);        
                    result = getResult(number[0], number[1], operator);    
                    operator = '/';              
                    additional_calculations = true;
                    mode = 3;                   
                }
                break;                               
        }
        
        
        if (mode == 3)
        {       
            number_string[0] = String.valueOf(result);
            
            if (result % 1 == 0)
                number_string[0] = number_string[0].substring(0, number_string[0].length() - 2);  
            
            number_string[1] = "";
            operator_string = "";
            
            if (additional_calculations)
            {
                additional_calculations = false;
                operator_string = "\n" + operator;
                mode = 1;
            }
            else                
                mode = 0;
        }
        
        
        input_text = number_string[0] + operator_string + number_string[1];
        
        input.setText(input_text);        
        action.setText(action_text);
        
    }

    
    float getResult(float number_1, float number_2, char operator)
    {
        float result = 0;
        switch (operator)
        {
            case '+':
                result = number_1 + number_2;
                break;
            case '-':
                result = number_1 - number_2;
                break;
            case '*':
                result = number_1 * number_2;
                break;
            case '/':
                result = number_1 / number_2;
                break;
        }              
        return result;
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
        switch (mode)
        {
            case 0:
                if (number_string[0].length() > 1)
                {
                    number_string[0] = number_string[0].substring(0, number_string[0].length() - 1);                      
                }                  
                else if (number_string[0] == "0")
                {
                    this.hide();
                    screens.get(ScreenId.MAIN_MENU).show();
                }            
                else if (number_string[0].length() == 1)
                {
                    number_string[0] = "0";
                }   
                break;     
                
            case 1:
                operator_string = "";               
                mode = 0;
                break;
                
            case 2:
                if (number_string[1].length() > 1)
                {
                    number_string[1] = number_string[1].substring(0, number_string[1].length() - 1);                      
                }                  
                else
                {
                    mode = 1;
                    operator_string = operator_string.substring(0, operator_string.length() - 1); 
                    number_string[1] = number_string[1].substring(0, number_string[1].length() - 1); 
                }            

                break;     
                
            case 3:
                mode = 0; 
                break;
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
        switch (mode)
        {
            case 0:
                if (number_string[0].length() < 9)
                {
                  if (number_string[0] == "0")
                      number_string[0] = digit;
                  else
                      number_string[0] += digit;
                }   
                break;
            case 1:
                mode = 2;
                operator_string += "\n";
                number_string[1] = digit;
                break;          
            case 2:
                if (number_string[1].length() < 9)
                {
                  if (number_string[1] == "0")
                      number_string[1] = digit;
                  else
                      number_string[1] += digit;
                }   
                break;           
                
            case 3:
                number_string[0] = digit;
                break;
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
