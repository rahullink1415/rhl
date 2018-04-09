package com.rahulkumar.soccerinfo.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.utilty.Utility;

import net.steamcrafted.loadtoast.LoadToast;

public class DetailNewsActivity extends BaseActivity {
    private static final String TAG = "DetailNewsActivity";
    private WebView myWebView;
    private LoadToast loadToast;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() !=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myWebView = findViewById(R.id.webview);
        myWebView.loadUrl(getIntent().getStringExtra("url"));
        myWebView.setHorizontalScrollBarEnabled(false);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                initToast();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadToast.success();
            }
        });
        Utility.log(TAG, getIntent().getStringExtra("url"));
    }

    private void initToast() {
        loadToast = new LoadToast(this);
        loadToast.setProgressColor(Color.BLUE);
        loadToast.setTranslationY(200);
        loadToast.show();
    }


}
