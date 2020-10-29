package com.saperfumes.account.orders;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.saperfumes.R;
import com.saperfumes.databinding.OrderItemLayoutBinding;
import com.saperfumes.models.OrderDetailsItem;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private List<OrderDetailsItem> orderDetailsItems;
    private OrderClickListener orderClickListener;

    void setOrderClickListener(OrderClickListener orderClickListener) {
        this.orderClickListener = orderClickListener;
    }

    void setOrderDetailsItems(List<OrderDetailsItem> orderDetailsItems) {
        this.orderDetailsItems = orderDetailsItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        OrderItemLayoutBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.order_item_layout, parent, false);
        return new OrderViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.itemBinding.setOrderDetail(orderDetailsItems.get(position));
        holder.itemBinding.setOrderClickListener(orderClickListener);
    }

    @Override
    public int getItemCount() {
        return orderDetailsItems.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder{

        final OrderItemLayoutBinding itemBinding;

        OrderViewHolder(@NonNull OrderItemLayoutBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public interface OrderClickListener{
        void onOrderClick(String id);
    }
}
