package com.example.gx60.semiproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webb;
    private Button saveURL;
    private TextView urlView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        saveURL = (Button) findViewById(R.id.save_url);
        /*  WebView webb = (WebView) findViewById(R.id.web1);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl("http://www.facebook.com");*/
        webb = (WebView) findViewById(R.id.fb_view);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl("https://www.facebook.com");

        urlView = (TextView) findViewById(R.id.url_text);
        saveURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                urlView.setText(webb.getUrl());
            }
        });

    }
}
