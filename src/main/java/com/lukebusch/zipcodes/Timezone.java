package com.lukebusch.zipcodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Timezone.
 */
@Generated("com.robohorse.robopojogenerator")
public class Timezone{

	@JsonProperty("timezone_identifier")
	private String timezoneIdentifier;

	@JsonProperty("timezone_abbr")
	private String timezoneAbbr;

	@JsonProperty("utc_offset_sec")
	private int utcOffsetSec;

	@JsonProperty("is_dst")
	private String isDst;

    /**
     * Set timezone identifier.
     *
     * @param timezoneIdentifier the timezone identifier
     */
    public void setTimezoneIdentifier(String timezoneIdentifier){
		this.timezoneIdentifier = timezoneIdentifier;
	}

    /**
     * Get timezone identifier string.
     *
     * @return the string
     */
    public String getTimezoneIdentifier(){
		return timezoneIdentifier;
	}

    /**
     * Set timezone abbr.
     *
     * @param timezoneAbbr the timezone abbr
     */
    public void setTimezoneAbbr(String timezoneAbbr){
		this.timezoneAbbr = timezoneAbbr;
	}

    /**
     * Get timezone abbr string.
     *
     * @return the string
     */
    public String getTimezoneAbbr(){
		return timezoneAbbr;
	}

    /**
     * Set utc offset sec.
     *
     * @param utcOffsetSec the utc offset sec
     */
    public void setUtcOffsetSec(int utcOffsetSec){
		this.utcOffsetSec = utcOffsetSec;
	}

    /**
     * Get utc offset sec int.
     *
     * @return the int
     */
    public int getUtcOffsetSec(){
		return utcOffsetSec;
	}

    /**
     * Set is dst.
     *
     * @param isDst the is dst
     */
    public void setIsDst(String isDst){
		this.isDst = isDst;
	}

    /**
     * Get is dst string.
     *
     * @return the string
     */
    public String getIsDst(){
		return isDst;
	}

	@Override
 	public String toString(){
		return 
			"Timezone{" + 
			"timezone_identifier = '" + timezoneIdentifier + '\'' + 
			",timezone_abbr = '" + timezoneAbbr + '\'' + 
			",utc_offset_sec = '" + utcOffsetSec + '\'' + 
			",is_dst = '" + isDst + '\'' + 
			"}";
		}
}