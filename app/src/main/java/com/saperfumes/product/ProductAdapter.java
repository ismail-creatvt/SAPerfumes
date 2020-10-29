package com.saperfumes.product;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.databinding.ProductListItemLayoutBinding;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    public List<Product> productList;

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductListItemLayoutBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.product_list_item_layout, parent, false);
        return new ProductViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.itemBinding.setProduct(productList.get(position));
        Context context = holder.itemBinding.getRoot().getContext();
        holder.itemBinding.getRoot().setOnClickListener((v)->{
            context.startActivity(new Intent(context, ProductDetailActivity.class));
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}
