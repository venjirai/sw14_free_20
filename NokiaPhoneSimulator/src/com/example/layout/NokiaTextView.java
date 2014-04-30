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
        FontHelper.setTypeface(context, this);
    }

    public NokiaTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        FontHelper.setTypeface(context, this);
    }

    public NokiaTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        FontHelper.setTypeface(context, this);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
    }
}

class FontHelper
{
    private static Typeface typeface = null;

    public static void setTypeface(Context context, TextView textview)
    {
        if (typeface == null)
        {
            typeface = Typeface.createFromAsset(context.getAssets(), "NokiaBig.ttf");
        }
        textview.setTypeface(typeface);
    }
}
