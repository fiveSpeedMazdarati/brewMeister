package com.lukebusch.zipcodes;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

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

	public void setTimezoneIdentifier(String timezoneIdentifier){
		this.timezoneIdentifier = timezoneIdentifier;
	}

	public String getTimezoneIdentifier(){
		return timezoneIdentifier;
	}

	public void setTimezoneAbbr(String timezoneAbbr){
		this.timezoneAbbr = timezoneAbbr;
	}

	public String getTimezoneAbbr(){
		return timezoneAbbr;
	}

	public void setUtcOffsetSec(int utcOffsetSec){
		this.utcOffsetSec = utcOffsetSec;
	}

	public int getUtcOffsetSec(){
		return utcOffsetSec;
	}

	public void setIsDst(String isDst){
		this.isDst = isDst;
	}

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