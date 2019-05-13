package com.lukebusch.zipcodes;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

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

	public void setLng(double lng){
		this.lng = lng;
	}

	public double getLng(){
		return lng;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setTimezone(Timezone timezone){
		this.timezone = timezone;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public void setAcceptableCityNames(List<Object> acceptableCityNames){
		this.acceptableCityNames = acceptableCityNames;
	}

	public List<Object> getAcceptableCityNames(){
		return acceptableCityNames;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setZipCode(String zipCode){
		this.zipCode = zipCode;
	}

	public String getZipCode(){
		return zipCode;
	}

	public void setLat(double lat){
		this.lat = lat;
	}

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