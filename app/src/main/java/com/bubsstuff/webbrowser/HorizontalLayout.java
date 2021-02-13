package com.bubsstuff.webbrowser;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class HorizontalLayout extends LinearLayout {
    public HorizontalLayout(Context context) {
        super(context);

        LinearLayout horizontalLayout = new LinearLayout(context);
        LinearLayout.LayoutParams horizontalLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        horizontalLayoutParams.setMargins(5,5,5,5);
        horizontalLayout.setLayoutParams(horizontalLayoutParams);
    }
}
