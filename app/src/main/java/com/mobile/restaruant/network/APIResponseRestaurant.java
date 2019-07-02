package com.mobile.restaruant.network;

import com.mobile.restaruant.network.model.response.restaurant.PlacesResults;

import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;

import static com.mobile.restaruant.network.Status.ERROR;
import static com.mobile.restaruant.network.Status.LOADING;

public class APIResponseRestaurant {

    public Status status;

    @Nullable
    public PlacesResults data;

    @Nullable
    public Throwable error;

    private APIResponseRestaurant(Status status, @Nullable PlacesResults data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public APIResponseRestaurant() {
    }

    public static APIResponseRestaurant loading() {
        return new APIResponseRestaurant(LOADING, null, null);
    }

    public static APIResponseRestaurant success(@NonNull PlacesResults data) {
        return new APIResponseRestaurant(Status.SUCCESS, data, null);
    }

    public static APIResponseRestaurant error(@NonNull Throwable error) {
        return new APIResponseRestaurant(ERROR, null, error);
    }
}
