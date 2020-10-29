package com.saperfumes.account.orders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityOrderDetailsBinding;
import com.saperfumes.dummyrepo.OrderRepository;
import com.saperfumes.models.OrderDetailsItem;
import com.saperfumes.payment.OrderSummaryAdapter;

public class OrderDetailsActivity extends ToolbarActivity {

    public static final String ORDER_ID = "ORDER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityOrderDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_order_details);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle(R.string.order_details);

        String id = getIntent().getStringExtra(ORDER_ID);
        OrderDetailsItem orderDetailsItem = OrderRepository.getInstance().getOrderDetailsForId(id);
        binding.setOrderDetail(orderDetailsItem);

        OrderSummaryAdapter orderSummaryAdapter = new OrderSummaryAdapter();
        orderSummaryAdapter.setItems(orderDetailsItem.getOrderItems());

        binding.setAdapter(orderSummaryAdapter);
    }
}
