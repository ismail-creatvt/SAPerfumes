package com.saperfumes.product;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.saperfumes.R;
import com.saperfumes.ToolbarActivity;
import com.saperfumes.databinding.ActivityProductBinding;
import com.saperfumes.dummyrepo.ProductRepository;

import java.util.ArrayList;
import java.util.List;

import static com.saperfumes.utility.Constant.CATEGORY_NAME;

public class ProductActivity extends ToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityProductBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product);
        setToolbar(binding.toolbar);
        setHomeAsUpEnabled();

        String category = getIntent().getStringExtra(CATEGORY_NAME);
        setTitle(category);

        handleIntent(getIntent());

        binding.productList.setAdapter(new ProductAdapter(ProductRepository.getInstance().getProductList(category)));
        binding.productList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        searchItem.setActionView(R.layout.product_search_layout);
        SearchView searchView =
                (SearchView) searchItem.getActionView();

        if(searchManager != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        }
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.d("SearchableActivity","Search query : " + query);
        }
    }
}
