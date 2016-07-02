package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.csc.dao.RateDao;
import com.csc.model.TBL_Rate;

public class RateServiceImpl implements RateService{
	
	@Autowired
	@Qualifier("rateDAO")
	private RateDao rateDAO;
	
	public RateDao getRateDAO() {
		return rateDAO;
	}

	public void setRateDAO(RateDao rateDAO) {
		this.rateDAO = rateDAO;
	}

	@Override
	public void insertRate(TBL_Rate rate) {
		rateDAO.insertRate(rate);
	}

	@Override
	public TBL_Rate getRate(long user_id, long deal_id) {
		return rateDAO.getRate(user_id, deal_id);
	}

	@Override
	public List<Object> getNumberOfEachPoint(long deal_id) {
		return rateDAO.getNumberOfEachPoint(deal_id);
	}

}
