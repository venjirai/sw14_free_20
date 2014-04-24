package com.example.nokiaphonesimulator;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.ImageView;

public class SignalIndicator extends PhoneStateListener
{
    private ImageView signal_indicator;
    private int strength_old = -1;

    SignalIndicator(NokiaPhoneActivity nokia_phone_activity)
    {
        super();

        signal_indicator = (ImageView) nokia_phone_activity.findViewById(R.id.signal_indicator);

        ((TelephonyManager) nokia_phone_activity.getSystemService(Context.TELEPHONY_SERVICE)).listen(this, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }

    @Override
    public void onSignalStrengthsChanged(SignalStrength signalStrength)
    {
        super.onSignalStrengthsChanged(signalStrength);

        // get the signal strength (a value between 0 and 31 or 99 no signal / error)
        int strength_new = signalStrength.getGsmSignalStrength() * 5 / 31;

        Log.d("SignalIndicator", "signal strength changed: " + String.valueOf(strength_new));

        if (strength_new != strength_old)
        {
            if (strength_new >= 4)
            {
                signal_indicator.setImageResource(R.drawable.signal_max);
            }
            else if (strength_new == 3)
            {
                signal_indicator.setImageResource(R.drawable.signal_high);
            }
            else if (strength_new == 2)
            {
                signal_indicator.setImageResource(R.drawable.signal_medium);
            }
            else if (strength_new == 1)
            {
                signal_indicator.setImageResource(R.drawable.signal_low);
            }
            else
            {
                signal_indicator.setImageResource(R.drawable.signal_min);
            }
            
            strength_old = strength_new;
            
            Log.d("SignalIndicator", "new signal drawable set");
        }
    }
}
