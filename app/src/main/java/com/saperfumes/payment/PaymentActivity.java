package com.saperfumes.payment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.account.savedaddress.SavedAddressActivity;
import com.saperfumes.databinding.ActivityPaymentBinding;
import com.saperfumes.dummyrepo.SavedAddressRepositiory;
import com.saperfumes.dummyrepo.ShoppingCartRepository;
import com.saperfumes.models.SavedAddress;

import static com.saperfumes.account.savedaddress.SavedAddressActivity.IS_SELECT_ADDRESS;

public class PaymentActivity extends ToolbarActivity {

    private static final int SELECT_ADDRESS_REQUEST = 2;
    public static final String ADDRESS_ID = "ADDRESS_ID";
    private ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payment);

        OrderSummaryAdapter summaryAdapter = new OrderSummaryAdapter();
        summaryAdapter.setItems(ShoppingCartRepository.getInstance().getCartList());

        binding.setOrderSummaryAdapter(summaryAdapter);
        binding.setShoppingCart(ShoppingCartRepository.getInstance());
        binding.setSavedAddress(SavedAddressRepositiory.getInstance().getAddress(0));

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle(R.string.checkout);

        binding.changeButton.setOnClickListener((v)->{
            Intent intent = new Intent(this, SavedAddressActivity.class);
            intent.putExtra(IS_SELECT_ADDRESS, true);
            startActivityForResult(intent, SELECT_ADDRESS_REQUEST);
        });

        binding.proceedToPayment.setOnClickListener((v)->{
            startActivity(new Intent(this, OrderPlacedActivity.class));
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_ADDRESS_REQUEST && resultCode == Activity.RESULT_OK && data != null){
            String id = data.getStringExtra(ADDRESS_ID);
            SavedAddress savedAddress = SavedAddressRepositiory.getInstance().getAddressFromId(id);
            binding.setSavedAddress(savedAddress);
        }
    }
}
