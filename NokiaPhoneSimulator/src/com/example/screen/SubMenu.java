package com.example.screen;

import java.util.Arrays;
import java.util.List;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

//import com.example.nokiaphonesimulator.NokiaPhoneActivity;

public class SubMenu extends Screen
{
    // holding all possible SubMenu contents
    private SparseArray<List<String>> menus;

    private List<String> menu_titles;

    private TextView action;
    private TextView options_menu_titles[];


    private String action_text;

    private int position_end = 2;
    private int position = 0;

    private boolean option_selected = false;

    private int selected_menu;

    public SubMenu(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        // add your menu contents here
        this.menus = new SparseArray<List<String>>();
        this.menus.append(ScreenId.CALCULATOR, Arrays.asList("Equals", "Add", "Substract"));

        action_text = "OK";

        options_menu_titles = new TextView[3];


        this.options_menu_titles[0] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_one);
        this.options_menu_titles[1] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_two);
        this.options_menu_titles[2] = (TextView) nokia_phone.findViewById(R.id.options_menu_title_three);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);

    }

    public void selectMenu(int selected_menu)
    {
        this.selected_menu = selected_menu;

    }


    public int getPosition()
    {
        if (option_selected)
            return position;
        else
            return -1;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }


    @Override
    public void update()
    {
        option_selected = false;
        action.setVisibility(View.VISIBLE);

        for (int i = 0; i < 3; i++)
        {
            options_menu_titles[i].setVisibility(View.VISIBLE);
            options_menu_titles[i].setText(menu_titles.get(i));
            options_menu_titles[i].setBackgroundColor(Color.parseColor("#afc377"));
            options_menu_titles[i].setTextColor(Color.BLACK);
        }

        options_menu_titles[position].setBackgroundColor(Color.BLACK);
        options_menu_titles[position].setTextColor(Color.parseColor("#afc377"));

        action.setText(action_text);

    }

    @Override
    public void show()
    {
        nokia_phone.setScreenId(ScreenId.SUB_MENU);

        this.menu_titles = this.menus.get(selected_menu);

        position = 0;
        position_end = menu_titles.size() - 1;
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.GONE);
        for (int i = 0; i < 3; i++)
        {
            options_menu_titles[i].setVisibility(View.GONE);
        }

        if (!option_selected)
            position = 0;

    }


    @Override
    public void enter()
    {
        option_selected = true;
        this.hide();
        screens.get(selected_menu).show();

    }

    @Override
    public void clear()
    {
        this.hide();
        screens.get(selected_menu).show();

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
