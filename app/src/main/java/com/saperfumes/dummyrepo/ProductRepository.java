package com.saperfumes.dummyrepo;

import com.saperfumes.R;
import com.saperfumes.product.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductRepository {

    private static ProductRepository instance;
    private ArrayList<Product> productList = new ArrayList<>();

    private ProductRepository(){
        productList.add(new Product(1, "Attar","Shamama Attar", 200, R.drawable.attar1));
        productList.add(new Product(2, "Attar","Ruh Gulab (Rose Attar)", 150, R.drawable.attar2));
        productList.add(new Product(3, "Attar","Ruh Khus Attar", 240, R.drawable.attar3));
        productList.add(new Product(4, "Attar","Black Oud Attar of Agarwood oil", 100, R.drawable.attar4));
        productList.add(new Product(5, "Attar","Mitti Attar", 210, R.drawable.attar5));
        productList.add(new Product(6, "Attar","Musk Attar", 241, R.drawable.attar6));
        productList.add(new Product(7, "Attar","Shamama Attar", 123, R.drawable.attar7));
        productList.add(new Product(8, "Attar","Ruh Gulab (Rose Attar)", 432, R.drawable.attar8));
        productList.add(new Product(9, "Attar","Ruh Khus Attar", 232, R.drawable.attar9));


        productList.add(new Product(10, "Electric Burner","Electric Bakhoor Burner", 322, R.drawable.burner1));
        productList.add(new Product(11, "Electric Burner","Electric Burner 40g", 423, R.drawable.burner2));
        productList.add(new Product(12, "Electric Burner","Dhoop Dani Burner", 423, R.drawable.burner3));
        productList.add(new Product(13, "Electric Burner","Automatic Insense burner", 432, R.drawable.burner4));
        productList.add(new Product(14, "Electric Burner","Electric Insense burner", 453, R.drawable.burner5));
        productList.add(new Product(15, "Electric Burner","Automatic Insense Burner", 665, R.drawable.burner6));
        productList.add(new Product(16, "Electric Burner","Electric Burner", 757, R.drawable.burner7));
        productList.add(new Product(17, "Electric Burner","Dhoop Dani Insense Burner", 453, R.drawable.burner8));


        productList.add(new Product(18, "Perfume","Bomb Cosmetics", 345, R.drawable.perfume1));
        productList.add(new Product(19, "Perfume","Britney Spears", 346, R.drawable.perfume2));
        productList.add(new Product(20, "Perfume","Brut", 565, R.drawable.perfume3));
        productList.add(new Product(21, "Perfume","Bvlgari", 343, R.drawable.perfume4));
        productList.add(new Product(22, "Perfume","Cacharel", 453, R.drawable.perfume5));
        productList.add(new Product(23, "Perfume","Carolina Herrera", 343, R.drawable.perfume6));
        productList.add(new Product(24, "Perfume","Cartier", 545, R.drawable.perfume7));
        productList.add(new Product(25, "Perfume","Chloé", 232, R.drawable.perfume8));
        productList.add(new Product(26, "Perfume","Coach", 342, R.drawable.perfume9));
        productList.add(new Product(27, "Perfume","Diesel", 545, R.drawable.perfume10));


        productList.add(new Product(28, "Loban","Guggal Loban", 234, R.drawable.loban1));
        productList.add(new Product(29, "Loban","Natural Loban", 123, R.drawable.loban2));
        productList.add(new Product(30, "Loban","Pure Sambrani Loban", 235, R.drawable.loban3));
        productList.add(new Product(31, "Loban","Natural Brown Loban Kodi", 56, R.drawable.loban4));
        productList.add(new Product(32, "Loban","Natural Loban", 654, R.drawable.loban5));
        productList.add(new Product(33, "Loban","Pure Loban", 453, R.drawable.loban6));
        productList.add(new Product(34, "Loban","Resin Sambrani Loban", 634, R.drawable.loban7));
        productList.add(new Product(35, "Loban","Natural Loban", 346, R.drawable.loban8));
        productList.add(new Product(36, "Loban","Pure Loban", 343, R.drawable.loban9));
    }

    public static ProductRepository getInstance(){
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public ArrayList<Product> getProductList(String category){
        ArrayList<Product> products = new ArrayList<>();
        for(Product p : productList){
            if(p.getCategory().equals(category)){
                products.add(p);
            }
        }
        return products;
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }

}
