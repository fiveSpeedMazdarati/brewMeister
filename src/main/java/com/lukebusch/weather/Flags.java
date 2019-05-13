package com.lukebusch.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Flags{

	@JsonProperty("nearest-station")
	private double nearestStation;

	@JsonProperty("sources")
	private List<String> sources;

	@JsonProperty("units")
	private String units;

	public void setNearestStation(double nearestStation){
		this.nearestStation = nearestStation;
	}

	public double getNearestStation(){
		return nearestStation;
	}

	public void setSources(List<String> sources){
		this.sources = sources;
	}

	public List<String> getSources(){
		return sources;
	}

	public void setUnits(String units){
		this.units = units;
	}

	public String getUnits(){
		return units;
	}

	@Override
 	public String toString(){
		return 
			"Flags{" + 
			"nearest-station = '" + nearestStation + '\'' + 
			",sources = '" + sources + '\'' + 
			",units = '" + units + '\'' + 
			"}";
		}
}