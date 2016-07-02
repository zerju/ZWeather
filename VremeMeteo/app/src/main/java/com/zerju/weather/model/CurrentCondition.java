
package com.zerju.weather.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class CurrentCondition {

    @SerializedName("cloudcover")
    @Expose
    private String cloudcover;
    @SerializedName("FeelsLikeC")
    @Expose
    private String FeelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    private String FeelsLikeF;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("observation_time")
    @Expose
    private String observationTime;
    @SerializedName("precipMM")
    @Expose
    private String precipMM;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("temp_C")
    @Expose
    private String tempC;
    @SerializedName("temp_F")
    @Expose
    private String tempF;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("weatherCode")
    @Expose
    private String weatherCode;
    @SerializedName("weatherDesc")
    @Expose
    private List<WeatherDesc> weatherDesc = new ArrayList<WeatherDesc>();
    @SerializedName("weatherIconUrl")
    @Expose
    private List<WeatherIconUrl> weatherIconUrl = new ArrayList<WeatherIconUrl>();
    @SerializedName("winddir16Point")
    @Expose
    private String winddir16Point;
    @SerializedName("winddirDegree")
    @Expose
    private String winddirDegree;
    @SerializedName("windspeedKmph")
    @Expose
    private String windspeedKmph;
    @SerializedName("windspeedMiles")
    @Expose
    private String windspeedMiles;

    /**
     * 
     * @return
     *     The cloudcover
     */
    public String getCloudcover() {
        return cloudcover;
    }

    /**
     * 
     * @param cloudcover
     *     The cloudcover
     */
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    /**
     * 
     * @return
     *     The FeelsLikeC
     */
    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    /**
     * 
     * @param FeelsLikeC
     *     The FeelsLikeC
     */
    public void setFeelsLikeC(String FeelsLikeC) {
        this.FeelsLikeC = FeelsLikeC;
    }

    /**
     * 
     * @return
     *     The FeelsLikeF
     */
    public String getFeelsLikeF() {
        return FeelsLikeF;
    }

    /**
     * 
     * @param FeelsLikeF
     *     The FeelsLikeF
     */
    public void setFeelsLikeF(String FeelsLikeF) {
        this.FeelsLikeF = FeelsLikeF;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The observationTime
     */
    public String getObservationTime() {
        return observationTime;
    }

    /**
     * 
     * @param observationTime
     *     The observation_time
     */
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    /**
     * 
     * @return
     *     The precipMM
     */
    public String getPrecipMM() {
        return precipMM;
    }

    /**
     * 
     * @param precipMM
     *     The precipMM
     */
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    public String getTempC() {
        return tempC;
    }

    /**
     * 
     * @param tempC
     *     The temp_C
     */
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * @return
     *     The tempF
     */
    public String getTempF() {
        return tempF;
    }

    /**
     * 
     * @param tempF
     *     The temp_F
     */
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    /**
     * 
     * @return
     *     The weatherCode
     */
    public String getWeatherCode() {
        return weatherCode;
    }

    /**
     * 
     * @param weatherCode
     *     The weatherCode
     */
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    /**
     * 
     * @return
     *     The weatherDesc
     */
    public List<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    /**
     * 
     * @param weatherDesc
     *     The weatherDesc
     */
    public void setWeatherDesc(List<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    /**
     * 
     * @return
     *     The weatherIconUrl
     */
    public List<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     * 
     * @param weatherIconUrl
     *     The weatherIconUrl
     */
    public void setWeatherIconUrl(List<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    /**
     * 
     * @return
     *     The winddir16Point
     */
    public String getWinddir16Point() {
        return winddir16Point;
    }

    /**
     * 
     * @param winddir16Point
     *     The winddir16Point
     */
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    /**
     * 
     * @return
     *     The winddirDegree
     */
    public String getWinddirDegree() {
        return winddirDegree;
    }

    /**
     * 
     * @param winddirDegree
     *     The winddirDegree
     */
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    /**
     * 
     * @return
     *     The windspeedKmph
     */
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    /**
     * 
     * @param windspeedKmph
     *     The windspeedKmph
     */
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    /**
     * 
     * @return
     *     The windspeedMiles
     */
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    /**
     * 
     * @param windspeedMiles
     *     The windspeedMiles
     */
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

}
