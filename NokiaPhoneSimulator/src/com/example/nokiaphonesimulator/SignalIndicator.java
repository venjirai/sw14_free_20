package com.example.nokiaphonesimulator;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.widget.ImageView;

public class SignalIndicator extends PhoneStateListener
{
    ImageView signal_indicator;

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
        int strengthAmplitude = signalStrength.getGsmSignalStrength();

        if (strengthAmplitude > 25) // || strengthAmplitude == 99
        {
            signal_indicator.setImageResource(R.drawable.signal_max);
        }
        else if (strengthAmplitude > 18)
        {
            signal_indicator.setImageResource(R.drawable.signal_high);
        }
        else if (strengthAmplitude > 12)
        {
            signal_indicator.setImageResource(R.drawable.signal_medium);
        }
        else if (strengthAmplitude > 6)
        {
            signal_indicator.setImageResource(R.drawable.signal_low);
        }
        else
        {
            signal_indicator.setImageResource(R.drawable.signal_min);
        }
    }

}
