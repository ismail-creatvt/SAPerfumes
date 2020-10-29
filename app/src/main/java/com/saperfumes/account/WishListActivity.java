package com.saperfumes.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toolbar;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityWishListBinding;

public class WishListActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWishListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_wish_list);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();

        setTitle("My Wishlist");
    }
}
