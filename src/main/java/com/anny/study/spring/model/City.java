package com.anny.study.spring.model;

public class City {
	String cityName;
	String provinceName;

	public City(String cityName, String provinceName) {
		this.cityName = cityName;
		this.provinceName = provinceName;
	}
	
	public City() {
		
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

}