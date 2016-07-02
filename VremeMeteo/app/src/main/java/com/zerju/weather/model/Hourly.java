
package com.zerju.weather.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Hourly {

    @SerializedName("chanceoffog")
    @Expose
    private String chanceoffog;
    @SerializedName("chanceoffrost")
    @Expose
    private String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    private String chanceofhightemp;
    @SerializedName("chanceofovercast")
    @Expose
    private String chanceofovercast;
    @SerializedName("chanceofrain")
    @Expose
    private String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    private String chanceofremdry;
    @SerializedName("chanceofsnow")
    @Expose
    private String chanceofsnow;
    @SerializedName("chanceofsunshine")
    @Expose
    private String chanceofsunshine;
    @SerializedName("chanceofthunder")
    @Expose
    private String chanceofthunder;
    @SerializedName("chanceofwindy")
    @Expose
    private String chanceofwindy;
    @SerializedName("cloudcover")
    @Expose
    private String cloudcover;
    @SerializedName("DewPointC")
    @Expose
    private String DewPointC;
    @SerializedName("DewPointF")
    @Expose
    private String DewPointF;
    @SerializedName("FeelsLikeC")
    @Expose
    private String FeelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    private String FeelsLikeF;
    @SerializedName("HeatIndexC")
    @Expose
    private String HeatIndexC;
    @SerializedName("HeatIndexF")
    @Expose
    private String HeatIndexF;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("precipMM")
    @Expose
    private String precipMM;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("tempC")
    @Expose
    private String tempC;
    @SerializedName("tempF")
    @Expose
    private String tempF;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("weatherCode")
    @Expose
    private String weatherCode;
    @SerializedName("weatherDesc")
    @Expose
    private List<WeatherDesc_> weatherDesc = new ArrayList<WeatherDesc_>();
    @SerializedName("weatherIconUrl")
    @Expose
    private List<WeatherIconUrl_> weatherIconUrl = new ArrayList<WeatherIconUrl_>();
    @SerializedName("WindChillC")
    @Expose
    private String WindChillC;
    @SerializedName("WindChillF")
    @Expose
    private String WindChillF;
    @SerializedName("winddir16Point")
    @Expose
    private String winddir16Point;
    @SerializedName("winddirDegree")
    @Expose
    private String winddirDegree;
    @SerializedName("WindGustKmph")
    @Expose
    private String WindGustKmph;
    @SerializedName("WindGustMiles")
    @Expose
    private String WindGustMiles;
    @SerializedName("windspeedKmph")
    @Expose
    private String windspeedKmph;
    @SerializedName("windspeedMiles")
    @Expose
    private String windspeedMiles;

    /**
     * 
     * @return
     *     The chanceoffog
     */
    public String getChanceoffog() {
        return chanceoffog;
    }

    /**
     * 
     * @param chanceoffog
     *     The chanceoffog
     */
    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    /**
     * 
     * @return
     *     The chanceoffrost
     */
    public String getChanceoffrost() {
        return chanceoffrost;
    }

    /**
     * 
     * @param chanceoffrost
     *     The chanceoffrost
     */
    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    /**
     * 
     * @return
     *     The chanceofhightemp
     */
    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    /**
     * 
     * @param chanceofhightemp
     *     The chanceofhightemp
     */
    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    /**
     * 
     * @return
     *     The chanceofovercast
     */
    public String getChanceofovercast() {
        return chanceofovercast;
    }

    /**
     * 
     * @param chanceofovercast
     *     The chanceofovercast
     */
    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    /**
     * 
     * @return
     *     The chanceofrain
     */
    public String getChanceofrain() {
        return chanceofrain;
    }

    /**
     * 
     * @param chanceofrain
     *     The chanceofrain
     */
    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    /**
     * 
     * @return
     *     The chanceofremdry
     */
    public String getChanceofremdry() {
        return chanceofremdry;
    }

    /**
     * 
     * @param chanceofremdry
     *     The chanceofremdry
     */
    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    /**
     * 
     * @return
     *     The chanceofsnow
     */
    public String getChanceofsnow() {
        return chanceofsnow;
    }

    /**
     * 
     * @param chanceofsnow
     *     The chanceofsnow
     */
    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    /**
     * 
     * @return
     *     The chanceofsunshine
     */
    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    /**
     * 
     * @param chanceofsunshine
     *     The chanceofsunshine
     */
    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    /**
     * 
     * @return
     *     The chanceofthunder
     */
    public String getChanceofthunder() {
        return chanceofthunder;
    }

    /**
     * 
     * @param chanceofthunder
     *     The chanceofthunder
     */
    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    /**
     * 
     * @return
     *     The chanceofwindy
     */
    public String getChanceofwindy() {
        return chanceofwindy;
    }

    /**
     * 
     * @param chanceofwindy
     *     The chanceofwindy
     */
    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

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
     *     The DewPointC
     */
    public String getDewPointC() {
        return DewPointC;
    }

    /**
     * 
     * @param DewPointC
     *     The DewPointC
     */
    public void setDewPointC(String DewPointC) {
        this.DewPointC = DewPointC;
    }

    /**
     * 
     * @return
     *     The DewPointF
     */
    public String getDewPointF() {
        return DewPointF;
    }

    /**
     * 
     * @param DewPointF
     *     The DewPointF
     */
    public void setDewPointF(String DewPointF) {
        this.DewPointF = DewPointF;
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
     *     The HeatIndexC
     */
    public String getHeatIndexC() {
        return HeatIndexC;
    }

    /**
     * 
     * @param HeatIndexC
     *     The HeatIndexC
     */
    public void setHeatIndexC(String HeatIndexC) {
        this.HeatIndexC = HeatIndexC;
    }

    /**
     * 
     * @return
     *     The HeatIndexF
     */
    public String getHeatIndexF() {
        return HeatIndexF;
    }

    /**
     * 
     * @param HeatIndexF
     *     The HeatIndexF
     */
    public void setHeatIndexF(String HeatIndexF) {
        this.HeatIndexF = HeatIndexF;
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
     *     The tempC
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
     *     The tempF
     */
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
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
    public List<WeatherDesc_> getWeatherDesc() {
        return weatherDesc;
    }

    /**
     * 
     * @param weatherDesc
     *     The weatherDesc
     */
    public void setWeatherDesc(List<WeatherDesc_> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    /**
     * 
     * @return
     *     The weatherIconUrl
     */
    public List<WeatherIconUrl_> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     * 
     * @param weatherIconUrl
     *     The weatherIconUrl
     */
    public void setWeatherIconUrl(List<WeatherIconUrl_> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    /**
     * 
     * @return
     *     The WindChillC
     */
    public String getWindChillC() {
        return WindChillC;
    }

    /**
     * 
     * @param WindChillC
     *     The WindChillC
     */
    public void setWindChillC(String WindChillC) {
        this.WindChillC = WindChillC;
    }

    /**
     * 
     * @return
     *     The WindChillF
     */
    public String getWindChillF() {
        return WindChillF;
    }

    /**
     * 
     * @param WindChillF
     *     The WindChillF
     */
    public void setWindChillF(String WindChillF) {
        this.WindChillF = WindChillF;
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
     *     The WindGustKmph
     */
    public String getWindGustKmph() {
        return WindGustKmph;
    }

    /**
     * 
     * @param WindGustKmph
     *     The WindGustKmph
     */
    public void setWindGustKmph(String WindGustKmph) {
        this.WindGustKmph = WindGustKmph;
    }

    /**
     * 
     * @return
     *     The WindGustMiles
     */
    public String getWindGustMiles() {
        return WindGustMiles;
    }

    /**
     * 
     * @param WindGustMiles
     *     The WindGustMiles
     */
    public void setWindGustMiles(String WindGustMiles) {
        this.WindGustMiles = WindGustMiles;
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
