package com.saperfumes.utility;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingUtils {

    @BindingAdapter("imageRes")
    public static void setImageResource(ImageView imageView, int res){
        imageView.setImageResource(res);
    }
}
