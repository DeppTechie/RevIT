package io.weatherbit.pojomodels.current;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    
    @SerializedName("state_code")
    @Expose
    private String stateCode;
    
    @SerializedName("weather")
    @Expose
    private Weather weather;
    
    @SerializedName("datetime")
    @Expose
    private String datetime;

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
    
    
}
