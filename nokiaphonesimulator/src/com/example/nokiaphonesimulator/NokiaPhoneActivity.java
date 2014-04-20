package com.example.nokiaphonesimulator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
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

    private String phone_number = "";

    private ContactList contact_list;
    private int cursor = 0;

    private int text_length = 0;

    private boolean text_big = true;
    private int chars_over_small = 0;

    private SoundPool sp;

    private TextView output1;

    int displayWidth, displayHeight;

    int[] sounds = new int[10];
    int tastenton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nokia_phone);

        // get application context for certain method calls
        context = this.getApplicationContext();

        // set control stream for NokiaPhoneActivity to music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        displayWidth = metrics.widthPixels;
        displayHeight = metrics.heightPixels;

        sp = new SoundPool(99, AudioManager.STREAM_MUSIC, 0);
        LoadSounds();

        InitializeButtons();

        Typeface font = Typeface.createFromAsset(getAssets(), "NokiaBig.ttf");
        output1 = (TextView) this.findViewById(R.id.textView_output1);
        output1.setTypeface(font);

        textViewInitialize(output1);

        // loads contacts from phone
        contact_list = new ContactList(context);

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

    private void textViewInitialize(TextView tv)
    {
        if (displayWidth == 480 && displayHeight == 800)
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

        /*
         * Add more resolutions here else if (displayWidth = && displayHeight ==
         * ) tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,XX);
         */

    }

    private void scaleTextview(TextView tv, String digit)
    {
        int lines = tv.getLineCount();

        if (!text_big && digit != "CLEAR")
            chars_over_small++;

        else if (digit == "CLEAR")
            chars_over_small--;

        if (chars_over_small < 0)
            chars_over_small = 0;

        if (lines >= 3)
        {
            if (chars_over_small == 0)
                chars_over_small = 1;

            text_big = false;

            if (displayWidth == 480 && displayHeight == 800)
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);

        }

        else if (lines <= 2 && digit == "CLEAR" && chars_over_small == 0)
        {
            text_big = true;

            if (displayWidth == 480 && displayHeight == 800)
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);

            /*
             * Add more resolutions here else if (displayWidth = &&
             * displayHeight == )
             * tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,XX);
             */
        }

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

    private void digitButton(String digit)
    {

        if (text_length <= 80)
            phone_number += digit;
        else
            text_length--;

        output1.setText(phone_number);
        scaleTextview(output1, digit);
    }

    private void call(String phone_number)
    {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + output1.getText()));
        startActivity(callIntent);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {

        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {

            switch (v.getId())
            {
                case R.id.btn_zero:
                    text_length++;
                    digitButton("0");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_one:
                    text_length++;
                    digitButton("1");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_two:
                    text_length++;
                    digitButton("2");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_three:
                    text_length++;
                    digitButton("3");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_four:
                    text_length++;
                    digitButton("4");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_five:
                    text_length++;
                    digitButton("5");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_six:
                    text_length++;
                    digitButton("6");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_seven:
                    text_length++;
                    digitButton("7");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_eight:
                    text_length++;
                    digitButton("8");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_nine:
                    text_length++;
                    digitButton("9");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_star:
                    text_length++;
                    digitButton("*");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_pound:
                    text_length++;
                    digitButton("#");
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    break;

                case R.id.btn_clear:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    if (phone_number.length() > 0)
                    {
                        phone_number = phone_number.substring(0, phone_number.length() - 1);
                        output1.setText(phone_number);
                        text_length--;
                        scaleTextview(output1, "CLEAR");
                    }
                    break;

                case R.id.btn_enter:
                    sp.play(tastenton, 1, 1, 0, 0, 1);
                    call(phone_number);
                    break;

                case R.id.btn_down:
                    sp.play(tastenton, 1, 1, 0, 0, 1);

                    if (cursor < contact_list.size() - 1)
                        cursor++;

                    Contact contact = contact_list.getContact(cursor);
                    output1.setText(contact.getPhoneNumber());

                    if (contact != null)
                        output1.setText(contact.getPhoneNumber() + contact.getGivenName() + contact.getFamilyName());

                    break;

                case R.id.btn_up:
                    sp.play(tastenton, 1, 1, 0, 0, 1);

                    if (cursor > 0)
                        cursor--;

                    contact = contact_list.getContact(cursor);
                    if (contact != null)
                        output1.setText(contact.getPhoneNumber() + contact.getGivenName() + contact.getFamilyName());

                    break;
            }
        }
        return false;
    }

}
