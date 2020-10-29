package com.saperfumes.account;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.account.savedaddress.SavedAddressActivity;
import com.saperfumes.databinding.ActivityMyAccountBinding;

public class MyAccountActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMyAccountBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_my_account);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle("My Account");

        binding.resetPassword.setOnClickListener((v)->{

        });

        binding.savedAddresses.setOnClickListener((v)->{
            startActivity(new Intent(this, SavedAddressActivity.class));
        });
    }
}
