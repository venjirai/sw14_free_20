package com.example.screen;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;

public class ReadMessage extends Screen
{
    
    private TextView action;
    private TextView output;
    
    private String text;

    public ReadMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.output = (TextView) nokia_phone.findViewById(R.id.text_io);
    }
    
    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public void update()
    {
        output.setText(text);
    }

    @Override
    public void show()
    {
        action.setVisibility(View.VISIBLE);
        output.setVisibility(View.VISIBLE);
        
        nokia_phone.setScreenId(ScreenId.READ_MESSAGE);
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.GONE);
        output.setVisibility(View.GONE);
        
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
        screens.get(ScreenId.MESSAGES_INBOX).show();
        
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
