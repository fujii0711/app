package com.prj.api.sample.vo;

public class SampleVO {

	private String country_id;
	private String country_name;
	private String region_id;
	
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_id() {
		return region_id;
	}
	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}
	
	@Override
	public String toString() {
		return "TestVO [country_id=" + country_id + ", country_name=" + country_name + ", region_id=" + region_id + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country_id == null) ? 0 : country_id.hashCode());
		result = prime * result + ((country_name == null) ? 0 : country_name.hashCode());
		result = prime * result + ((region_id == null) ? 0 : region_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SampleVO other = (SampleVO) obj;
		if (country_id == null) {
			if (other.country_id != null)
				return false;
		} else if (!country_id.equals(other.country_id))
			return false;
		if (country_name == null) {
			if (other.country_name != null)
				return false;
		} else if (!country_name.equals(other.country_name))
			return false;
		if (region_id == null) {
			if (other.region_id != null)
				return false;
		} else if (!region_id.equals(other.region_id))
			return false;
		return true;
	}
}
