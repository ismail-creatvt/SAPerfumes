package com.saperfumes.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.saperfumes.BaseActivity;
import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityProductDetailBinding;

public class ProductDetailActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
    }
}
