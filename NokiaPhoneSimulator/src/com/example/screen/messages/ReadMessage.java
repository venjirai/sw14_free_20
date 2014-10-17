package com.example.screen.messages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import at.paul.nokiaphonesimulator.R;
import com.example.nokiaphonesimulator.Sms;
import com.example.screen.Screen;

public class ReadMessage extends Screen
{

    private TextView action;
    private TextView output;

    private ScrollView output_scroll;
    private int scroll_cursor = 0;

    private ArrayList<Sms> sms_box;

    private int sms_cursor;
    private int box_cursor;
    private int content_cursor;
    
    private String sms_action;

    public static final int INBOX = 0;
    public static final int OUTBOX = 1;

    public ReadMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.output = (TextView) nokia_phone.findViewById(R.id.text_output);
        this.output_scroll = (ScrollView) nokia_phone.findViewById(R.id.text_io_scroll);
    }

    public void setCursor(int cursor, int box_cursor)
    {
        this.sms_cursor = cursor;
        this.box_cursor = box_cursor;

        switch (box_cursor)
        {
            case INBOX:
                sms_action = "Sender";
                this.sms_box = nokia_phone.getIntent().getParcelableArrayListExtra("sms_inbox");
                break;
            case OUTBOX:
                sms_action = "Receiver";
                this.sms_box = nokia_phone.getIntent().getParcelableArrayListExtra("sms_sent");
                break;
        }
    }

    @Override
    public void update()
    {
        switch (content_cursor)
        {
            case 0:
                output.setText(sms_box.get(sms_cursor).getBody());
                output_scroll.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        int y = output.getLayout().getLineTop(scroll_cursor);
                        output_scroll.scrollTo(0, y);
                    }
                });
                break;
            case 1:
                if (sms_box.get(sms_cursor).getAddress() != sms_box.get(sms_cursor).getContact())
                    output.setText(sms_action + ":\n" + sms_box.get(sms_cursor).getContact() + "\n" + sms_box.get(sms_cursor).getAddress());
                else
                    output.setText(sms_action + ":\n" + sms_box.get(sms_cursor).getAddress());
                break;
            case 2:
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy\nhh:mm:ss");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(Long.valueOf(sms_box.get(sms_cursor).getDate()));
                output.setText("Sent:\n" + formatter.format(calendar.getTime()));
                break;
        }        
    }

    @Override
    public void show()
    {
        action.setText("Options");
        
        scroll_cursor = 0;
        content_cursor = 0;

        action.setVisibility(View.VISIBLE);
        output.setVisibility(View.VISIBLE);

        nokia_phone.setScreenId(ScreenId.READ_MESSAGE);
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
        switch (box_cursor)
        {
            case INBOX:
                this.hide();
                screens.get(ScreenId.MESSAGES_INBOX).show();
                break;
            case OUTBOX:
                this.hide();
                screens.get(ScreenId.MESSAGES_OUTBOX).show();
                break;
        }
    }

    @Override
    public void down()
    {
        if (content_cursor == 0)
        {
            scroll_cursor += 4;
            if (scroll_cursor > output.getLineCount())
            {
                scroll_cursor = 0;
                content_cursor = 1;
            }
        }
        else if (content_cursor == 1)
        {
            content_cursor = 2;
        }
        else if (content_cursor == 2)
        {
            content_cursor = 0;
        }

    }

    @Override
    public void up()
    {
        if (content_cursor == 0)
        {
            scroll_cursor -= 4;
            if (scroll_cursor < 0)
            {
                scroll_cursor = 0;
                while(scroll_cursor < output.getLineCount())
                    scroll_cursor += 4;
                scroll_cursor -= 4;
                content_cursor = 2;
            }
        }
        else if (content_cursor == 2)
        {
            content_cursor = 1;
        }
        else if (content_cursor == 1)
        {
            content_cursor = 0;
        }
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
