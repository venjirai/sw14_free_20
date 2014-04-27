package com.example.nokiaphonesimulator;

import android.os.Handler;
import android.text.format.Time;
import android.util.Log;
import android.widget.TextView;

public class Clock
{
    private String clock_text;
    private int hour, minute;

    private Handler clock_handler;

    public Clock(final TextView clock_view)
    {
        Time time = new Time();
        time.setToNow();

        // set initial time
        minute = time.minute;
        hour = time.hour;

        clock_text = String.format("%02d", hour) + ":" + String.format("%02d", minute);
        clock_view.setText(clock_text);

        clock_handler = new Handler();
        clock_handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
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

                clock_handler.postDelayed(this, 60000); // sync every 60 seconds
            }
        }, (60 - time.second) * 1000); // start sync with next minute
    }

    // set to custom hour
    public void setHourOffset(int offset)
    {
        hour += offset;
    }

    // set to custom minute
    public void setMinuteOffset(int offset)
    {
        minute += offset;
    }

}
