package com.lukebusch.zipcodes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Response.
 */
@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("lng")
	private double lng;

	@JsonProperty("city")
	private String city;

	@JsonProperty("timezone")
	private Timezone timezone;

	@JsonProperty("acceptable_city_names")
	private List<Object> acceptableCityNames;

	@JsonProperty("state")
	private String state;

	@JsonProperty("zip_code")
	private String zipCode;

	@JsonProperty("lat")
	private double lat;

    /**
     * Set lng.
     *
     * @param lng the lng
     */
    public void setLng(double lng){
		this.lng = lng;
	}

    /**
     * Get lng double.
     *
     * @return the double
     */
    public double getLng(){
		return lng;
	}

    /**
     * Set city.
     *
     * @param city the city
     */
    public void setCity(String city){
		this.city = city;
	}

    /**
     * Get city string.
     *
     * @return the string
     */
    public String getCity(){
		return city;
	}

    /**
     * Set timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(Timezone timezone){
		this.timezone = timezone;
	}

    /**
     * Get timezone timezone.
     *
     * @return the timezone
     */
    public Timezone getTimezone(){
		return timezone;
	}

    /**
     * Set acceptable city names.
     *
     * @param acceptableCityNames the acceptable city names
     */
    public void setAcceptableCityNames(List<Object> acceptableCityNames){
		this.acceptableCityNames = acceptableCityNames;
	}

    /**
     * Get acceptable city names list.
     *
     * @return the list
     */
    public List<Object> getAcceptableCityNames(){
		return acceptableCityNames;
	}

    /**
     * Set state.
     *
     * @param state the state
     */
    public void setState(String state){
		this.state = state;
	}

    /**
     * Get state string.
     *
     * @return the string
     */
    public String getState(){
		return state;
	}

    /**
     * Set zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

    /**
     * Get zip code string.
     *
     * @return the string
     */
    public String getZipCode(){
		return zipCode;
	}

    /**
     * Set lat.
     *
     * @param lat the lat
     */
    public void setLat(double lat){
		this.lat = lat;
	}

    /**
     * Get lat double.
     *
     * @return the double
     */
    public double getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"lng = '" + lng + '\'' + 
			",city = '" + city + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",acceptable_city_names = '" + acceptableCityNames + '\'' + 
			",state = '" + state + '\'' + 
			",zip_code = '" + zipCode + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}