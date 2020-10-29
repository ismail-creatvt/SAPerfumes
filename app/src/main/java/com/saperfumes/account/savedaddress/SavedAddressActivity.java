package com.saperfumes.account.savedaddress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivitySavedAddressBinding;
import com.saperfumes.dummyrepo.SavedAddressRepositiory;

import static com.saperfumes.account.savedaddress.AddEditSavedAddressActivity.SAVED_ADDRESS_ID;
import static com.saperfumes.payment.PaymentActivity.ADDRESS_ID;

public class SavedAddressActivity extends ToolbarActivity implements SavedAddressViewModel.SavedAddressListener {

    private static final int ADD_EDIT_ADDRESS_REQUEST = 3;
    public static final String IS_SELECT_ADDRESS = "IS_SELECT_ADDRESS";
    private ActivitySavedAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_saved_address);

        //Intitalize Viewmodel
        SavedAddressViewModel viewModel = new ViewModelProvider(this).get(SavedAddressViewModel.class);
        viewModel.setSavedAddressListener(this);

        //Initialize Adapter
        SavedAddressAdapter savedAddressAdapter = new SavedAddressAdapter();
        savedAddressAdapter.setViewModel(viewModel);
        savedAddressAdapter.setSavedAddresses(SavedAddressRepositiory.getInstance().getSavedAddresses());

        //Set Adapter and ViewModel to layout
        binding.setAdapter(savedAddressAdapter);
        binding.setViewModel(viewModel);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();
        setTitle("Saved Address");

    }

    @Override
    public void onEditClick(String id) {
        Intent intent = new Intent(this, AddEditSavedAddressActivity.class);
        intent.putExtra(SAVED_ADDRESS_ID, id);
        startActivityForResult(intent, ADD_EDIT_ADDRESS_REQUEST);
    }

    @Override
    public void onRemoveClick(String id) {
        SavedAddressRepositiory.getInstance().removeAddress(id);
        binding.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onAddNewClick() {
        startActivityForResult(new Intent(this, AddEditSavedAddressActivity.class), ADD_EDIT_ADDRESS_REQUEST);
    }

    @Override
    public void onAddressClick(String id) {
        if(getIntent() != null && getIntent().getBooleanExtra(IS_SELECT_ADDRESS, false)){
            Intent data = new Intent();
            data.putExtra(ADDRESS_ID, id);
            setResult(Activity.RESULT_OK, data);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_EDIT_ADDRESS_REQUEST && resultCode == Activity.RESULT_OK){
            binding.getAdapter().setSavedAddresses(SavedAddressRepositiory.getInstance().getSavedAddresses());
        }
    }
}
