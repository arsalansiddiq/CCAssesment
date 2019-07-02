package com.mobile.restaruant;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.restaruant.databinding.ListItemWeatherBinding;
import com.mobile.restaruant.viewmodels.RestaurantViewModel;

import java.util.List;


public class AdapterWeather extends RecyclerView.Adapter<AdapterWeather.GenericViewHolder> {

    private int layoutId;
    private List<com.mobile.restaruant.network.model.response.weather.List> weather;
    private RestaurantViewModel restaurantViewModel;

    public AdapterWeather(int layoutId, RestaurantViewModel restaurantViewModel) {
        this.layoutId = layoutId;
        this.restaurantViewModel = restaurantViewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return weather == null ? 0 : weather.size();
    }

    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemWeatherBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(restaurantViewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setDogBreeds(List<com.mobile.restaruant.network.model.response.weather.List> weather) {
        this.weather = this.weather;
    }

    class GenericViewHolder extends RecyclerView.ViewHolder {

        private final ListItemWeatherBinding binding;

        public GenericViewHolder(ListItemWeatherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RestaurantViewModel restaurantViewModel1, Integer position) {
//            restaurantViewModel1.imagesAt(position);

        }

    }
}