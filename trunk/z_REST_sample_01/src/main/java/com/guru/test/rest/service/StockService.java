package com.guru.test.rest.service;

import com.guru.test.rest.model.Stock;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
public interface StockService {
	
	public Stock get(String symbol);
	public Stock get(int stockId);
	public void add(Stock stock);
	public void update(Stock stock);
	public void delete(Stock stock);
}
