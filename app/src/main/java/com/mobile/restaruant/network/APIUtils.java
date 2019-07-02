package com.mobile.restaruant.network;


import com.mobile.restaruant.network.configuration.Constants;
import com.mobile.restaruant.network.singleton.APIClient;

public class APIUtils {

    private APIUtils() {

    }

    public static NetworkRequestInterfaces getConnection() {
        return APIClient.getRetrofitClient(Constants.BASE_URL_OPENWEATHER).create(NetworkRequestInterfaces.class);
    }
}
