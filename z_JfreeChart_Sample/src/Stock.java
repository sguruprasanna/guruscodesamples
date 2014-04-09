/*
    Lidgren Technical Stock Analyzer
    Copyright (C) 2002 Lars Lidgren

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
*/

import java.util.*;

public class Stock
{
    private String ticker;
    private Calendar date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    public Stock() { date = new GregorianCalendar(); }
    public void setTicker(String aTicker) { ticker = aTicker; }
    public String getTicker() { return ticker; }
    public void setDate(int year, int month, int day)
	{
	    date.clear();
	    date.set(year, month, day); 
	}
    public void setDate(Date d)
	{
	    date.clear();
	    date.setTime(d);
	}
    
    public Calendar getDate() { return date; }
    public void setOpen(double aOpen) { open = aOpen; }
    public double getOpen() { return open; }
    public void setHigh(double aHigh) { high = aHigh; }
    public double getHigh() { return high; }
    public void setLow(double aLow) { low = aLow; }
    public double getLow() { return low; }
    public void setClose(double aClose) { close = aClose; }
    public double getClose() { return close; }
    public void setVolume(double aVolume) { volume = aVolume; }
    public double getVolume() { return volume; }



/*
    public static void main(String[] args)
	{
	    Stock aStock = new Stock();
	    aStock.addDate("020608");
	}
*/
}


















