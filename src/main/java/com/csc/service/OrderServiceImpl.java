package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csc.dao.OrderDAO;
import com.csc.model.TBL_Order;

public class OrderServiceImpl implements OrderService {
	@Autowired
	@Qualifier("orderDAO")
	private OrderDAO service;

	@Override
	public void CreateOrder(TBL_Order order) {
		// TODO Auto-generated method stub
		service.create(order);
	}

	@Override
	public void UpdateOrder(TBL_Order order) {
		// TODO Auto-generated method stub
		service.update(order);
	}

	@Override
	public List<TBL_Order> getOrder() {
		// TODO Auto-generated method stub
		return service.get();
	}

	@Override
	public TBL_Order selectOrder(long order_id) {
		// TODO Auto-generated method stub
		return service.select(order_id);
	}

	@Override
	public void DeleteOrder(long order_id) {
		// TODO Auto-generated method stub
		service.delete(order_id);
	}
	
	
}
