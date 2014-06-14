package com.example.screen.messages;

import android.view.View;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.screen.Screen;

public class WriteMessage extends Screen
{

    private TextView action;
    private TextView output;

    private String message;

    private int writing = -1;
    private int pressed_count = 0;

    private int wait_time = 1500;

    private boolean lower_case = true;

    public WriteMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.output = (TextView) nokia_phone.findViewById(R.id.text_output);
    }

    @Override
    public void update()
    {
        output.setText(message);
    }

    @Override
    public void show()
    {
        message = "";
        writing = -1;
        pressed_count = 0;

        action.setText("Send");

        action.setVisibility(View.VISIBLE);
        output.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.WRITE_MESSAGE);
    }

    @Override
    public void hide()
    {
        action.setVisibility(View.INVISIBLE);
        output.setVisibility(View.INVISIBLE);
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

    Runnable btn_reset = new Runnable()
    {
        @Override
        public void run()
        {
            writing = -1;
        }
    };

    @Override
    public void zero()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void one()
    {
        if (writing != 1)
        {
            writing = 1;
            pressed_count = 1;
            message = message + '.';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    message = message.substring(0, message.length() - 1) + '.';
                    break;
                case 2:
                    message = message.substring(0, message.length() - 1) + ',';
                    break;
                case 3:
                    message = message.substring(0, message.length() - 1) + "'";
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '?';
                    break;
                case 5:
                    message = message.substring(0, message.length() - 1) + '!';
                    break;
                case 6:
                    message = message.substring(0, message.length() - 1) + '-';
                    break;
                case 7:
                    message = message.substring(0, message.length() - 1) + '&';
                    break;
                case 8:
                    message = message.substring(0, message.length() - 1) + '1';
                    break;
                case 9:
                    message = message.substring(0, message.length() - 1) + '@';
                    break;
                case 10:
                    message = message.substring(0, message.length() - 1) + '/';
                    pressed_count = 0;
                    break;
                default:
                    break;
            }
        }

        // restart reset timer
        output.removeCallbacks(btn_reset);
        output.postDelayed(btn_reset, wait_time);
    }

    @Override
    public void two()
    {
        if (writing != 2)
        {
            writing = 2;
            pressed_count = 1;

            if (lower_case)
                message = message + 'a';
            else
                message = message + 'A';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'a';
                    else
                        message = message.substring(0, message.length() - 1) + 'A';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'b';
                    else
                        message = message.substring(0, message.length() - 1) + 'B';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'c';
                    else
                        message = message.substring(0, message.length() - 1) + 'C';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '2';
                    pressed_count = 0;
                    break;
                default:
                    break;
            }
        }

        // restart reset timer
        output.removeCallbacks(btn_reset);
        output.postDelayed(btn_reset, wait_time);
    }

    @Override
    public void three()
    {
        if (writing != 3)
        {
            writing = 3;
            pressed_count = 1;

            if (lower_case)
                message = message + 'd';
            else
                message = message + 'D';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'd';
                    else
                        message = message.substring(0, message.length() - 1) + 'D';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'e';
                    else
                        message = message.substring(0, message.length() - 1) + 'E';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'f';
                    else
                        message = message.substring(0, message.length() - 1) + 'F';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '3';
                    pressed_count = 0;
                    break;
                default:
                    break;
            }
        }

        // restart reset timer
        output.removeCallbacks(btn_reset);
        output.postDelayed(btn_reset, wait_time);
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
        if (lower_case = true)
            lower_case = false;
        else
            lower_case = true;
    }

    @Override
    public void star()
    {
        // TODO Auto-generated method stub

    }

}
