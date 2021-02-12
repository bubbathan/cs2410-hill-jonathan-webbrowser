package com.bubsstuff.webbrowser;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class Button extends AppCompatButton {

    public Button(@NonNull Context context) {
        super(context);
        AppCompatButton button = new AppCompatButton(context);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        buttonParams.weight = 1;
        button.setLayoutParams(buttonParams);
    }
}
