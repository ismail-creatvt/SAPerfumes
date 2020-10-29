package com.saperfumes.product;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.databinding.ProductListItemLayoutBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ProductListItemLayoutBinding itemBinding;

    public ProductViewHolder(@NonNull ProductListItemLayoutBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }
}
