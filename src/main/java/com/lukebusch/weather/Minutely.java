package com.lukebusch.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Minutely{

	@JsonProperty("summary")
	private String summary;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("icon")
	private String icon;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	@Override
 	public String toString(){
		return 
			"Minutely{" + 
			"summary = '" + summary + '\'' + 
			",data = '" + data + '\'' + 
			",icon = '" + icon + '\'' + 
			"}";
		}
}