package com.rahulkumar.soccerinfo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rahulkumar.soccerinfo.R;


public class Splash extends BaseActivity {
    private static final int SPLASH_TIMEOUT = 2000;
    private TextView mAppName;
    private ImageView mAppLogo;
    private View view;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mAppName = findViewById(R.id.textView);
        mAppLogo = findViewById(R.id.imageView);
        view = findViewById(R.id.container);

        progressBar =findViewById(R.id.progressId);
        progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(Splash.this, MainActivity.class));
            finish();
            overridePendingTransition(R.anim.exit_top, R.anim.enter_bottom);

        }, SPLASH_TIMEOUT);
    }
}
