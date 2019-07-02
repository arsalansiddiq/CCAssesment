package com.mobile.restaruant.network;

import com.mobile.restaruant.network.model.response.restaurant.PlacesResults;
import com.mobile.restaruant.network.model.response.weather.WeatherResponse;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.mobile.restaruant.network.Status.ERROR;
import static com.mobile.restaruant.network.Status.LOADING;

public class APIResponseWeather {

    public Status status;

    @Nullable
    public WeatherResponse data;

    @Nullable
    public Throwable error;

    private APIResponseWeather(Status status, @Nullable WeatherResponse data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public APIResponseWeather() {
    }

    public static APIResponseWeather loading() {
        return new APIResponseWeather(LOADING, null, null);
    }

    public static APIResponseWeather success(@NonNull WeatherResponse data) {
        return new APIResponseWeather(Status.SUCCESS, data, null);
    }

    public static APIResponseWeather error(@NonNull Throwable error) {
        return new APIResponseWeather(ERROR, null, error);
    }
}
