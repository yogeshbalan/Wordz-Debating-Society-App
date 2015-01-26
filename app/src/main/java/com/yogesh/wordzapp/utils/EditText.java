package com.yogesh.wordzapp.utils;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Raveesh on 05/01/15.
 */
public class EditText extends android.widget.EditText {
    public EditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            /**
             * Searching for the typeface attribute
             */
            if (attrs.getAttributeName(i).equals("typeface")) {
                String typeface = attrs.getAttributeValue(i);
                if (!isInEditMode()) {
                    try {
                        setTypeface(CustomType.getTypeface(context, typeface));
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
    }
}
