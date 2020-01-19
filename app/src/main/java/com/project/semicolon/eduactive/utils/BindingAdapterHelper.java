package com.project.semicolon.eduactive.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class BindingAdapterHelper {
    @BindingAdapter("imageSrc")
    public static void load(ImageView imageView, int resId) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(resId)
                .into(imageView);
    }

    @BindingAdapter("loadImage")
    public static void load(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
