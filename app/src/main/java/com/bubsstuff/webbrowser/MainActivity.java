package com.bubsstuff.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HistoryList browserHistory = new HistoryList("https://google.com");

        // Create main layout
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        // Create address bar layout
        HorizontalLayout addressBar = new HorizontalLayout(this);

        // Create search field
        AppCompatEditText searchBar = new AppCompatEditText(this);
        LinearLayout.LayoutParams searchBarParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        searchBarParams.weight = 100;
        searchBar.setLayoutParams(searchBarParams);
        searchBar.setText("https://google.com");
        browserHistory.addSite(searchBar.getText().toString());

        // Create go button
        Button goButton = new Button(this);
        goButton.setText("Go");

        // Create layout for forward and back buttons
        HorizontalLayout backForwardBar = new HorizontalLayout(this);

        // Create back button
        Button backButton = new Button(this);
        backButton.setText("<");

        // Create forward button
        Button forwardButton = new Button(this);
        forwardButton.setText(">");

        // Create view for website
        WebView webSiteView = new WebView(this);
        LinearLayout.LayoutParams webViewParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        webViewParams.weight = 1;
        webSiteView.setLayoutParams(webViewParams);
        webSiteView.loadUrl("https://google.com");
        webSiteView.setWebViewClient(new WebViewClient());

        // Go button functionality
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browserHistory.addSite(searchBar.getText().toString());
                webSiteView.loadUrl(searchBar.getText().toString());
            }
        });

        // Back button functionality
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String previousWebSite = browserHistory.previousSite();
                searchBar.setText(previousWebSite);
                webSiteView.loadUrl(searchBar.getText().toString());
            }
        });

        // Forward button functionality\
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nextWebSite = browserHistory.forwardSite();
                searchBar.setText((nextWebSite));
                webSiteView.loadUrl(searchBar.getText().toString());
            }
        });

        System.out.println();
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