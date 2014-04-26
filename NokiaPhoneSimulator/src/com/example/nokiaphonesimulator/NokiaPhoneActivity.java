package com.example.nokiaphonesimulator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.example.screen.MainMenu;
import com.example.screen.NokiaScreen;
import com.example.screen.StartScreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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

    private TextView action;
    private TextView menu_titel;

    private int displayWidth, displayHeight;

    private ContactList contact_list;
    private BatteryIndicator battery_indicator;
    private SignalIndicator signal_indicator;

    private List<NokiaScreen> screens;
    private int screen_id;

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

        InitializeButtons();

        // Initialize TextViews
        Typeface font = Typeface.createFromAsset(getAssets(), "NokiaBig.ttf");
        action = (TextView) this.findViewById(R.id.action);
        action.setTypeface(font);
        menu_titel = (TextView) this.findViewById(R.id.title);
        menu_titel.setTypeface(font);

        // Get and set font sizes
        getFontSizes();
        action.setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);
        menu_titel.setTextSize(TypedValue.COMPLEX_UNIT_DIP, font_small);

        // Loads contacts from phone
        contact_list = new ContactList(context);

        battery_indicator = new BatteryIndicator(this);
        signal_indicator = new SignalIndicator(this);


        // Load preferences
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        first_time_startup = preferences.getBoolean("first_time_startup", true);

        // Initialize menus
        initializeMenus();

        // Set screen
        screens.get(screen_id).refresh();


        if (first_time_startup)
        {
            FirstTimeInitialize();
        }
        else
        {

        }
    }

    private void initializeMenus()
    {
        screens = new ArrayList<NokiaScreen>();
        screens.add(new StartScreen(this));
        screens.add(new MainMenu(this));
    }

    private void getFontSizes()
    {
        if (displayWidth == 480 && displayHeight == 800)
        {
            font_small = 20;
            font_big = 30;
        }

    }

    private void FirstTimeInitialize()
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
    public void onPause()
    {
        super.onPause(); // Always call the superclass method first

        // to do: what happens when app is minimized/hidden?
        // (stop services, threads, listeners)

        // pause BatteryIndicator
        this.unregisterReceiver(battery_indicator);
    }

    @Override
    public void onResume()
    {
        super.onResume(); // Always call the superclass method first
        // to do: what happens when app comes back in front?
        // (start services, threads, listeners)

        // resume BatteryIndicator
        IntentFilter batteryLevelFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        this.registerReceiver(battery_indicator, batteryLevelFilter);
    }


    private void InitializeButtons()
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
            new LayoutScaler();
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
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).zero();
                    break;

                case R.id.btn_one:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).one();
                    break;

                case R.id.btn_two:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).two();
                    break;

                case R.id.btn_three:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).three();
                    break;

                case R.id.btn_four:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).four();
                    break;

                case R.id.btn_five:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).five();
                    break;

                case R.id.btn_six:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).six();
                    break;

                case R.id.btn_seven:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).seven();
                    break;

                case R.id.btn_eight:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    screens.get(screen_id).eight();
                    break;

                case R.id.btn_nine:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
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

            screens.get(screen_id).refresh();
        }

        return false;
    }

    public void setScreenId(int screen_id)
    {
        this.screen_id = screen_id;
    }
}
