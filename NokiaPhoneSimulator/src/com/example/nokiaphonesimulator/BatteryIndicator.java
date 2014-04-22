package com.example.nokiaphonesimulator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.ImageView;

public class BatteryIndicator extends BroadcastReceiver
{
    
    ImageView battery_indicator;
    BatteryUpdate battery_update;
    
    BatteryIndicator(NokiaPhoneActivity nokia_phone_activity)
    {        
        battery_indicator = (ImageView) nokia_phone_activity.findViewById(R.id.battery_indicator);
        
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        nokia_phone_activity.registerReceiver(this, batteryLevelFilter);
        
        battery_update = new BatteryUpdate();
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        battery_update.doInBackground(intent);
    }

    private class BatteryUpdate extends AsyncTask<Intent, Void, Void>
    {
       
        @Override
        protected Void doInBackground(Intent... intents)
        {
            Intent intent = intents[0];
            
            int currentLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int level = -1;
            if (currentLevel >= 0 && scale > 0)
            {
                level = (currentLevel * 100) / scale;
                Log.d("battery", "battery: " + level);  
            }           
            
            if(level > 79)
            {
                battery_indicator.setImageResource(R.drawable.battery_full);          
            }
            else if(level > 59)
            {
                battery_indicator.setImageResource(R.drawable.battery_high);    
            }
            else if (level > 39)
            {
                battery_indicator.setImageResource(R.drawable.battery_medium);    
            }
            else if (level > 19)
            {
                battery_indicator.setImageResource(R.drawable.battery_low);    
            }
            else
            {
                battery_indicator.setImageResource(R.drawable.battery_empty);    
            }
            
            return null;
        }

        @Override
        protected void onPreExecute()
        {

        }

        @Override
        protected void onProgressUpdate(Void... values)
        {

        }
    }
}
