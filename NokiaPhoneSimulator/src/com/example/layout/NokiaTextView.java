package com.example.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class NokiaTextView extends TextView
{


    public NokiaTextView(Context context)
    {
        super(context);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "NokiaBig.ttf");
        this.setTypeface(face);
    }

    public NokiaTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "NokiaBig.ttf");
        this.setTypeface(face);
    }

    public NokiaTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        Typeface face = Typeface.createFromAsset(context.getAssets(), "NokiaBig.ttf");
        this.setTypeface(face);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }

}
