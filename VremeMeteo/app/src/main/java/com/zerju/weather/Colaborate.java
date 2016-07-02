package com.zerju.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Jure on 8. 03. 2016.
 */
public class Colaborate extends TextView {
    public Colaborate(Context context,AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/ColabThi.otf"));
    }
}
