package org.example;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Geo{

	@SerializedName("lng")
	private String lng;

	@SerializedName("lat")
	private String lat;

}