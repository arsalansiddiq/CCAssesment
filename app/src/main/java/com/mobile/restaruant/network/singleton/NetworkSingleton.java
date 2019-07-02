package com.mobile.restaruant.network.singleton;


import com.mobile.restaruant.network.NetworkCalls;

public class NetworkSingleton {

    private static NetworkCalls sNetworkCalls;

    public static NetworkCalls getNetworkCallInstance() {
        if (sNetworkCalls == null)
        {
            sNetworkCalls = new NetworkCalls();
        }

        return sNetworkCalls;
    }



}
