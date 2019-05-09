package com.lukebusch.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataItem{
	@JsonProperty
	private int apparentTemperatureMinTime;
	@JsonProperty
	private double temperatureMax;
	@JsonProperty
	private String icon;
	@JsonProperty
	private int precipIntensityMax;
	@JsonProperty
	private int windBearing;
	@JsonProperty
	private int temperatureMaxTime;
	@JsonProperty
	private double apparentTemperatureMin;
	@JsonProperty
	private int sunsetTime;
	@JsonProperty
	private double temperatureLow;
	@JsonProperty
	private double humidity;
	@JsonProperty
	private double moonPhase;
	@JsonProperty
	private double windSpeed;
	@JsonProperty
	private int apparentTemperatureLowTime;
	@JsonProperty
	private int sunriseTime;
	@JsonProperty
	private double apparentTemperatureLow;
	@JsonProperty
	private String summary;
	@JsonProperty
	private int precipProbability;
	@JsonProperty
	private int temperatureHighTime;
	@JsonProperty
	private int visibility;
	@JsonProperty
	private int precipIntensity;
	@JsonProperty
	private double cloudCover;
	@JsonProperty
	private double temperatureMin;
	@JsonProperty
	private int apparentTemperatureHighTime;
	@JsonProperty
	private double pressure;
	@JsonProperty
	private double dewPoint;
	@JsonProperty
	private int temperatureMinTime;
	@JsonProperty
	private int uvIndexTime;
	@JsonProperty
	private double apparentTemperatureMax;
	@JsonProperty
	private double temperatureHigh;
	@JsonProperty
	private int temperatureLowTime;
	@JsonProperty
	private double apparentTemperatureHigh;
	@JsonProperty
	private int time;
	@JsonProperty
	private int uvIndex;
	@JsonProperty
	private int apparentTemperatureMaxTime;

	public void setApparentTemperatureMinTime(int apparentTemperatureMinTime){
		this.apparentTemperatureMinTime = apparentTemperatureMinTime;
	}

	public int getApparentTemperatureMinTime(){
		return apparentTemperatureMinTime;
	}

	public void setTemperatureMax(double temperatureMax){
		this.temperatureMax = temperatureMax;
	}

	public double getTemperatureMax(){
		return temperatureMax;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	public void setPrecipIntensityMax(int precipIntensityMax){
		this.precipIntensityMax = precipIntensityMax;
	}

	public int getPrecipIntensityMax(){
		return precipIntensityMax;
	}

	public void setWindBearing(int windBearing){
		this.windBearing = windBearing;
	}

	public int getWindBearing(){
		return windBearing;
	}

	public void setTemperatureMaxTime(int temperatureMaxTime){
		this.temperatureMaxTime = temperatureMaxTime;
	}

	public int getTemperatureMaxTime(){
		return temperatureMaxTime;
	}

	public void setApparentTemperatureMin(double apparentTemperatureMin){
		this.apparentTemperatureMin = apparentTemperatureMin;
	}

	public double getApparentTemperatureMin(){
		return apparentTemperatureMin;
	}

	public void setSunsetTime(int sunsetTime){
		this.sunsetTime = sunsetTime;
	}

	public int getSunsetTime(){
		return sunsetTime;
	}

	public void setTemperatureLow(double temperatureLow){
		this.temperatureLow = temperatureLow;
	}

	public double getTemperatureLow(){
		return temperatureLow;
	}

	public void setHumidity(double humidity){
		this.humidity = humidity;
	}

	public double getHumidity(){
		return humidity;
	}

	public void setMoonPhase(double moonPhase){
		this.moonPhase = moonPhase;
	}

	public double getMoonPhase(){
		return moonPhase;
	}

	public void setWindSpeed(double windSpeed){
		this.windSpeed = windSpeed;
	}

	public double getWindSpeed(){
		return windSpeed;
	}

	public void setApparentTemperatureLowTime(int apparentTemperatureLowTime){
		this.apparentTemperatureLowTime = apparentTemperatureLowTime;
	}

	public int getApparentTemperatureLowTime(){
		return apparentTemperatureLowTime;
	}

	public void setSunriseTime(int sunriseTime){
		this.sunriseTime = sunriseTime;
	}

	public int getSunriseTime(){
		return sunriseTime;
	}

	public void setApparentTemperatureLow(double apparentTemperatureLow){
		this.apparentTemperatureLow = apparentTemperatureLow;
	}

	public double getApparentTemperatureLow(){
		return apparentTemperatureLow;
	}

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setPrecipProbability(int precipProbability){
		this.precipProbability = precipProbability;
	}

	public int getPrecipProbability(){
		return precipProbability;
	}

	public void setTemperatureHighTime(int temperatureHighTime){
		this.temperatureHighTime = temperatureHighTime;
	}

	public int getTemperatureHighTime(){
		return temperatureHighTime;
	}

	public void setVisibility(int visibility){
		this.visibility = visibility;
	}

	public int getVisibility(){
		return visibility;
	}

	public void setPrecipIntensity(int precipIntensity){
		this.precipIntensity = precipIntensity;
	}

	public int getPrecipIntensity(){
		return precipIntensity;
	}

	public void setCloudCover(double cloudCover){
		this.cloudCover = cloudCover;
	}

	public double getCloudCover(){
		return cloudCover;
	}

	public void setTemperatureMin(double temperatureMin){
		this.temperatureMin = temperatureMin;
	}

	public double getTemperatureMin(){
		return temperatureMin;
	}

	public void setApparentTemperatureHighTime(int apparentTemperatureHighTime){
		this.apparentTemperatureHighTime = apparentTemperatureHighTime;
	}

	public int getApparentTemperatureHighTime(){
		return apparentTemperatureHighTime;
	}

	public void setPressure(double pressure){
		this.pressure = pressure;
	}

	public double getPressure(){
		return pressure;
	}

	public void setDewPoint(double dewPoint){
		this.dewPoint = dewPoint;
	}

	public double getDewPoint(){
		return dewPoint;
	}

	public void setTemperatureMinTime(int temperatureMinTime){
		this.temperatureMinTime = temperatureMinTime;
	}

	public int getTemperatureMinTime(){
		return temperatureMinTime;
	}

	public void setUvIndexTime(int uvIndexTime){
		this.uvIndexTime = uvIndexTime;
	}

	public int getUvIndexTime(){
		return uvIndexTime;
	}

	public void setApparentTemperatureMax(double apparentTemperatureMax){
		this.apparentTemperatureMax = apparentTemperatureMax;
	}

	public double getApparentTemperatureMax(){
		return apparentTemperatureMax;
	}

	public void setTemperatureHigh(double temperatureHigh){
		this.temperatureHigh = temperatureHigh;
	}

	public double getTemperatureHigh(){
		return temperatureHigh;
	}

	public void setTemperatureLowTime(int temperatureLowTime){
		this.temperatureLowTime = temperatureLowTime;
	}

	public int getTemperatureLowTime(){
		return temperatureLowTime;
	}

	public void setApparentTemperatureHigh(double apparentTemperatureHigh){
		this.apparentTemperatureHigh = apparentTemperatureHigh;
	}

	public double getApparentTemperatureHigh(){
		return apparentTemperatureHigh;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}

	public void setUvIndex(int uvIndex){
		this.uvIndex = uvIndex;
	}

	public int getUvIndex(){
		return uvIndex;
	}

	public void setApparentTemperatureMaxTime(int apparentTemperatureMaxTime){
		this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
	}

	public int getApparentTemperatureMaxTime(){
		return apparentTemperatureMaxTime;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"apparentTemperatureMinTime = '" + apparentTemperatureMinTime + '\'' + 
			",temperatureMax = '" + temperatureMax + '\'' + 
			",icon = '" + icon + '\'' + 
			",precipIntensityMax = '" + precipIntensityMax + '\'' + 
			",windBearing = '" + windBearing + '\'' + 
			",temperatureMaxTime = '" + temperatureMaxTime + '\'' + 
			",apparentTemperatureMin = '" + apparentTemperatureMin + '\'' + 
			",sunsetTime = '" + sunsetTime + '\'' + 
			",temperatureLow = '" + temperatureLow + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",moonPhase = '" + moonPhase + '\'' + 
			",windSpeed = '" + windSpeed + '\'' + 
			",apparentTemperatureLowTime = '" + apparentTemperatureLowTime + '\'' + 
			",sunriseTime = '" + sunriseTime + '\'' + 
			",apparentTemperatureLow = '" + apparentTemperatureLow + '\'' + 
			",summary = '" + summary + '\'' + 
			",precipProbability = '" + precipProbability + '\'' + 
			",temperatureHighTime = '" + temperatureHighTime + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",precipIntensity = '" + precipIntensity + '\'' + 
			",cloudCover = '" + cloudCover + '\'' + 
			",temperatureMin = '" + temperatureMin + '\'' + 
			",apparentTemperatureHighTime = '" + apparentTemperatureHighTime + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",dewPoint = '" + dewPoint + '\'' + 
			",temperatureMinTime = '" + temperatureMinTime + '\'' + 
			",uvIndexTime = '" + uvIndexTime + '\'' + 
			",apparentTemperatureMax = '" + apparentTemperatureMax + '\'' + 
			",temperatureHigh = '" + temperatureHigh + '\'' + 
			",temperatureLowTime = '" + temperatureLowTime + '\'' + 
			",apparentTemperatureHigh = '" + apparentTemperatureHigh + '\'' + 
			",time = '" + time + '\'' + 
			",uvIndex = '" + uvIndex + '\'' + 
			",apparentTemperatureMaxTime = '" + apparentTemperatureMaxTime + '\'' + 
			"}";
		}
}
