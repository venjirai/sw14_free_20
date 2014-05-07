package com.example.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

class NokiaScrollView extends ScrollView
{

    public NokiaScrollView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public NokiaScrollView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public NokiaScrollView(Context context)
    {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return false;
    }
}
