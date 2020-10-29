package com.saperfumes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.saperfumes.databinding.ActivitySplashBinding;
import com.saperfumes.login.LoginActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        new Handler().postDelayed(()->{
            if(!isUserLoggedIn()){
                Intent intent = new Intent(this, LoginActivity.class);
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(this, binding.logo, "logo");
                startActivity(intent, options.toBundle());
                new Handler().postDelayed(this::finish,400);
            }
        },2500);

        new Handler().postDelayed(()->{
            binding.imageView.setVisibility(View.INVISIBLE);
            binding.logo.setVisibility(View.VISIBLE);
        },2200);

    }

    private boolean isUserLoggedIn() {
        return false;
    }
}
