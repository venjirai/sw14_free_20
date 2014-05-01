package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity implements Runnable
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {
            new Handler().postDelayed(this, 500);
        }
    }

    @Override
    public void run()
    {
        Intent nokia_phone = new Intent(SplashScreen.this, NokiaPhoneActivity.class);
        startActivity(nokia_phone);

        // close this activity
        finish();
    }
}
