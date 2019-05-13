package com.lukebusch.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Flags.
 */
@Generated("com.robohorse.robopojogenerator")
public class Flags{

	@JsonProperty("nearest-station")
	private double nearestStation;

	@JsonProperty("sources")
	private List<String> sources;

	@JsonProperty("units")
	private String units;

    /**
     * Set nearest station.
     *
     * @param nearestStation the nearest station
     */
    public void setNearestStation(double nearestStation){
		this.nearestStation = nearestStation;
	}

    /**
     * Get nearest station double.
     *
     * @return the double
     */
    public double getNearestStation(){
		return nearestStation;
	}

    /**
     * Set sources.
     *
     * @param sources the sources
     */
    public void setSources(List<String> sources){
		this.sources = sources;
	}

    /**
     * Get sources list.
     *
     * @return the list
     */
    public List<String> getSources(){
		return sources;
	}

    /**
     * Set units.
     *
     * @param units the units
     */
    public void setUnits(String units){
		this.units = units;
	}

    /**
     * Get units string.
     *
     * @return the string
     */
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