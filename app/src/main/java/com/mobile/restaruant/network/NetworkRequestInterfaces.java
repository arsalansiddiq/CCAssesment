package com.mobile.restaruant.network;



import com.mobile.restaruant.network.model.response.restaurant.PlacesResults;
import com.mobile.restaruant.network.model.response.weather.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NetworkRequestInterfaces {
    @GET("place/nearbysearch/json")
    Observable<PlacesResults> getNearBy(
            @Query("location") String location,
            @Query("rankby") String rankby,
            @Query("type") String type,
            @Query("key") String key
    );

    @GET("data/2.5/forecast")
    Observable<WeatherResponse> getForecast(
            @Query("lat") Double lat,
            @Query("lon") Double lon,
            @Query("APPID") String APPID
    );
}