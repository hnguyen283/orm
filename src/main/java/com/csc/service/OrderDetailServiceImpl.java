package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csc.dao.OrderDetailDAO;
import com.csc.model.TBL_OrderDetail;

public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	@Qualifier("orderDetailDAO")
	private OrderDetailDAO service;

	@Override
	public void CreateOrderDetail(TBL_OrderDetail odd) {
		// TODO Auto-generated method stub
		service.create(odd);
	}

	@Override
	public void UpdateOrderDetail(TBL_OrderDetail odd) {
		// TODO Auto-generated method stub
		service.update(odd);
	}

	@Override
	public void DeleteOrderDetail(long orderdetail_id) {
		// TODO Auto-generated method stub
		service.delete(orderdetail_id);
	}

	@Override
	public List<TBL_OrderDetail> getOrderDetail(long order_id) {
		// TODO Auto-generated method stub
		return service.get(order_id);
	}

	@Override
	public TBL_OrderDetail selectOrderDetail(long orderdetail_id) {
		// TODO Auto-generated method stub
		return service.select(orderdetail_id);
	}
	
	
}
