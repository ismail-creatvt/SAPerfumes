package com.saperfumes.dummyrepo;

import android.annotation.SuppressLint;
import android.view.View;

import com.saperfumes.R;
import com.saperfumes.models.ShoppingCartItem;

import java.util.ArrayList;

public class ShoppingCartRepository implements IShoppingCart{

    private static ShoppingCartRepository instance;
    private ArrayList<ShoppingCartItem> cartList = new ArrayList<>();

    private ShoppingCartRepository(){
        cartList.add(new ShoppingCartItem(1, ProductRepository.getInstance().getProductList("Attar").get(0), 2));
        cartList.add(new ShoppingCartItem(2, ProductRepository.getInstance().getProductList("Perfume").get(0), 1));
        cartList.add(new ShoppingCartItem(3, ProductRepository.getInstance().getProductList("Attar").get(2), 3));
    }

    public static ShoppingCartRepository getInstance(){
        if(instance == null){
            instance = new ShoppingCartRepository();
        }
        return instance;
    }

    public ArrayList<ShoppingCartItem> getCartList() {
        return cartList;
    }

    @Override
    public int getTotalItems(){
        int totalItems = 0;
        for(ShoppingCartItem item:cartList){
            totalItems += item.getQuantity();
        }
        return totalItems;
    }

    @Override
    public float getTotalPrice(){
        float totalPrice = 0f;
        for(ShoppingCartItem item:cartList){
            totalPrice += item.getQuantity() * item.getProduct().getProductPrice();
        }
        return totalPrice;
    }

    @Override
    public float getDelivery(){
        return 50f;
    }

    @Override
    @SuppressLint("DefaultLocale")
    public String getDeliveryString(View view){
        if(getDelivery() == 0){
            return view.getContext().getString(R.string.free);
        }
        return String.format("Rs. %.2f", getDelivery());
    }

    @Override
    public int getDeliveryStringColor(View view){
        if(getDelivery() == 0){
            return view.getContext().getResources().getColor(R.color.colorGreen);
        }
        return view.getContext().getResources().getColor(R.color.textColorNormal);
    }

    @Override
    public float getTotalPayable(){
        return getTotalPrice() + getDelivery();
    }

    @Override
    public String getPriceItemsString(View view){
        return view.getContext().getString(R.string.price_x_items, getTotalItems());
    }

}
