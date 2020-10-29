package com.saperfumes.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.databinding.OrderSummaryListItemBinding;
import com.saperfumes.models.ShoppingCartItem;

import java.util.List;

public class OrderSummaryAdapter extends RecyclerView.Adapter<OrderSummaryAdapter.OrderSummaryViewHolder>{

    private List<ShoppingCartItem> items;

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderSummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OrderSummaryListItemBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.order_summary_list_item, parent, false);
        return new OrderSummaryViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderSummaryViewHolder holder, int position) {
        holder.itemBinding.setItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class OrderSummaryViewHolder extends RecyclerView.ViewHolder{

        private final OrderSummaryListItemBinding itemBinding;

        public OrderSummaryViewHolder(@NonNull OrderSummaryListItemBinding itemBinding) {
            super(itemBinding.getRoot());

            this.itemBinding = itemBinding;
        }
    }
}
