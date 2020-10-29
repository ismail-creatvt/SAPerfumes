package com.saperfumes.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saperfumes.R;
import com.saperfumes.databinding.FragmentCategoryBinding;
import com.saperfumes.product.ProductActivity;

import static com.saperfumes.utility.Constant.CATEGORY_IMAGE;
import static com.saperfumes.utility.Constant.CATEGORY_NAME;

public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding binding;

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment getInstance(HomeActivity.Category category){
        CategoryFragment fragment = new CategoryFragment();
        Bundle data = new Bundle();
        data.putString(CATEGORY_NAME, category.categoryName);
        data.putInt(CATEGORY_IMAGE, category.categoryImage);
        fragment.setArguments(data);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_category, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(getArguments() != null){
            int categoryImage = getArguments().getInt(CATEGORY_IMAGE);
            String categoryName = getArguments().getString(CATEGORY_NAME);

            binding.categoryImage.setImageResource(categoryImage);
            binding.categoryName.setText(categoryName);

            binding.categoryCard.setOnClickListener((v)->{
                Intent intent = new Intent(getActivity(), ProductActivity.class);
                intent.putExtra(CATEGORY_NAME, categoryName);
                startActivity(intent);
            });

        }

    }
}
