package com.saperfumes.cart;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.databinding.ShoppingCartItemBinding;
import com.saperfumes.databinding.ShoppingCartPriceCardLayoutBinding;
import com.saperfumes.dummyrepo.ShoppingCartRepository;
import com.saperfumes.models.ShoppingCartItem;

import java.util.List;


public class ShoppingCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ShoppingCartItem> shoppingCartItems;

    public void setShoppingCartItems(List<ShoppingCartItem> shoppingCartItems) {
        this.shoppingCartItems = shoppingCartItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(viewType == 1) {
            ShoppingCartItemBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.shopping_cart_item, parent, false);
            return new ShoppingCartViewHolder(itemBinding);
        }
        ShoppingCartPriceCardLayoutBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.shopping_cart_price_card_layout, parent, false);
        return new ShoppingCartPriceValueViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ShoppingCartViewHolder){
            ((ShoppingCartViewHolder) holder).itemBinding.setCartItem(shoppingCartItems.get(position));
        }
        if(holder instanceof ShoppingCartPriceValueViewHolder){
            ((ShoppingCartPriceValueViewHolder) holder).itemBinding.setShoppingCartRepository(ShoppingCartRepository.getInstance());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position < shoppingCartItems.size()){
            return 1;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return shoppingCartItems.size() + 1;
    }

    static class ShoppingCartViewHolder extends RecyclerView.ViewHolder{

        ShoppingCartItemBinding itemBinding;

        ShoppingCartViewHolder(@NonNull ShoppingCartItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    static class ShoppingCartPriceValueViewHolder extends RecyclerView.ViewHolder{

        ShoppingCartPriceCardLayoutBinding itemBinding;

        ShoppingCartPriceValueViewHolder(@NonNull ShoppingCartPriceCardLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
