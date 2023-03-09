package com.example.a11gacadmey.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class config {


    @BindingAdapter("android:ImageUrl")
    public static void ImageData(ImageView view, String Url){
        Glide.with(view).load(Url).fitCenter().into(view);
    }



}
