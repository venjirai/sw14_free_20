package com.example.nokiaphonesimulator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutScaler 
{
  private static int width;
  private static int height;
  private static Context context;
  
  
    public LayoutScaler(int width, int height, Context context)
    {
      this.width = width;
      this.height = height;
      this.context = context;
    }
  
  
    public static void scaleContents(View rootView, View container) 
    {
    	LayoutScaler.scaleContents(rootView, container, rootView.getWidth(), rootView.getHeight());
    }

    // Scales the contents of the given view so that it completely fills the given
    // container on one axis (that is, we're scaling isotropically).
    public static void scaleContents(View rootView, View container, int width, int height) 
    {

        // Compute the scaling ratio
        float xScale = (float)container.getWidth() / width;
        float yScale = (float)container.getHeight() / height;
        float scale = Math.min(xScale, yScale);

        // Scale our contents
        scaleViewAndChildren(rootView, scale, 0);
    }

    // Scale the given view, its contents, and all of its children by the given factor.
    public static void scaleViewAndChildren(View root, float scale, int canary) 
    {
        // Retrieve the view's layout information
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();

        // Scale the View itself
        if(layoutParams.width != ViewGroup.LayoutParams.MATCH_PARENT && layoutParams.width != ViewGroup.LayoutParams.WRAP_CONTENT) 
        {
            layoutParams.width *= scale;
        }
        if(layoutParams.height != ViewGroup.LayoutParams.MATCH_PARENT && layoutParams.height != ViewGroup.LayoutParams.WRAP_CONTENT) 
        {
            layoutParams.height *= scale;
        }

        // If the View has margins, scale those too
        if(layoutParams instanceof ViewGroup.MarginLayoutParams) 
        {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams)layoutParams;
            marginParams.leftMargin *= scale;
            marginParams.topMargin *= scale;
            marginParams.rightMargin *= scale;
            marginParams.bottomMargin *= scale;
        }
        root.setLayoutParams(layoutParams);

        // Same treatment for padding
        root.setPadding(
            (int)(root.getPaddingLeft() * scale),
            (int)(root.getPaddingTop() * scale),
            (int)(root.getPaddingRight() * scale),
            (int)(root.getPaddingBottom() * scale)
        );

        // If it's a TextView, scale the font size
        
        if(root instanceof TextView) 
        {
            TextView tv = (TextView)root;
                       
            
            if (width == 480 && height == 800) 
              tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,17);
  
            
            /* Add more resolutions here, change it so 26 ones fit in one line
            else if (width =  && height == ) 
              tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,XX);
            */
            
            
            // Device not supported, close the application
            else
            {
              AlertDialog.Builder builder  = new AlertDialog.Builder(context);

              builder.setMessage("Device not supported!");
              builder.setTitle("Error");         
              
              
              builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
              {
                public void onClick(DialogInterface dialog, int id) 
                {
                    System.exit(0);
                }
              });

              AlertDialog dialog = builder.create();
              
              dialog.show();
                     
            }
            
        }
        
                
        // If it's a ViewGroup, recurse!
        if(root instanceof ViewGroup) 
        {
            ViewGroup vg = (ViewGroup)root;
            for(int i = 0; i < vg.getChildCount(); i++) 
            {
                scaleViewAndChildren(vg.getChildAt(i), scale, canary + 1);
            }
        }
    }
}
