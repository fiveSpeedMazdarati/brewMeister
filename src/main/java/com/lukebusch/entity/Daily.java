package com.lukebusch.entity;

import java.util.List;

/**
 * The type Daily.
 */
public class Daily{
	private List<DataItem> data;

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

	@Override
 	public String toString(){
		return 
			"Daily{" + 
			"data = '" + data + '\'' + 
			"}";
		}
}