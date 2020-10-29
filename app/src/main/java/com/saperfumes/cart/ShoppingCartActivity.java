package com.saperfumes.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityShoppingCartBinding;
import com.saperfumes.dummyrepo.ShoppingCartRepository;
import com.saperfumes.models.ShoppingCartItem;
import com.saperfumes.payment.PaymentActivity;

import java.util.List;

public class ShoppingCartActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShoppingCartBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_shopping_cart);
        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle("Shopping Cart");

        List<ShoppingCartItem> cartItems =  ShoppingCartRepository.getInstance().getCartList();

        binding.setAdapter(new ShoppingCartAdapter());
        binding.getAdapter().setShoppingCartItems(cartItems);

        if(cartItems.isEmpty()){
            binding.cartEmptyGroup.setVisibility(View.VISIBLE);
        } else{
            binding.cartGroup.setVisibility(View.VISIBLE);
        }

        binding.continueButton.setOnClickListener(v -> {
            startActivity(new Intent(this, PaymentActivity.class));
        });

        binding.shopNow.setOnClickListener((v)->{
            finish();
        });
    }
}
