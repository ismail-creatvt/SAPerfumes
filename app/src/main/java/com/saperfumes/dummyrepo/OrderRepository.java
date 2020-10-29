package com.saperfumes.dummyrepo;

import com.saperfumes.models.OrderDetailsItem;
import com.saperfumes.models.OrderItem;
import com.saperfumes.models.ShoppingCartItem;
import com.saperfumes.product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<OrderDetailsItem> orderDetails;

    private static OrderRepository instance;

    private OrderRepository(){
        ProductRepository productRepository = ProductRepository.getInstance();
        List<Product> products = productRepository.getProductList();

        orderDetails = new ArrayList<>();
        ShoppingCartItem orderItem1 = new ShoppingCartItem(0, products.get(0), 2);
        ShoppingCartItem orderItem2 = new ShoppingCartItem(0, products.get(1), 2);
        ShoppingCartItem orderItem3 = new ShoppingCartItem(0, products.get(2), 2);
        ShoppingCartItem orderItem4 = new ShoppingCartItem(0, products.get(5), 2);
        ShoppingCartItem orderItem5 = new ShoppingCartItem(0, products.get(6), 2);
        ShoppingCartItem orderItem6 = new ShoppingCartItem(0, products.get(10), 2);
        ShoppingCartItem orderItem7 = new ShoppingCartItem(0, products.get(14), 2);
        ShoppingCartItem orderItem8 = new ShoppingCartItem(0, products.get(18), 2);
        List<ShoppingCartItem> order1Items = new ArrayList<>();
        order1Items.add(orderItem1);
        order1Items.add(orderItem2);
        order1Items.add(orderItem3);
        List<ShoppingCartItem> order2Items = new ArrayList<>();
        order2Items.add(orderItem4);
        order2Items.add(orderItem5);
        order2Items.add(orderItem6);
        List<ShoppingCartItem> order3Items = new ArrayList<>();
        order3Items.add(orderItem7);
        order3Items.add(orderItem8);
        orderDetails.add(new OrderDetailsItem("1", order1Items, "10 August 2019","10 August 2019",  "Credit Card", true,3032f));
        orderDetails.add(new OrderDetailsItem("2", order2Items, "20 November 2019", "10 August 2019", "Debit Card", true, 4893f));
        orderDetails.add(new OrderDetailsItem("3", order3Items, "31 March 2020", "3 April 2020", "Cash On Delivery", false, 320));
    }

    public static OrderRepository getInstance(){
        if(instance == null){
            instance = new OrderRepository();
        }
        return instance;
    }

    public List<OrderDetailsItem> getOrderDetails() {
        return orderDetails;
    }

    public OrderDetailsItem getOrderDetailsForId(String id){
        int position = getPositionForId(id);
        if(position == -1){
            return null;
        }
        return orderDetails.get(position);
    }

    private int getPositionForId(String id) {
        int position = -1;
        for(int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getId().equals(id)){
                position = i;
                break;
            }
        }
        return position;
    }
}
