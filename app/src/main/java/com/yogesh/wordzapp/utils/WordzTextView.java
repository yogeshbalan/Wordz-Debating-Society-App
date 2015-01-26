package com.yogesh.wordzapp.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yogesh.wordzapp.R;

/**
 * Created by yogesh on 9/1/15.
 */
public class WordzTextView extends TextView {

    public WordzTextView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public WordzTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public WordzTextView(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.WordzTextView);
            String fontName = a
                    .getString(R.styleable.WordzTextView_fontName);
            if (fontName != null) {
                Typeface myTypeface = Typeface.createFromAsset(getContext()
                        .getAssets(), "fonts/" + fontName);
                setTypeface(myTypeface);
            }
            a.recycle();
        }
    }

}
