package com.mobile.restaruant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mobile.restaruant.databinding.ActivityMainBinding;
import com.mobile.restaruant.network.APIResponseRestaurant;
import com.mobile.restaruant.network.APIResponseWeather;
import com.mobile.restaruant.network.model.response.restaurant.PlacesResults;
import com.mobile.restaruant.network.model.response.weather.WeatherResponse;
import com.mobile.restaruant.viewmodels.RestaurantViewModel;

import io.reactivex.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RestaurantViewModel restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel.class);
        binding.setRestaurantViewModel(restaurantViewModel);
        binding.setLifecycleOwner(this);

//        binding.getRestaurantViewModel().getRestaurants();
        binding.getRestaurantViewModel().getWeatherForecast();

//        restaurantViewModel.getResponseLiveData().observe(this, new Observer<APIResponseRestaurant>() {
//            @Override
//            public void onChanged(@Nullable APIResponseRestaurant apiResponseRestaurant) {
//                consumeResponseRestaurant(apiResponseRestaurant);
//            }
//        });

        restaurantViewModel.getWeather().observe(this, new Observer<APIResponseWeather>() {
            @Override
            public void onChanged(@Nullable APIResponseWeather apiResponseWeather) {
                consumeResponseWeather(apiResponseWeather);
            }
        });
    }

    private void consumeResponseWeather(APIResponseWeather apiResponseWeather) {
        switch (apiResponseWeather.status) {

            case LOADING:
                Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
                renderSuccessResponseWeather(apiResponseWeather.data);
                break;

            case ERROR:
                Toast.makeText(this,getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    private void renderSuccessResponseWeather(WeatherResponse data) {
        if (data != null) {
            Log.d("response=", data.toString());
        } else {
            Toast.makeText(this,getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }

    private void consumeResponseRestaurant(APIResponseRestaurant apiResponseRestaurant) {

        switch (apiResponseRestaurant.status) {

            case LOADING:
                Toast.makeText(this, "loading...", Toast.LENGTH_SHORT).show();
                break;

            case SUCCESS:
                renderSuccessResponse(apiResponseRestaurant.data);
                break;

            case ERROR:
                Toast.makeText(this,"something went wrong", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }

    /*
     * method to handle success response
     * */
    private void renderSuccessResponse(PlacesResults response) {
        if (response != null) {
            Log.d("response=", response.toString());
        } else {
            Toast.makeText(this,getResources().getString(R.string.errorString), Toast.LENGTH_SHORT).show();
        }
    }

}
