package com.example.nokiaphonesimulator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;

public class Clock extends BroadcastReceiver
{
    private String clock_text;
    private int hour, minute;
    private int hour_offset = 0, minute_offset = 0;
    private TextView clock_view;

    public Clock(TextView clock_view)
    {
        this.clock_view = clock_view;
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0)
        {
            minute++;

            if (minute > 59)
            {
                minute -= 60;
                hour++;
            }

            if (hour > 23)
            {
                hour -= 24;
            }

            clock_text = String.format("%02d", hour) + ":" + String.format("%02d", minute);

            clock_view.setText(clock_text);
            Log.d("Clock", "clock refreshed: " + clock_text);
        }
    }

    public void refresh()
    {
        Time time = new Time();
        time.setToNow();

        // set initial time
        minute = time.minute + minute_offset;
        hour = time.hour + hour_offset;
        
        if (minute > 59)
        {
            minute -= 60;
            hour++;
        }

        if (hour > 23)
        {
            hour -= 24;
        }

        clock_text = String.format("%02d", hour) + ":" + String.format("%02d", minute);
        clock_view.setText(clock_text);

        Log.d("Clock", "clock initialised");
    }

    // set to custom hour
    public void setHourOffset(int hour_offset)
    {
        this.hour_offset = hour_offset;
        
        this.refresh();
    }

    // set to custom minute
    public void setMinuteOffset(int minute_offset)
    {
        this.minute_offset = minute_offset;
        
        this.refresh();
    }
}
