package com.saperfumes.account.savedaddress;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputLayout;
import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityAddEditSavedAddressBinding;
import com.saperfumes.dummyrepo.SavedAddressRepositiory;
import com.saperfumes.models.SavedAddress;

public class AddEditSavedAddressActivity extends ToolbarActivity implements AddEditSavedAddressViewModel.AddEditSavedAddressListener {

    public static final String SAVED_ADDRESS_ID = "id";
    private SavedAddress savedAddress;
    private ActivityAddEditSavedAddressBinding binding;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_saved_address);
        id = getIntent().getStringExtra(SAVED_ADDRESS_ID);

        savedAddress = SavedAddressRepositiory.getInstance().getAddressFromId(id);
        if(savedAddress == null){
            savedAddress = new SavedAddress();
        } else{
            savedAddress = savedAddress.createClone();
        }
        binding.setSavedAddress(savedAddress);

        AddEditSavedAddressViewModel viewModel = new ViewModelProvider(this).get(AddEditSavedAddressViewModel.class);
        viewModel.setAddEditSavedAddressListener(this);

        binding.setViewModel(viewModel);

        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();

        if(id != null) {
            setTitle(R.string.edit_address);
        } else{
            setTitle(R.string.add_new_address);
        }

    }

    @Override
    public void onDoneClick() {
        if(isValidData()){
            if(id == null){
                savedAddress.setId(String.valueOf(System.currentTimeMillis()/1000));
                SavedAddressRepositiory.getInstance().addAddress(savedAddress);
            } else{
                SavedAddressRepositiory.getInstance().updateAddress(savedAddress);
            }
            setResult(RESULT_OK);
            finish();
        }
    }

    private boolean isValidData() {
        if(!validateField(savedAddress.getHouse(), binding.houseLayout, R.string.please_enter_valid_house_no)) return false;
        if(!validateField(savedAddress.getRoad(), binding.roadLayout, R.string.please_enter_valid_road_name)) return false;
        if(!validateField(savedAddress.getCity(), binding.cityLayout, R.string.invalid_city)) return false;
        if(!validateField(savedAddress.getState(), binding.stateLayout, R.string.invalid_state)) return false;

        if(savedAddress.getPincode() != null && savedAddress.getPincode().length() != 6){
            binding.pincodeLayout.setError(getString(R.string.pincode_must_be_6_digits));
            return false;
        }

        if(!validateField(savedAddress.getName(), binding.nameLayout, R.string.please_enter_valid_name)) return false;

        if(savedAddress.getPhone() != null && savedAddress.getPhone().length() != 10){
            binding.phoneLayout.setError(getString(R.string.please_enter_valid_phone_number));
            return false;
        }
        return true;
    }

    private boolean validateField(String value, TextInputLayout field, int resInvalid){
        if(value == null || value.isEmpty()){
            field.setError(getString(R.string.this_field_is_required));
            return false;
        }

        if(value == null || value.length() < 3){
            field.setError(getString(resInvalid));
            return false;
        }
        return true;
    }
}
