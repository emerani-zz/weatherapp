
package com.ezraerani.weatherappc4q.responsemodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherCoded {

    @SerializedName("timestamp")
    @Expose
    private int timestamp;
    @SerializedName("wx")
    @Expose
    private String wx;
    @SerializedName("dateTimeISO")
    @Expose
    private String dateTimeISO;

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }

}
