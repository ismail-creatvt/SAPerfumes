package com.saperfumes.account.savedaddress;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.databinding.SavedAddressItemLayoutBinding;
import com.saperfumes.models.SavedAddress;

import java.util.ArrayList;

public class SavedAddressAdapter extends RecyclerView.Adapter<SavedAddressAdapter.SavedAddressViewHolder> {

    private ArrayList<SavedAddress> savedAddresses = new ArrayList<>();
    private SavedAddressViewModel viewModel;

    public void setSavedAddresses(ArrayList<SavedAddress> savedAddresses) {
        this.savedAddresses = savedAddresses;
        notifyDataSetChanged();
    }

    public void setViewModel(SavedAddressViewModel viewModel){
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public SavedAddressViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SavedAddressItemLayoutBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.saved_address_item_layout, parent, false);
        return new SavedAddressViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedAddressViewHolder holder, int position) {
        holder.itemBinding.setSavedAddress(savedAddresses.get(position));
        holder.itemBinding.setViewModel(viewModel);
    }

    @Override
    public int getItemCount() {
        return savedAddresses.size();
    }

    static class SavedAddressViewHolder extends RecyclerView.ViewHolder{

        SavedAddressItemLayoutBinding itemBinding;

        SavedAddressViewHolder(@NonNull SavedAddressItemLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
