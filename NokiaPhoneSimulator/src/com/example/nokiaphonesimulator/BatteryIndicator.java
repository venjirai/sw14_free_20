package com.example.nokiaphonesimulator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.ImageView;
import at.paul.nokiaphonesimulator.R;

public class BatteryIndicator extends BroadcastReceiver
{
    private ImageView battery_indicator;
    private int level = -1;
    private boolean charging = false;

    public BatteryIndicator(NokiaPhoneActivity nokia_phone_activity)
    {
        super();

        battery_indicator = (ImageView) nokia_phone_activity.findViewById(R.id.battery_indicator);
    }

    @Override
    public void onReceive(Context context, Intent battery_status)
    {
        if (battery_status.getAction().equalsIgnoreCase(Intent.ACTION_BATTERY_CHANGED))
        {
            // get battery level
            int level_new = battery_status.getIntExtra("level", 0) / 20;
            boolean charging_new = battery_status.getIntExtra(BatteryManager.EXTRA_STATUS, -1) == BatteryManager.BATTERY_STATUS_CHARGING;

            Log.d("BatteryIndicator", "battery changed: " + String.valueOf(level_new) + " " + String.valueOf(charging_new));

            if (level_new != level || charging_new != charging)
            {
                if (charging_new)
                {
                    if (level_new < 5)
                    {
                        battery_indicator.setImageResource(R.drawable.battery_charging);
                        
                        battery_indicator.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                ((AnimationDrawable) battery_indicator.getDrawable()).start();
                            }
                        });
                    }
                    else
                    {
                        battery_indicator.setImageResource(R.drawable.battery_full);
                    }
                }
                else
                {
                    if (level_new >= 4)
                    {
                        battery_indicator.setImageResource(R.drawable.battery_full);
                    }
                    else if (level_new == 3)
                    {
                        battery_indicator.setImageResource(R.drawable.battery_high);
                    }
                    else if (level_new == 2)
                    {
                        battery_indicator.setImageResource(R.drawable.battery_medium);
                    }
                    else if (level_new == 1)
                    {
                        battery_indicator.setImageResource(R.drawable.battery_low);
                    }
                    else
                    {
                        battery_indicator.setImageResource(R.drawable.battery_empty);
                    }
                }
            }

            level = level_new;
            charging = charging_new;
        }
    }
}
