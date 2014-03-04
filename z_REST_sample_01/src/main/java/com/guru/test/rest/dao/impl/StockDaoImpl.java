package com.guru.test.rest.dao.impl;

import com.guru.test.rest.dao.StockDao;
import com.guru.test.rest.model.Stock;

public class StockDaoImpl implements StockDao{

	public Stock get(String symbol) {

		return getDefaultStock();
	}

	public Stock get(int stockId) {
		return getDefaultStock();
	}

	public void add(Stock stock) {
		System.out.println(" >>>>>>>>>>> Stock "+stock.getSymbol()+" added successfully.");
	}

	public void update(Stock stock) {
		System.out.println(" >>>>>>>>>>> Stock "+stock.getSymbol()+" updated successfully.");
	}

	public void delete(Stock stock) {
		System.out.println(" >>>>>>>>>>> Stock "+stock.getSymbol()+" deleted successfully.");	
	}

	public Stock getDefaultStock() {
		Stock stock = new Stock();
		stock.setId(0);
		stock.setIndex("NYSE");
		stock.setName("IBM");
		stock.setSymbol("IBM");
		return stock;
	}
}
