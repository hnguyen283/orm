package com.csc.service;

import java.util.List;

import com.csc.model.TBL_OrderDetail;

public interface OrderDetailService {
	public void CreateOrderDetail(TBL_OrderDetail odd);
	public void UpdateOrderDetail(TBL_OrderDetail odd);
	public void DeleteOrderDetail(long orderdetail_id);
	public List<TBL_OrderDetail> getOrderDetail(long order_id);
	public TBL_OrderDetail selectOrderDetail(long orderdetail_id);
}
