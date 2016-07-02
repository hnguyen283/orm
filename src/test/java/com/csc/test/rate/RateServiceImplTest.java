package com.csc.test.rate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.csc.dao.RateDao;
import com.csc.model.TBL_Rate;
import com.csc.service.RateService;
import com.csc.service.RateServiceImpl;

public class RateServiceImplTest {

	RateDao rateDAO;
	RateService rateService;
	
	@Before
	public void setUp(){
		rateDAO = Mockito.mock(RateDao.class);
		
		RateServiceImpl rateServiceImpl = new RateServiceImpl();
		rateServiceImpl.setRateDAO(rateDAO);
		rateService = rateServiceImpl;
	}
	
	//@Test
	public void testInsertRate() {
		
	}

	@Test
	public void testGetRate() {
		TBL_Rate rate = new TBL_Rate();
		rate.setRate_id(1l);
		rate.setRate_point(5);
		
		Mockito.when(rateDAO.getRate(1l, 1l)).thenReturn(rate);
		
		TBL_Rate rateTest = rateService.getRate(1l, 1l);
		Assert.assertEquals(5, rateTest.getRate_point());
	}

}
