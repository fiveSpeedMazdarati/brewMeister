package com.lukebusch.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Daily{
	@JsonProperty
	private List<DataItem> data;
	@JsonProperty
	public void setData(List<DataItem> data){
		this.data = data;
	}
	@JsonProperty
	public List<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Daily{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}