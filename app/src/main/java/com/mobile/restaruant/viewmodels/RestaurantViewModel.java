package com.mobile.restaruant.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mobile.restaruant.network.APIResponseRestaurant;
import com.mobile.restaruant.network.APIResponseWeather;
import com.mobile.restaruant.network.NetworkCalls;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class RestaurantViewModel extends ViewModel {
    private NetworkCalls networkCalls = new NetworkCalls();
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<APIResponseRestaurant> responseLiveData = new MutableLiveData<>();
    private final MutableLiveData<APIResponseWeather> responseLiveDataWeather = new MutableLiveData<>();

    public MutableLiveData<APIResponseRestaurant> getResponseLiveData() {
        return responseLiveData;
    }

    public MutableLiveData<APIResponseWeather> getWeather() {
        return responseLiveDataWeather;
    }

    public void getRestaurants() {
        disposables.add(networkCalls.getRestaurants()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe((r) -> responseLiveData.setValue(APIResponseRestaurant.loading()))
        .subscribe(
                result -> responseLiveData.setValue(APIResponseRestaurant.success(result)),
                        throwable -> responseLiveData.setValue(APIResponseRestaurant.error(throwable))
                ));
    }

    public void getWeatherForecast() {
        disposables.add(networkCalls.getForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((r) -> responseLiveDataWeather.setValue(APIResponseWeather.loading()))
                .subscribe(
                        result -> responseLiveDataWeather.setValue(APIResponseWeather.success(result)),
                        throwable -> responseLiveDataWeather.setValue(APIResponseWeather.error(throwable))
                ));
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }

//    public void imagesAt(Integer position) {
//    }
}
