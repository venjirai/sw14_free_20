package com.example.nokiaphonesimulator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.ImageView;

public class BatteryIndicator extends BroadcastReceiver
{
    private ImageView battery_indicator;
    private int level = -1;
    private AnimationDrawable charging_animation;

    BatteryIndicator(NokiaPhoneActivity nokia_phone_activity)
    {
        super();

        battery_indicator = (ImageView) nokia_phone_activity.findViewById(R.id.battery_indicator);
        
        // initiate the AnimationDrawable
        charging_animation = (AnimationDrawable) battery_indicator.getDrawable();

        // start BatteryIndicator
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        nokia_phone_activity.registerReceiver(this, batteryLevelFilter);
    }

    @Override
    public void onReceive(Context context, Intent battery_status)
    {
        if (battery_status.getAction().equalsIgnoreCase(Intent.ACTION_BATTERY_CHANGED))
        {
            // get battery level
            int level_new = battery_status.getIntExtra("level", 0) / 20;

            Log.d("BatteryIndicator", "battery level changed: " + String.valueOf(level_new));

            // if the level has changed
            if (level_new != level)
            {
                if (level_new >= 4)
                {
                    battery_indicator.setImageResource(R.drawable.battery_charging_full);
                }
                else if (level_new == 3)
                {
                    battery_indicator.setImageResource(R.drawable.battery_charging_high);
                }
                else if (level_new == 2)
                {
                    battery_indicator.setImageResource(R.drawable.battery_charging_medium);
                }
                else if (level_new == 1)
                {
                    battery_indicator.setImageResource(R.drawable.battery_charging_low);
                }
                else
                {
                    battery_indicator.setImageResource(R.drawable.battery_charging_empty);
                }

                // update the AnimationDrawable
                charging_animation = (AnimationDrawable) battery_indicator.getDrawable();

                // set new battery level
                level = level_new;

                Log.d("BatteryIndicator", "new battery drawable set");
            }

            // if device is charging and not full
            if (battery_status.getIntExtra(BatteryManager.EXTRA_STATUS, -1) == BatteryManager.BATTERY_STATUS_CHARGING && level < 5)
            {
                charging_animation.start(); // does nothing if already running
            }
            else
            {
                charging_animation.stop(); // does nothing if not running
            }
        }
    }
}
