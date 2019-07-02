
package com.mobile.restaruant.network.model.response.weather;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Sys {

    @Expose
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

}
