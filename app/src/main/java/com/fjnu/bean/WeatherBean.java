package com.fjnu.bean;

/**
 * Created by xujiaqi
 * 天气bean
 */

public class WeatherBean {
	private String date;
	private String weather;
	private String tempRange;
	private String wind;
	private String city;


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTempRange() {
		return tempRange;
	}

	public void setTempRange(String tempRange) {
		this.tempRange = tempRange;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "WeatherBean{" +
				"date='" + date + '\'' +
				", weather='" + weather + '\'' +
				", tempRange='" + tempRange + '\'' +
				", wind='" + wind + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
