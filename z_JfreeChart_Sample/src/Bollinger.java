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
import java.lang.Math.*;

public class Bollinger {

    public double upper[];
    public double lower[];
    public double middle[];
    private MovingAverage ma;
    private LinkedList stockList;

    public Bollinger(LinkedList aStockList, int ma_days, double nof_devs) {
	// ma_days = simple moving average days
	// nof_devs = Number of Standard deviation to upper and lower band (usually 2)
	stockList = aStockList;
	ma = new MovingAverage();
	ma.calculate(stockList, ma_days, 0);
	int size = (int)stockList.size();
	upper = new double[size];
	lower = new double[size];
	middle = new double[size];
	double sum = 0.000;
	double dev = 0.000;
	for(int a = 0; a < ma_days; a++) {
	    Stock stock = (Stock)stockList.get(a);
	    dev = stock.getClose() - ma.ma[a];
	    dev *= dev; 
	    sum += dev;
	    lower[a] = ma.ma[a] - (Math.sqrt(sum / a) * nof_devs);
	    upper[a] = ma.ma[a] + (Math.sqrt(sum / a) * nof_devs);
	    middle[a] = ma.ma[a];
	}
	sum = 0.000;
	for(int a = ma_days; a < size; a++) {
	    for(int b = a - ma_days ; b < a ; b++) {
		Stock stock = (Stock)stockList.get(b);
		dev = stock.getClose() - ma.ma[a];
		dev *= dev; 
		sum += dev;
	    }
	    lower[a] = ma.ma[a] - (Math.sqrt(sum / ma_days) * nof_devs);
	    upper[a] = ma.ma[a] + (Math.sqrt(sum / ma_days) * nof_devs);
	    sum = 0.000;
	    middle[a] = ma.ma[a];
	}
       
    }

}
