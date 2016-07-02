package com.csc.service;

import java.util.List;

import com.csc.model.TBL_Order;

public interface OrderService {
	public void CreateOrder(TBL_Order order);
	public void UpdateOrder(TBL_Order order);
	public void DeleteOrder(long order_id);
	public List<TBL_Order> getOrder();
	public TBL_Order selectOrder(long order_id);
}
