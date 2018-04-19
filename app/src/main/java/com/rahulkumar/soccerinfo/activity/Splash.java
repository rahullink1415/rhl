package com.rahulkumar.soccerinfo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;

import android.support.animation.SpringAnimation;
import android.support.animation.SpringForce;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.rahulkumar.soccerinfo.R;


public class Splash extends BaseActivity {
    private static final int SPLASH_TIMEOUT = 8000;
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
        mAppLogo.setVisibility(View.INVISIBLE);
        view = findViewById(R.id.container);
        LottieAnimationView animationView = findViewById(R.id.animation_view);
        animationView.playAnimation();

       // progressBar =findViewById(R.id.progressId);
       // progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.MULTIPLY);
        new Handler().postDelayed(() -> {
            mAppLogo.setVisibility(View.VISIBLE);
            startSpringAnimation(mAppLogo);

        }, 2000);
        new Handler().postDelayed(() -> {
            startActivity(new Intent(Splash.this, MainActivity.class));
            finish();
            overridePendingTransition(R.anim.exit_top, R.anim.enter_bottom);

        }, SPLASH_TIMEOUT);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void startSpringAnimation(View view){
        // create an animation for your view and set the property you want to animate
        SpringAnimation animation = new SpringAnimation(view, SpringAnimation.Y,700);
        // create a spring with desired parameters
        SpringForce spring = new SpringForce();
        // can also be passed directly in the constructor
        spring.setFinalPosition(700f);
        // optional, default is STIFFNESS_MEDIUM
        spring.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        // optional, default is DAMPING_RATIO_MEDIUM_BOUNCY
        spring.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        // set your animation's spring
        animation.setSpring(spring);
        // animate!
        animation.start();
    }
}
