package com.example.nokiaphonesimulator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.layout.LayoutScaler;
import com.example.screen.*;
import com.example.screen.messages.*;
import com.example.screen.Screen.ScreenId;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.media.SoundPool;
import android.media.AudioManager;

public class NokiaPhoneActivity extends Activity implements OnTouchListener
{
    private Context context;

    private SoundPool sp;

    private int displayWidth, displayHeight;

    private BatteryIndicator battery_indicator;
    private SignalIndicator signal_indicator;
    private Clock clock;

    private List<Screen> screens;
    private int screen_id = ScreenId.START_SCREEN;

    int[] sounds = new int[10];
    int tastenton;

    boolean first_time_startup;
    Calendar date;
    int font_big, font_small;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nokia_phone);

        // Get application context for certain method calls
        context = this.getApplicationContext();

        // Set Date
        date = Calendar.getInstance();

        // Set control stream for NokiaPhoneActivity to music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        // Get device resolution
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        displayWidth = metrics.widthPixels;
        displayHeight = metrics.heightPixels;

        // Load sounds
        sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        LoadSounds();

        initializeButtons();
        initializeTextViews();

        battery_indicator = new BatteryIndicator(this);
        signal_indicator = new SignalIndicator(this);
        clock = new Clock((TextView) this.findViewById(R.id.clock_view));

        // Load preferences
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        first_time_startup = preferences.getBoolean("first_time_startup", true);

        // Initialize menus
        initializeMenus();

        // Set screen
        screens.get(screen_id).update();

        if (first_time_startup)
        {
            firstTimeInitialize();
        }
        else
        {

        }
    }

    private void initializeTextViews()
    {
        // Get and set font sizes
        getFontSizes();

        ((TextView) this.findViewById(R.id.action)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.title)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_big);
        ((TextView) this.findViewById(R.id.clock_view)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.input)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.text_output)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.header_right)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.number_input)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_big);
        

        ((TextView) this.findViewById(R.id.sub_menu_title_one)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.sub_menu_title_two)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        ((TextView) this.findViewById(R.id.sub_menu_title_three)).setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
    }

    private void initializeMenus()
    {
        screens = new ArrayList<Screen>();
        screens.add(new StartScreen(this));
        screens.add(new MainMenu(this));
        screens.add(new Calculator(this));
        screens.add(new ContactScreen(this));
        screens.add(new MessagesMenu(this));
        screens.add(new CalculatorMenu(this));
        screens.add(new MessagesInbox(this));
        screens.add(new ReadMessage(this));
        screens.add(new MessagesOutbox(this));
        screens.add(new WriteMessage(this));
        screens.add(new SendMessage(this));
    }

    private void getFontSizes()
    {
        if (displayWidth == 480 && displayHeight == 800)
        {
            font_small = 20;
            font_big = 26;
        }
    }

    private void firstTimeInitialize()
    {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("first_time_startup", false);
        editor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nokia_phone, menu); // Menu Resource, Menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_settings:
                Toast.makeText(context, "No Settings!", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        // start services, threads, listeners, receivers!

        // start updates for BatteryIndicator
        IntentFilter battery_level_filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        this.registerReceiver(battery_indicator, battery_level_filter);

        // start the Clock
        IntentFilter time_filter = new IntentFilter(Intent.ACTION_TIME_TICK);
        this.registerReceiver(clock, time_filter);
        this.clock.refresh();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        // stop services, threads, listeners, receivers!

        // stop updates for BatteryIndicator
        this.unregisterReceiver(battery_indicator);

        // stop the clock
        this.unregisterReceiver(clock);
    }

    private void initializeButtons()
    {
        Button btn_zero = (Button) this.findViewById(R.id.btn_zero);
        Button btn_one = (Button) this.findViewById(R.id.btn_one);
        Button btn_two = (Button) this.findViewById(R.id.btn_two);
        Button btn_three = (Button) this.findViewById(R.id.btn_three);
        Button btn_four = (Button) this.findViewById(R.id.btn_four);
        Button btn_five = (Button) this.findViewById(R.id.btn_five);
        Button btn_six = (Button) this.findViewById(R.id.btn_six);
        Button btn_seven = (Button) this.findViewById(R.id.btn_seven);
        Button btn_eight = (Button) this.findViewById(R.id.btn_eight);
        Button btn_nine = (Button) this.findViewById(R.id.btn_nine);

        Button btn_star = (Button) this.findViewById(R.id.btn_star);
        Button btn_pound = (Button) this.findViewById(R.id.btn_pound);
        Button btn_clear = (Button) this.findViewById(R.id.btn_clear);
        Button btn_enter = (Button) this.findViewById(R.id.btn_enter);
        Button btn_down = (Button) this.findViewById(R.id.btn_down);
        Button btn_up = (Button) this.findViewById(R.id.btn_up);

        btn_zero.setOnTouchListener(this);
        btn_one.setOnTouchListener(this);
        btn_two.setOnTouchListener(this);
        btn_three.setOnTouchListener(this);
        btn_four.setOnTouchListener(this);
        btn_five.setOnTouchListener(this);
        btn_six.setOnTouchListener(this);
        btn_seven.setOnTouchListener(this);
        btn_eight.setOnTouchListener(this);
        btn_nine.setOnTouchListener(this);

        btn_star.setOnTouchListener(this);
        btn_pound.setOnTouchListener(this);
        btn_clear.setOnTouchListener(this);
        btn_enter.setOnTouchListener(this);
        btn_down.setOnTouchListener(this);
        btn_up.setOnTouchListener(this);
    }

    private void LoadSounds()
    {
        tastenton = sp.load(this, R.raw.tastenton, 1);
        sounds[0] = sp.load(this, R.raw.s0, 1);
        sounds[1] = sp.load(this, R.raw.s1, 1);
        sounds[2] = sp.load(this, R.raw.s2, 1);
        sounds[3] = sp.load(this, R.raw.s3, 1);
        sounds[4] = sp.load(this, R.raw.s4, 1);
        sounds[5] = sp.load(this, R.raw.s5, 1);
        sounds[6] = sp.load(this, R.raw.s6, 1);
        sounds[7] = sp.load(this, R.raw.s7, 1);
        sounds[8] = sp.load(this, R.raw.s8, 1);
        sounds[9] = sp.load(this, R.raw.s9, 1);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus)
        {
            LayoutScaler.scaleContents(findViewById(R.id.contents), findViewById(R.id.container));
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {

            switch (v.getId())
            {
                case R.id.btn_zero:
                    sp.play(sounds[0], 1, 1, 0, 0, 1);
                    screens.get(screen_id).zero();
                    break;

                case R.id.btn_one:
                    sp.play(sounds[1], 1, 1, 0, 0, 1);
                    screens.get(screen_id).one();
                    break;

                case R.id.btn_two:
                    sp.play(sounds[2], 1, 1, 0, 0, 1);
                    screens.get(screen_id).two();
                    break;

                case R.id.btn_three:
                    sp.play(sounds[3], 1, 1, 0, 0, 1);
                    screens.get(screen_id).three();
                    break;

                case R.id.btn_four:
                    sp.play(sounds[4], 1, 1, 0, 0, 1);
                    screens.get(screen_id).four();
                    break;

                case R.id.btn_five:
                    sp.play(sounds[5], 1, 1, 0, 0, 1);
                    screens.get(screen_id).five();
                    break;

                case R.id.btn_six:
                    sp.play(sounds[6], 1, 1, 0, 0, 1);
                    screens.get(screen_id).six();
                    break;

                case R.id.btn_seven:
                    sp.play(sounds[7], 1, 1, 0, 0, 1);
                    screens.get(screen_id).seven();
                    break;

                case R.id.btn_eight:
                    sp.play(sounds[8], 1, 1, 0, 0, 1);
                    screens.get(screen_id).eight();
                    break;

                case R.id.btn_nine:
                    sp.play(sounds[9], 1, 1, 0, 0, 1);
                    screens.get(screen_id).nine();
                    break;

                case R.id.btn_star:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).star();
                    break;

                case R.id.btn_pound:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).pound();
                    break;

                case R.id.btn_clear:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).clear();
                    break;

                case R.id.btn_enter:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).enter();
                    break;

                case R.id.btn_down:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).down();
                    break;

                case R.id.btn_up:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).up();
                    break;
            }

            screens.get(screen_id).update();
        }

        return false;
    }

    public List<Screen> getScreens()
    {
        return screens;
    }

    public void setScreenId(int screen_id)
    {
        this.screen_id = screen_id;
    }
}
