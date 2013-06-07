package com.guru.test.jsf.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationCodeBean {

	private int id;
	String code;
	String description;
	List<String> locationCodeList;
	int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LocationCodeBean(){
		
		loadLocationList();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<String> getLocationCodeList() {
		return locationCodeList;
	}

	public void setLocationCodeList(List<String> locationCodeList) {
		this.locationCodeList = locationCodeList;
	}

	public void loadLocationList(){
		
		locationCodeList = new ArrayList<String>();
		String[] codes = {"Granada, NI", "Appleton, WI", "Deerfield Beach, FL", "Cleveland, MS", "Copiague, NY", "New York, NY", "Caldera, CR", "Turrialba, CR", "La Romana, DO", "San Jose Pinula, GT", "Villanueva, GT", "Perth, Ontario", "Anniston, AL", "Ashdown, AR", "Bradley, IL", "Des Plaines, IL", "Long Beach, CA", "Oakland, CA", "Summit, IL", "St Louis, MO", "Bufalo, HN", "La Paz, SV", "San Pedro de Macoris, DO", "Gulfport, MS, US (Port)", "Bridgetown, Barbados (Port)", "Port Au Prince, Haiti (Port)", "Bridgeview, IL", "Hamilton, OH", "Niles, IL", "Belmont, NC", "Buffalo, NY", "Salisbury, NC", "Chicago, IL (Rail)", "Atlanta, GA (Rail Ramp - NS)", "Perrysburg, OH", "Gulfport, MS", "Tupelo, MS", "Ft Worth, TX", "Chalchuapa, SV", "Newburyport, MA", "Cherry Hill, NJ", "Jackson, TN", "Port Everglades, FL", "Alajuela, CR", "El Paraiso, HN", "Fort Payne, AL", "Hillsville, VA", "Sparta, NC", "Quimistan, HN", "Callahan, FL", "Lakeland, FL", "Sanford, FL", "Adel, GA", "Wrightsville, GA", "Elgin, IL", "Washington, MO", "Greer, SC", "Saddle Brook, NJ", "Toms RIver, NJ", "Trenton, NJ", "Wood RIdge, NJ", "Batavia, NY", "Cornwall, NY", "Fredonia, NY", "Holland, NY", "Johnstown, NY", "Coral Gables, FL", "Mahopac, NY", "Milton, NY", "Little Falls, NY", "WIlliamsville, NY", "Ashland, OH", "Cadiz, OH", "Delaware, OH", "Fremont, OH", "Graniteville, SC", "Green Bay, WI", "Logan Township, NJ", "Slidell, LA", "Adams, MA", "Auburn, MA", "Burlington, MA", "Everett, MA", "Lawrence, MA", "Natick, MA", "North Brookfield, MA", "North Billerica, MA", "Northhampton, MA", "Reading, MA", "Raynham, MA", "Springfield, MA", "Webster, MA", "Curtis Bay, MD", "Dundalk, MD", "Glen Burnie, MD", "Hampstead, MD", "Hunt Valley, MD", "Middle River, MD", "Owings Mills, MD", "Rockville, MD"};
		locationCodeList.addAll(Arrays.asList(codes));
		size = locationCodeList.size();
	}
	
}
