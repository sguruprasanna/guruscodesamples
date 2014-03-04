package com.guru.test.rest.dao;

import com.guru.test.rest.model.Stock;

public interface StockDao {
	public Stock get(String symbol);
	public Stock get(int stockId);
	public void add(Stock stock);
	public void update(Stock stock);
	public void delete(Stock stock);
}
