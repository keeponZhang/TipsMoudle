package com.example.mvmm.component;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class DemoBindingAdapter {

    private static final boolean IS_TESTING = true;

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImageFromUrl(ImageView view,
                                        String url,
                                        Drawable drawable) {
        Glide.with(view.getContext())
                .load(url)
                .placeholder(drawable)
                .into(view);
    }


}
