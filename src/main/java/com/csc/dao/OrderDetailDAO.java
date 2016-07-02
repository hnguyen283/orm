package com.csc.dao;

import java.util.List;

import com.csc.model.TBL_OrderDetail;

public interface OrderDetailDAO {
	public void create(TBL_OrderDetail odDetail);
	public void update(TBL_OrderDetail odDetail); 
	public void delete(long orderDetail_id);
	public List<TBL_OrderDetail> get(long orderId);
	public TBL_OrderDetail select(long orderdetail_id);
}
