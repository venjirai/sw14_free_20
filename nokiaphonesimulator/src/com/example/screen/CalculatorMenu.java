package com.example.screen;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class CalculatorMenu extends Screen
{
    private String action_text;
    
    private TextView menu_textview[];
    private TextView action_textview;
    
    private List<String> menu_title;
    
    private int position = 0;
    private int position_end;
    
    public CalculatorMenu(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);
  
        action_text = "OK";
   
        menu_title = new ArrayList<String>();
        menu_title.add("Equals");
        menu_title.add("Add");
        menu_title.add("Substract");
        menu_title.add("Multiply");
        menu_title.add("Divide");
        position_end = menu_title.size() - 1;      
            
        menu_textview = new TextView[3];
        this.menu_textview[0] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.menu_textview[1] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);
        this.menu_textview[2] = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_three);
        
        action_textview = (TextView) nokia_phone.findViewById(R.id.action);
    }



    @Override
    public void update()
    {
        action_textview.setVisibility(View.VISIBLE);
        
        
        
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setVisibility(View.VISIBLE);
            menu_textview[i].setText(menu_title.get((position + i) % position_end + i));
            menu_textview[i].setBackgroundColor(Color.TRANSPARENT);
            menu_textview[i].setTextColor(Color.parseColor("#2C2328"));
        }

        
        //menu_textview[position].setBackgroundColor(Color.parseColor("#2C2328"));
        //menu_textview[position].setTextColor(Color.parseColor("#afc377"));

        action_textview.setText(action_text);
        
    }
    
    @Override
    public void show()
    {
        nokia_phone.setScreenId(ScreenId.CALCULATOR_MENU);
        
    }
    
    @Override
    public void hide()
    {
        action_textview.setVisibility(View.INVISIBLE);
        for (int i = 0; i < 3; i++)
        {
            menu_textview[i].setVisibility(View.INVISIBLE);
            menu_textview[i].setBackgroundColor(Color.TRANSPARENT);
            menu_textview[i].setTextColor(Color.parseColor("#2C2328"));
        }       
    }
    
    @Override
    public void enter()
    {
        this.hide();  
        screens.get(ScreenId.CALCULATOR).show();
    }
    
    @Override
    public void clear()
    {
        this.hide();  
        screens.get(ScreenId.CALCULATOR).show();        
    }
    
    @Override
    public void up()
    {
        position--;
        if (position < 0)
            position = position_end;
    }

    @Override
    public void down()
    {
        position++;
        if (position > position_end)
            position = 0;

    }
    
    @Override
    public void zero()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void one()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void two()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void three()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void four()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void five()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void six()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void seven()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void eight()
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void nine()
    {
        // TODO Auto-generated method stub
        
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

}