package com.zoho.FoodDelivery;
class AddressModel
{
	private int stateid;
	private String state;
	private int districtid;
	private String district;
	private int cityid;
	private String city;
	private String street;
	private int pincode;
	AddressModel(int stateid,int districtid,int cityid,String street,int pincode)
	{
		this.stateid=stateid;
		this.districtid=districtid;
		this.cityid=cityid;
		this.street=street;
		this.pincode=pincode;
	}
	AddressModel(String street,int stateid,int districtid,int cityid,String state,String district,String city)
	{
		this.stateid=stateid;
		this.districtid=districtid;
		this.cityid=cityid;
		this.street=street;
		this.state=state;
		this.district=district;
		this.city=city;
	}
	public int getStateID()
	{
		return stateid;
	}
	public void setStateId(int stateid)
	{
		this.stateid=stateid;
	}
	public int getDistrictID()
	{
		return districtid;
	}
	public void setDistrictID(int districtid)
	{
		this.districtid=districtid;
	}
	public int getCityID()
	{
		return cityid;
	}
	public void setCityID(int cityid)
	{
		this.cityid=cityid;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street=street;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public String getDistrict()
	{
		return district;
	}
	public void setDistrict(String district)
	{
		this.district=district;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city=city;
	}
	public int getPincode()
	{
		return pincode;
	}
	public void setPincode(int pincode)
	{
		this.pincode=pincode;
	}
}
