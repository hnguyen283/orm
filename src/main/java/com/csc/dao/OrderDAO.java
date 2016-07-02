package com.csc.dao;

import java.util.List;

import com.csc.model.TBL_Order;

public interface OrderDAO {
	public void create(TBL_Order order);
	public void update(TBL_Order order);
	public void delete(long order_id);
	public List<TBL_Order> get();
	public TBL_Order select(long order_id);
}
