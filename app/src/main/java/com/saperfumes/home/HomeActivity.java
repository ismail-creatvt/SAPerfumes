package com.saperfumes.home;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.saperfumes.BaseActivity;
import com.saperfumes.R;
import com.saperfumes.account.MyAccountActivity;
import com.saperfumes.account.orders.MyOrdersActivity;
import com.saperfumes.account.savedaddress.SavedAddressActivity;
import com.saperfumes.cart.ShoppingCartActivity;
import com.saperfumes.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(R.drawable.attar_image, "Attar"));
        categories.add(new Category(R.drawable.perfumes, "Perfume"));
        categories.add(new Category(R.drawable.loban_image, "Loban"));
        categories.add(new Category(R.drawable.electric_burner, "Electric Burner"));

        binding.categories.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return CategoryFragment.getInstance(categories.get(position));
            }

            @Override
            public int getCount() {
                return categories.size();
            }
        });

        binding.bottomAppBar.setOnMenuItemClickListener(this);
        binding.cart.setOnClickListener((v)->{
            startActivity(new Intent(this, ShoppingCartActivity.class));
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.my_orders:
                startActivity(new Intent(this, MyOrdersActivity.class));
                return true;
            case R.id.my_account:
                startActivity(new Intent(this, MyAccountActivity.class));
                return true;
            case R.id.saved_location:
                startActivity(new Intent(this, SavedAddressActivity.class));
                return true;
//            case R.id.wishlist:
//                startActivity(new Intent(this, WishListActivity.class));
//                return true;
        }
        return false;
    }

    static class Category{
        public int categoryImage;
        public String categoryName;

        public Category(int categoryImage, String categoryName) {
            this.categoryImage = categoryImage;
            this.categoryName = categoryName;
        }
    }
}
