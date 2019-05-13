package com.lukebusch.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Response.
 */
@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("timezone")
	private String timezone;

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("daily")
	private Daily daily;

	@JsonProperty("longitude")
	private double longitude;

    /**
     * Set offset.
     *
     * @param offset the offset
     */
    public void setOffset(int offset){
		this.offset = offset;
	}

    /**
     * Get offset int.
     *
     * @return the int
     */
    public int getOffset(){
		return offset;
	}

    /**
     * Set timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(String timezone){
		this.timezone = timezone;
	}

    /**
     * Get timezone string.
     *
     * @return the string
     */
    public String getTimezone(){
		return timezone;
	}

    /**
     * Set latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude){
		this.latitude = latitude;
	}

    /**
     * Get latitude double.
     *
     * @return the double
     */
    public double getLatitude(){
		return latitude;
	}

    /**
     * Set daily.
     *
     * @param daily the daily
     */
    public void setDaily(Daily daily){
		this.daily = daily;
	}

    /**
     * Get daily daily.
     *
     * @return the daily
     */
    public Daily getDaily(){
		return daily;
	}

    /**
     * Set longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude){
		this.longitude = longitude;
	}

    /**
     * Get longitude double.
     *
     * @return the double
     */
    public double getLongitude(){
		return longitude;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"offset = '" + offset + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",daily = '" + daily + '\'' + 
			",longitude = '" + longitude + '\'' + 
			"}";
		}
}