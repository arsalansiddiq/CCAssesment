package com.mobile.restaruant;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.mobile.restaruant.viewmodels.WeatherViewModel;

public class SplashActivity extends AppCompatActivity {

    private long holdTime = 2000;
    private WeatherViewModel weatherViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setupBinding(savedInstanceState);
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
//        WeatherViewModel weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
//        binding.setRestaurantViewModel(weatherViewModel);
//        binding.setLifecycleOwner(this);

//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//        } else {
//            init();
//        }
    }

    private void setupBinding(Bundle savedInstanceState) {
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        if (savedInstanceState == null) {
            weatherViewModel.init();
        }

//        setupListUpdate();
    }

    private void init() {
        final Handler handler = new Handler();
        try {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Launching Map Activity
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }, holdTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            init();
        } else {
            Toast.makeText(this, "not granted!", Toast.LENGTH_SHORT).show();
        }
    }
}
