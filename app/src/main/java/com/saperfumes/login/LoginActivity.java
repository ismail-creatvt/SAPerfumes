package com.saperfumes.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;

import com.saperfumes.BaseActivity;
import com.saperfumes.R;
import com.saperfumes.databinding.ActivityLoginBinding;
import com.saperfumes.databinding.ActivityProductBinding;
import com.saperfumes.home.HomeActivity;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.loginButton.setOnClickListener((v)->{
            goToHomeScreen();
        });

        binding.skip.setOnClickListener((v)->{
            goToHomeScreen();
        });
    }

    private void goToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this, Pair.create(binding.logo, "logo"),
                        Pair.create(binding.appName, "app_name"));
        startActivity(intent, options.toBundle());
        new Handler().postDelayed(this::finish,1000);
    }
}
