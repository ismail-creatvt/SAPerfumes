package com.saperfumes.account.orders;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityMyOrdersBinding;
import com.saperfumes.dummyrepo.OrderRepository;
import com.saperfumes.models.OrderDetailsItem;

import static com.saperfumes.account.orders.OrderDetailsActivity.ORDER_ID;

public class MyOrdersActivity extends ToolbarActivity implements OrderAdapter.OrderClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMyOrdersBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_my_orders);
        OrderAdapter orderAdapter = new OrderAdapter();
        orderAdapter.setOrderDetailsItems(OrderRepository.getInstance().getOrderDetails());
        orderAdapter.setOrderClickListener(this);

        binding.setAdapter(orderAdapter);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle("My Orders");
    }

    @Override
    public void onOrderClick(String id) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra(ORDER_ID, id);
        startActivity(intent);
    }
}
