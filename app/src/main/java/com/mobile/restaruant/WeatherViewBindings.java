package com.mobile.restaruant;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class WeatherViewBindings {

    @BindingAdapter("adapterWeather")
    public static void bindRecyclarViewAdapterWeather(RecyclerView recyclerView, RecyclerView.Adapter<?> adapter) {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            // If we don't do this, you'll see the old image appear briefly
            // before it's replaced with the current image
            if (imageView.getTag(R.id.imgView_weatherImage) == null || !imageView.getTag(R.id.imgView_weatherImage).equals(imageUrl)) {
                imageView.setImageBitmap(null);
                imageView.setTag(R.id.imgView_weatherImage, imageUrl);
                Glide.with(imageView).load(imageUrl).into(imageView);
            }
        } else {
            imageView.setTag(R.id.imgView_weatherImage, null);
            imageView.setImageBitmap(null);
        }
    }
}
