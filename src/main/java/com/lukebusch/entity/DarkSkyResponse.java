package com.lukebusch.entity;

public class DarkSkyResponse {
	private int offset;
	private String timezone;
	private double latitude;
	private Daily daily;
	private double longitude;

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	public String getTimezone(){
		return timezone;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setDaily(Daily daily){
		this.daily = daily;
	}

	public Daily getDaily(){
		return daily;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"DarkSky{" + 
			"offset = '" + offset + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",daily = '" + daily + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}
