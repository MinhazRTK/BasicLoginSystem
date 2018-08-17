package com.batch2.m0nk3y.basicloginsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    public String string;
    public WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        string = getIntent().getStringExtra("WEB_URL");
        myWebView = findViewById(R.id.webview);
        myWebView.loadUrl(string);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new myWebClient());
    }

}
