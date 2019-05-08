package com.lukebusch.entity;

import java.util.List;

public class Daily{
	private List<DataItem> data;

	public void setData(List<DataItem> data){
		this.data = data;
	}

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