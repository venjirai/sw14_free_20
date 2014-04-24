package com.example.nokiaphonesimulator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.widget.ImageView;

public class BatteryIndicator extends BroadcastReceiver
{
    private ImageView battery_indicator;
    private int level_old = -1;

    BatteryIndicator(NokiaPhoneActivity nokia_phone_activity)
    {
        super();

        battery_indicator = (ImageView) nokia_phone_activity.findViewById(R.id.battery_indicator);

        // start BatteryIndicator
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        nokia_phone_activity.registerReceiver(this, batteryLevelFilter);
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BATTERY_CHANGED))
        {
            int level_new = intent.getIntExtra("level", 0) / 20;

            Log.d("BatteryIndicator", "battery level changed: " + String.valueOf(level_new));

            if (level_new != level_old)
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

                level_old = level_new;

                Log.d("BatteryIndicator", "new battery drawable set");
            }
        }
    }
}
