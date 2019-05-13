package com.lukebusch.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Currently.
 */
@Generated("com.robohorse.robopojogenerator")
public class Currently{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("precipProbability")
	private int precipProbability;

	@JsonProperty("visibility")
	private int visibility;

	@JsonProperty("windGust")
	private double windGust;

	@JsonProperty("precipIntensity")
	private int precipIntensity;

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("cloudCover")
	private double cloudCover;

	@JsonProperty("windBearing")
	private int windBearing;

	@JsonProperty("apparentTemperature")
	private double apparentTemperature;

	@JsonProperty("pressure")
	private double pressure;

	@JsonProperty("dewPoint")
	private double dewPoint;

	@JsonProperty("ozone")
	private double ozone;

	@JsonProperty("nearestStormBearing")
	private int nearestStormBearing;

	@JsonProperty("nearestStormDistance")
	private int nearestStormDistance;

	@JsonProperty("temperature")
	private double temperature;

	@JsonProperty("humidity")
	private double humidity;

	@JsonProperty("time")
	private int time;

	@JsonProperty("windSpeed")
	private double windSpeed;

	@JsonProperty("uvIndex")
	private int uvIndex;

    /**
     * Set summary.
     *
     * @param summary the summary
     */
    public void setSummary(String summary){
		this.summary = summary;
	}

    /**
     * Get summary string.
     *
     * @return the string
     */
    public String getSummary(){
		return summary;
	}

    /**
     * Set precip probability.
     *
     * @param precipProbability the precip probability
     */
    public void setPrecipProbability(int precipProbability){
		this.precipProbability = precipProbability;
	}

    /**
     * Get precip probability int.
     *
     * @return the int
     */
    public int getPrecipProbability(){
		return precipProbability;
	}

    /**
     * Set visibility.
     *
     * @param visibility the visibility
     */
    public void setVisibility(int visibility){
		this.visibility = visibility;
	}

    /**
     * Get visibility int.
     *
     * @return the int
     */
    public int getVisibility(){
		return visibility;
	}

    /**
     * Set wind gust.
     *
     * @param windGust the wind gust
     */
    public void setWindGust(double windGust){
		this.windGust = windGust;
	}

    /**
     * Get wind gust double.
     *
     * @return the double
     */
    public double getWindGust(){
		return windGust;
	}

    /**
     * Set precip intensity.
     *
     * @param precipIntensity the precip intensity
     */
    public void setPrecipIntensity(int precipIntensity){
		this.precipIntensity = precipIntensity;
	}

    /**
     * Get precip intensity int.
     *
     * @return the int
     */
    public int getPrecipIntensity(){
		return precipIntensity;
	}

    /**
     * Set icon.
     *
     * @param icon the icon
     */
    public void setIcon(String icon){
		this.icon = icon;
	}

    /**
     * Get icon string.
     *
     * @return the string
     */
    public String getIcon(){
		return icon;
	}

    /**
     * Set cloud cover.
     *
     * @param cloudCover the cloud cover
     */
    public void setCloudCover(double cloudCover){
		this.cloudCover = cloudCover;
	}

    /**
     * Get cloud cover double.
     *
     * @return the double
     */
    public double getCloudCover(){
		return cloudCover;
	}

    /**
     * Set wind bearing.
     *
     * @param windBearing the wind bearing
     */
    public void setWindBearing(int windBearing){
		this.windBearing = windBearing;
	}

    /**
     * Get wind bearing int.
     *
     * @return the int
     */
    public int getWindBearing(){
		return windBearing;
	}

    /**
     * Set apparent temperature.
     *
     * @param apparentTemperature the apparent temperature
     */
    public void setApparentTemperature(double apparentTemperature){
		this.apparentTemperature = apparentTemperature;
	}

    /**
     * Get apparent temperature double.
     *
     * @return the double
     */
    public double getApparentTemperature(){
		return apparentTemperature;
	}

    /**
     * Set pressure.
     *
     * @param pressure the pressure
     */
    public void setPressure(double pressure){
		this.pressure = pressure;
	}

    /**
     * Get pressure double.
     *
     * @return the double
     */
    public double getPressure(){
		return pressure;
	}

    /**
     * Set dew point.
     *
     * @param dewPoint the dew point
     */
    public void setDewPoint(double dewPoint){
		this.dewPoint = dewPoint;
	}

    /**
     * Get dew point double.
     *
     * @return the double
     */
    public double getDewPoint(){
		return dewPoint;
	}

    /**
     * Set ozone.
     *
     * @param ozone the ozone
     */
    public void setOzone(double ozone){
		this.ozone = ozone;
	}

    /**
     * Get ozone double.
     *
     * @return the double
     */
    public double getOzone(){
		return ozone;
	}

    /**
     * Set nearest storm bearing.
     *
     * @param nearestStormBearing the nearest storm bearing
     */
    public void setNearestStormBearing(int nearestStormBearing){
		this.nearestStormBearing = nearestStormBearing;
	}

    /**
     * Get nearest storm bearing int.
     *
     * @return the int
     */
    public int getNearestStormBearing(){
		return nearestStormBearing;
	}

    /**
     * Set nearest storm distance.
     *
     * @param nearestStormDistance the nearest storm distance
     */
    public void setNearestStormDistance(int nearestStormDistance){
		this.nearestStormDistance = nearestStormDistance;
	}

    /**
     * Get nearest storm distance int.
     *
     * @return the int
     */
    public int getNearestStormDistance(){
		return nearestStormDistance;
	}

    /**
     * Set temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(double temperature){
		this.temperature = temperature;
	}

    /**
     * Get temperature double.
     *
     * @return the double
     */
    public double getTemperature(){
		return temperature;
	}

    /**
     * Set humidity.
     *
     * @param humidity the humidity
     */
    public void setHumidity(double humidity){
		this.humidity = humidity;
	}

    /**
     * Get humidity double.
     *
     * @return the double
     */
    public double getHumidity(){
		return humidity;
	}

    /**
     * Set time.
     *
     * @param time the time
     */
    public void setTime(int time){
		this.time = time;
	}

    /**
     * Get time int.
     *
     * @return the int
     */
    public int getTime(){
		return time;
	}

    /**
     * Set wind speed.
     *
     * @param windSpeed the wind speed
     */
    public void setWindSpeed(double windSpeed){
		this.windSpeed = windSpeed;
	}

    /**
     * Get wind speed double.
     *
     * @return the double
     */
    public double getWindSpeed(){
		return windSpeed;
	}

    /**
     * Set uv index.
     *
     * @param uvIndex the uv index
     */
    public void setUvIndex(int uvIndex){
		this.uvIndex = uvIndex;
	}

    /**
     * Get uv index int.
     *
     * @return the int
     */
    public int getUvIndex(){
		return uvIndex;
	}

	@Override
 	public String toString(){
		return 
			"Currently{" + 
			"summary = '" + summary + '\'' + 
			",precipProbability = '" + precipProbability + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",windGust = '" + windGust + '\'' + 
			",precipIntensity = '" + precipIntensity + '\'' + 
			",icon = '" + icon + '\'' + 
			",cloudCover = '" + cloudCover + '\'' + 
			",windBearing = '" + windBearing + '\'' + 
			",apparentTemperature = '" + apparentTemperature + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",ozone = '" + ozone + '\'' + 
			",nearestStormBearing = '" + nearestStormBearing + '\'' + 
			",nearestStormDistance = '" + nearestStormDistance + '\'' + 
			",temperature = '" + temperature + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",time = '" + time + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",uvIndex = '" + uvIndex + '\'' + 
			"}";
		}
}