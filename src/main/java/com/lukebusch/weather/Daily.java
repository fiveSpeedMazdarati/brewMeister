package com.lukebusch.weather;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Daily.
 */
@Generated("com.robohorse.robopojogenerator")
public class Daily{

	@JsonProperty("data")
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