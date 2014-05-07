package com.example.screen.messages;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen;

public class WriteMessage extends Screen
{
    
    TextView action;

    public WriteMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
    }

    @Override
    public void update()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void show()
    {
        action.setText("Options");
        
        action.setVisibility(View.VISIBLE);
        
        nokia_phone.setScreenId(ScreenId.WRITE_MESSAGE);        
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.INVISIBLE);        
    }

    @Override
    public void enter()
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear()
    {
        this.hide();
        screens.get(ScreenId.MESSAGES_MENU).show();
        
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
