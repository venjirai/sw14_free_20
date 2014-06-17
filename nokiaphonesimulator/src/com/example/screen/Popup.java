package com.example.screen;



import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen.ScreenId;

public class Popup extends Screen
{
    private TextView popup_line_1;
    private TextView popup_line_2;
    private TextView popup_line_3;
    private Handler handler;

    private String picture;
    
    private ImageView locked;
    private ImageView unlocked;
    private ImageView press;
    
    public Popup(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);               
        this.popup_line_1 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_one);
        this.popup_line_2 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_two);
        this.popup_line_3 = (TextView) nokia_phone.findViewById(R.id.sub_menu_title_three);
        
        unlocked = (ImageView) nokia_phone.findViewById(R.id.unlocked);
        locked = (ImageView) nokia_phone.findViewById(R.id.locked);
        press = (ImageView) nokia_phone.findViewById(R.id.press);
        
        unlocked.setVisibility(View.INVISIBLE);
        locked.setVisibility(View.INVISIBLE);
        press.setVisibility(View.INVISIBLE);
        
        handler = new Handler();    
    }
    
    
    public void setPopupText(String line_1, String line_2, String line_3, String picture)  
    {
        if (picture == "unlocked")
            unlocked.setVisibility(View.VISIBLE);
        else if (picture == "locked")
            locked.setVisibility(View.VISIBLE);
        else
            press.setVisibility(View.VISIBLE);
        
        popup_line_1.setText(line_1);
        popup_line_2.setText(line_2); 
        popup_line_3.setText(line_3);
    }
    
    
    Runnable runnable = new Runnable()
    {
        @Override
        public void run()
        {
            locked.setVisibility(View.INVISIBLE);
            unlocked.setVisibility(View.INVISIBLE);
            press.setVisibility(View.INVISIBLE);
            popup_line_1.setVisibility(View.INVISIBLE);
            popup_line_2.setVisibility(View.INVISIBLE);
            popup_line_3.setVisibility(View.INVISIBLE);
            screens.get(ScreenId.START_SCREEN).show();         
        }
    };


    @Override
    public void update()
    {
       
    }

    @Override
    public void show()
    {
        popup_line_1.setVisibility(View.VISIBLE);
        popup_line_2.setVisibility(View.VISIBLE);
        popup_line_3.setVisibility(View.VISIBLE);   
        nokia_phone.setScreenId(ScreenId.POPUP);      
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 2000);  
    }

    @Override
    public void hide()
    {
        unlocked.setVisibility(View.INVISIBLE);
        locked.setVisibility(View.INVISIBLE);
        press.setVisibility(View.INVISIBLE);
        
        popup_line_1.setVisibility(View.INVISIBLE);
        popup_line_2.setVisibility(View.INVISIBLE);
        popup_line_3.setVisibility(View.INVISIBLE);
    }

    @Override
    public void enter()
    {
        if (((StartScreen) screens.get(ScreenId.START_SCREEN)).getLock())
        {
        
          handler.removeCallbacks(runnable);
          this.hide();
          
          ((StartScreen) screens.get(ScreenId.START_SCREEN)).setEnterPressed(true);
          screens.get(ScreenId.START_SCREEN).show();
        }
    }

    @Override
    public void clear()
    {

    }

    @Override
    public void down()
    {

    }


    @Override
    public void up()
    {

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


    }


}
