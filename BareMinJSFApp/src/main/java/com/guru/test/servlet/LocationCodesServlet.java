package com.guru.test.servlet; 

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

public class LocationCodesServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7092118659378319792L;
	
	
	public LocationCodesServlet(){
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter out;
		try {
			
			String filter = request.getParameter("term");
			out = response.getWriter();
			String[] locationCodes = {"Granada, NI", "Appleton, WI", "Deerfield Beach, FL", "Cleveland, MS", "Copiague, NY", "New York, NY", "Caldera, CR", "Turrialba, CR", "La Romana, DO", "San Jose Pinula, GT", "Villanueva, GT", "Perth, Ontario", "Anniston, AL", "Ashdown, AR", "Bradley, IL", "Des Plaines, IL", "Long Beach, CA", "Oakland, CA", "Summit, IL", "St Louis, MO", "Bufalo, HN", "La Paz, SV", "San Pedro de Macoris, DO", "Gulfport, MS, US (Port)", "Bridgetown, Barbados (Port)", "Port Au Prince, Haiti (Port)", "Bridgeview, IL", "Hamilton, OH", "Niles, IL", "Belmont, NC", "Buffalo, NY", "Salisbury, NC", "Chicago, IL (Rail)", "Atlanta, GA (Rail Ramp - NS)", "Perrysburg, OH", "Gulfport, MS", "Tupelo, MS", "Ft Worth, TX", "Chalchuapa, SV", "Newburyport, MA", "Cherry Hill, NJ", "Jackson, TN", "Port Everglades, FL", "Alajuela, CR", "El Paraiso, HN", "Fort Payne, AL", "Hillsville, VA", "Sparta, NC", "Quimistan, HN", "Callahan, FL", "Lakeland, FL", "Sanford, FL", "Adel, GA", "Wrightsville, GA", "Elgin, IL", "Washington, MO", "Greer, SC", "Saddle Brook, NJ", "Toms RIver, NJ", "Trenton, NJ", "Wood RIdge, NJ", "Batavia, NY", "Cornwall, NY", "Fredonia, NY", "Holland, NY", "Johnstown, NY", "Coral Gables, FL", "Mahopac, NY", "Milton, NY", "Little Falls, NY", "WIlliamsville, NY", "Ashland, OH", "Cadiz, OH", "Delaware, OH", "Fremont, OH", "Graniteville, SC", "Green Bay, WI", "Logan Township, NJ", "Slidell, LA", "Adams, MA", "Auburn, MA", "Burlington, MA", "Everett, MA", "Lawrence, MA", "Natick, MA", "North Brookfield, MA", "North Billerica, MA", "Northhampton, MA", "Reading, MA", "Raynham, MA", "Springfield, MA", "Webster, MA", "Curtis Bay, MD", "Dundalk, MD", "Glen Burnie, MD", "Hampstead, MD", "Hunt Valley, MD", "Middle River, MD", "Owings Mills, MD", "Rockville, MD"};

			JSONArray jsonArray = new JSONArray();
			
			for(String locationCode : locationCodes) {
				if(locationCode.startsWith(filter))
					jsonArray.add(locationCode);
			}		
			out.write(jsonArray.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
