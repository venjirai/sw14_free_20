package com.example.screen.messages;

import java.util.ArrayList;

import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.nokiaphonesimulator.NokiaPhoneActivity;
import com.example.nokiaphonesimulator.R;
import com.example.nokiaphonesimulator.Sms;
import com.example.screen.Screen;

public class ReadMessage extends Screen
{

    private TextView action;
    private TextView output;

    private ScrollView output_scroll;
    private int cursor_scroll = 0;

    private ArrayList<Sms> sms_inbox;
    private ArrayList<Sms> sms_outbox;

    private int cursor;
    private int cursor_content;

    public static final int INBOX = 0;
    public static final int OUTBOX = 1;

    public ReadMessage(NokiaPhoneActivity nokia_phone)
    {
        super(nokia_phone);

        this.sms_inbox = nokia_phone.getIntent().getParcelableArrayListExtra("sms_inbox");
        this.sms_outbox = nokia_phone.getIntent().getParcelableArrayListExtra("sms_sent");

        this.action = (TextView) nokia_phone.findViewById(R.id.action);
        this.output = (TextView) nokia_phone.findViewById(R.id.text_output);
        this.output_scroll = (ScrollView) nokia_phone.findViewById(R.id.text_io_scroll);
    }

    public void setCursor(int cursor, int cursor_content)
    {
        this.cursor = cursor;
        this.cursor_content = cursor_content;
    }

    @Override
    public void update()
    {
        action.setText("Options");

        switch (cursor_content)
        {
            case INBOX:
                output.setText(sms_inbox.get(cursor).getBody());
                break;
            case OUTBOX:
                output.setText(sms_outbox.get(cursor).getBody());
                break;
        }

        output_scroll.post(new Runnable()
        {
            @Override
            public void run()
            {
                int y = output.getLayout().getLineTop(cursor_scroll);
                output_scroll.scrollTo(0, y);
            }
        });
    }

    @Override
    public void show()
    {
        cursor_scroll = 0;

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
        switch (cursor_content)
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
        cursor_scroll += 4;
        if (cursor_scroll > output.getLineCount())
            cursor_scroll -= 4;

    }

    @Override
    public void up()
    {
        cursor_scroll -= 4;
        if (cursor_scroll < 0)
            cursor_scroll += 4;

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
