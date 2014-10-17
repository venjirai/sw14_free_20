package com.example.screen.messages;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import at.paul.nokiaphonesimulator.R;
import com.example.screen.Screen;

public class WriteMessage extends Screen
{

    private TextView action;
    private TextView output;
    
    private ScrollView output_scroll;

    private String message = "";

    private int writing;
    private int pressed_count;
    private int scroll_cursor = 0;

    private int wait_time = 1500;

    private boolean lower_case = true;

    public WriteMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.output = (TextView) nokia_phone.findViewById(R.id.text_output);
        this.output_scroll = (ScrollView) nokia_phone.findViewById(R.id.text_io_scroll);
    }

    String getMessage()
    {
        return message;
    }
    
    void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public void update()
    {
        output.setText(message);
        scroll_cursor = output.getLineCount();
        if(scroll_cursor > 4)
            scroll_cursor -= 4;
        else
            scroll_cursor = 0;
        
        output_scroll.post(new Runnable()
        {
            @Override
            public void run()
            {
                int y = output.getLayout().getLineTop(scroll_cursor);
                output_scroll.scrollTo(0, y);
            }
        });
    }

    @Override
    public void show()
    {
        writing = -1;

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
        if (message != "")
        {
            this.hide();
            screens.get(ScreenId.SEND_MESSAGE).show();
        }
    }

    @Override
    public void clear()
    {
        if (message == "")
        {
            this.hide();
            screens.get(ScreenId.MESSAGES_MENU).show();
        }
        else
        {
            if (message.length() > 1)
                message = message.substring(0, message.length() - 1);
            else
                message = "";
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
        if (writing != 0)
        {
            writing = 0;
            pressed_count = 1;
            message = message + ' ';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    message = message.substring(0, message.length() - 1) + ' ';
                    break;
                case 2:
                    message = message.substring(0, message.length() - 1) + '0';
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
        if (writing != 4)
        {
            writing = 4;
            pressed_count = 1;

            if (lower_case)
                message = message + 'g';
            else
                message = message + 'G';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'g';
                    else
                        message = message.substring(0, message.length() - 1) + 'G';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'h';
                    else
                        message = message.substring(0, message.length() - 1) + 'H';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'i';
                    else
                        message = message.substring(0, message.length() - 1) + 'I';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '4';
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
    public void five()
    {
        if (writing != 5)
        {
            writing = 5;
            pressed_count = 1;

            if (lower_case)
                message = message + 'j';
            else
                message = message + 'J';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'j';
                    else
                        message = message.substring(0, message.length() - 1) + 'J';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'k';
                    else
                        message = message.substring(0, message.length() - 1) + 'K';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'l';
                    else
                        message = message.substring(0, message.length() - 1) + 'L';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '5';
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
    public void six()
    {
        if (writing != 6)
        {
            writing = 6;
            pressed_count = 1;

            if (lower_case)
                message = message + 'm';
            else
                message = message + 'M';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'm';
                    else
                        message = message.substring(0, message.length() - 1) + 'M';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'n';
                    else
                        message = message.substring(0, message.length() - 1) + 'N';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'o';
                    else
                        message = message.substring(0, message.length() - 1) + 'O';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '6';
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
    public void seven()
    {
        if (writing != 7)
        {
            writing = 7;
            pressed_count = 1;

            if (lower_case)
                message = message + 'p';
            else
                message = message + 'P';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'p';
                    else
                        message = message.substring(0, message.length() - 1) + 'P';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'q';
                    else
                        message = message.substring(0, message.length() - 1) + 'Q';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'r';
                    else
                        message = message.substring(0, message.length() - 1) + 'R';
                    break;
                case 4:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 's';
                    else
                        message = message.substring(0, message.length() - 1) + 'S';
                    break;
                case 5:
                    message = message.substring(0, message.length() - 1) + '7';
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
    public void eight()
    {
        if (writing != 8)
        {
            writing = 8;
            pressed_count = 1;

            if (lower_case)
                message = message + 't';
            else
                message = message + 'T';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 't';
                    else
                        message = message.substring(0, message.length() - 1) + 'T';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'u';
                    else
                        message = message.substring(0, message.length() - 1) + 'U';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'v';
                    else
                        message = message.substring(0, message.length() - 1) + 'V';
                    break;
                case 4:
                    message = message.substring(0, message.length() - 1) + '8';
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
    public void nine()
    {
        if (writing != 9)
        {
            writing = 9;
            pressed_count = 1;

            if (lower_case)
                message = message + 'w';
            else
                message = message + 'W';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'w';
                    else
                        message = message.substring(0, message.length() - 1) + 'W';
                    break;
                case 2:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'x';
                    else
                        message = message.substring(0, message.length() - 1) + 'X';
                    break;
                case 3:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'y';
                    else
                        message = message.substring(0, message.length() - 1) + 'Y';
                    break;
                case 4:
                    if (lower_case)
                        message = message.substring(0, message.length() - 1) + 'z';
                    else
                        message = message.substring(0, message.length() - 1) + 'Z';
                    break;
                case 5:
                    message = message.substring(0, message.length() - 1) + '9';
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
    public void pound()
    {
        if (lower_case)
            lower_case = false;
        else
            lower_case = true;
    }

    @Override
    public void star()
    {
        if (writing != 10)
        {
            writing = 10;
            pressed_count = 1;

            message = message + '+';
        }
        else
        {
            pressed_count++;

            switch (pressed_count)
            {
                case 1:
                    message = message.substring(0, message.length() - 1) + '+';
                    break;
                case 2:
                    message = message.substring(0, message.length() - 1) + '*';
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

}
