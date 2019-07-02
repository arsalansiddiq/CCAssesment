package com.mobile.restaruant.network;

import com.mobile.restaruant.network.model.response.restaurant.PlacesResults;
import com.mobile.restaruant.network.model.response.weather.WeatherResponse;

import io.reactivex.Observable;

import static com.mobile.restaruant.network.configuration.Constants.APPID_OPENWEATHER;

public class NetworkCalls {

    public NetworkCalls(){

    }

    private final String LOG_TAG = NetworkCalls.class.getName();

    private static NetworkRequestInterfaces sNetworkRequestInterfaces = APIUtils.getConnection();

    public Observable<PlacesResults> getRestaurants() {
        return sNetworkRequestInterfaces.getNearBy("24.861098,67.070343","distance","food","AIzaSyA_4_ZncFAl9IK0WwEXh2wkPMKCveYD878");
    }

    public Observable<WeatherResponse> getForecast() {
        return sNetworkRequestInterfaces.getForecast(24.861098,67.070343, APPID_OPENWEATHER);
    }


}
