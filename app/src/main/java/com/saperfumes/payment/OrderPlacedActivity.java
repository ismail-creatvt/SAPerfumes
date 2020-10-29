package com.saperfumes.payment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.saperfumes.R;
import com.saperfumes.databinding.ActivityOrderPlacedBinding;
import com.saperfumes.home.HomeActivity;

public class OrderPlacedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOrderPlacedBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_order_placed);

        binding.continueShopping.setOnClickListener((v)->{
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }

}
