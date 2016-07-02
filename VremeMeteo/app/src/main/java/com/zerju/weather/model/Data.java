
package com.zerju.weather.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Data {

    @SerializedName("current_condition")
    @Expose
    private List<CurrentCondition> currentCondition = new ArrayList<CurrentCondition>();
    @SerializedName("request")
    @Expose
    private List<Request> request = new ArrayList<Request>();
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = new ArrayList<Weather>();

    /**
     * 
     * @return
     *     The currentCondition
     */
    public List<CurrentCondition> getCurrentCondition() {
        return currentCondition;
    }

    /**
     * 
     * @param currentCondition
     *     The current_condition
     */
    public void setCurrentCondition(List<CurrentCondition> currentCondition) {
        this.currentCondition = currentCondition;
    }

    /**
     * 
     * @return
     *     The request
     */
    public List<Request> getRequest() {
        return request;
    }

    /**
     * 
     * @param request
     *     The request
     */
    public void setRequest(List<Request> request) {
        this.request = request;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

}
