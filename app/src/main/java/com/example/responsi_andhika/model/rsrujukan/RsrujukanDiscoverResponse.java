package com.example.responsi_andhika.model.rsrujukan;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RsrujukanDiscoverResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<DataItem> data){
		this.data = data;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"RsrujukanDiscoverResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}