package com.saperfumes.dummyrepo;

import android.view.View;

import com.saperfumes.R;
import com.saperfumes.models.ShoppingCartItem;

public interface IShoppingCart {

    int getTotalItems();

    float getTotalPrice();

    float getDelivery();

    String getDeliveryString(View view);

    int getDeliveryStringColor(View view);

    float getTotalPayable();

    String getPriceItemsString(View view);

}
