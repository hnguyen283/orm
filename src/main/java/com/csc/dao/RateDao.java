package com.csc.dao;


import java.util.List;

import com.csc.model.TBL_Rate;

public interface RateDao {
	
	public void insertRate(TBL_Rate rate);
	
	public TBL_Rate getRate(long user_id, long deal_id);
	
	public List<Object> getNumberOfEachPoint(long deal_id);
	
}
