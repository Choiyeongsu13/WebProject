package com.mnu.exshop.model;

public class CityDTO {
	private String city;
	private String cityname;

	public CityDTO() {}
	
	public CityDTO(String city, String cityname) {
		this.city=city;
		this.cityname=cityname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

}
