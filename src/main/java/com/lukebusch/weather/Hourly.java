package com.lukebusch.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Hourly.
 */
@Generated("com.robohorse.robopojogenerator")
public class Hourly{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("icon")
	private String icon;

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
     * Set data.
     *
     * @param data the data
     */
    public void setData(List<DataItem> data){
		this.data = data;
	}

    /**
     * Get data list.
     *
     * @return the list
     */
    public List<DataItem> getData(){
		return data;
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

	@Override
 	public String toString(){
		return 
			"Hourly{" + 
			"summary = '" + summary + '\'' + 
			",data = '" + data + '\'' + 
			",icon = '" + icon + '\'' + 
			"}";
		}
}