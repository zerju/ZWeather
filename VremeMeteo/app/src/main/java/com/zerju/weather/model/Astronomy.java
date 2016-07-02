
package com.zerju.weather.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Astronomy {

    @SerializedName("moonrise")
    @Expose
    private String moonrise;
    @SerializedName("moonset")
    @Expose
    private String moonset;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;

    /**
     * 
     * @return
     *     The moonrise
     */
    public String getMoonrise() {
        return moonrise;
    }

    /**
     * 
     * @param moonrise
     *     The moonrise
     */
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    /**
     * 
     * @return
     *     The moonset
     */
    public String getMoonset() {
        return moonset;
    }

    /**
     * 
     * @param moonset
     *     The moonset
     */
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    /**
     * 
     * @return
     *     The sunrise
     */
    public String getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @param sunrise
     *     The sunrise
     */
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * 
     * @return
     *     The sunset
     */
    public String getSunset() {
        return sunset;
    }

    /**
     * 
     * @param sunset
     *     The sunset
     */
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
