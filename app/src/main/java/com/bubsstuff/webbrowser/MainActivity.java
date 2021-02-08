package com.bubsstuff.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HistoryList browserHistory = new HistoryList();

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout addressBar = new LinearLayout(this);
        LinearLayout.LayoutParams addressBarParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        addressBarParams.setMargins(5,5,5,20);
        addressBar.setLayoutParams(addressBarParams);

        AppCompatEditText searchBar = new AppCompatEditText(this);
        LinearLayout.LayoutParams searchBarParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        searchBarParams.weight = 1;
        searchBar.setLayoutParams(searchBarParams);
        searchBar.setText("https://google.com");

        AppCompatButton goButton = new AppCompatButton(this);
        LinearLayout.LayoutParams goButtonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        goButton.setLayoutParams(goButtonParams);
        goButton.setText("Go");

        LinearLayout backForwardBar = new LinearLayout(this);
        LinearLayout.LayoutParams backForwardBarParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        backForwardBarParams.setMargins(5,5,5,0);
        backForwardBar.setLayoutParams(backForwardBarParams);

        AppCompatButton backButton = new AppCompatButton(this);
        backButton.setText("<");
        LinearLayout.LayoutParams backButtonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        backButtonParams.weight = 1;
        backButton.setLayoutParams(backButtonParams);

        AppCompatButton forwardButton = new AppCompatButton(this);
        forwardButton.setText(">");
        LinearLayout.LayoutParams forwardButtonParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        forwardButtonParams.weight = 1;
        forwardButton.setLayoutParams(forwardButtonParams);

        WebView webSiteView = new WebView(this);
        LinearLayout.LayoutParams webViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        webViewParams.weight = 1;
        webSiteView.setLayoutParams(webViewParams);
        webSiteView.loadUrl("https://google.com");
        webSiteView.setWebViewClient(new WebViewClient());

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browserHistory.addSite(searchBar.getText().toString());
                webSiteView.loadUrl(searchBar.getText().toString());

            }
        }
        );

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String previousWebSite = browserHistory.previousSite(searchBar.getText().toString());
                searchBar.setText(previousWebSite);
                webSiteView.loadUrl(searchBar.getText().toString());

            }
        }
        );

        backForwardBar.addView(backButton);
        backForwardBar.addView(forwardButton);
        addressBar.addView(searchBar);
        addressBar.addView(goButton);

        mainLayout.addView(addressBar);
        mainLayout.addView(webSiteView);
        mainLayout.addView(backForwardBar);

        setContentView(mainLayout);
    }
}