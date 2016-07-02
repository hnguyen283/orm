/*
 *
 * author : Nguyen Dong Hung, Nguyen Hong Nhut
 * 
 * 
*/
package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Deal;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_User;
import com.csc.dao.DealDAO;

@Service
public class DealServiceImpl implements DealService {

	@Override
	public List<TBL_Deal> getDealbyType(Long id) {
		System.out.println("In Deal Service .... get deal by type ");
		return dao.getDealbyType(id);
	}

	@Override
	public List<TBL_Deal> getDealbyItem(Long item_id) {
		System.out.println("In Deal Service .... get deal by item ");
		return dao.getDealbyItem(item_id);
	}

	@Autowired
	@Qualifier("dealDAO")
	private DealDAO dao;

	@Override
	public List<TBL_User> getListUser(TBL_Deal deal) {
		System.out.println("In Deal Service .... get user use deal ");
		return dao.getListUser(deal);

	}

	@Override
	public List<TBL_Deal> allDealSort(String element, int start, int size, String sortby,String status) {
			return dao.allDealSort(element, start, size, sortby,status);
	}

	@Override
	public List<TBL_Deal> searchDealByName(String name) {
		return dao.searchDealByName(name);
	}

	@Override
	public TBL_Deal insertDeal(TBL_Deal deal) {
		return dao.insertDeal(deal);
	}

	@Override
	public void deleteDeal(long dealId) {
		dao.deleteDeal(dealId);
	}

	@Override
	public void updateDeal(TBL_Deal deal) {
		dao.updateDeal(deal);
	}

	@Override
	public List<TBL_Deal> allDeal() {
		return dao.allDeal();
	}

	@Override
	public TBL_Deal getDealById(Long id) {
		return dao.getDealById(id);
	}

	@Override
	public int getSizeDeal() {
		return dao.getSizeDeal();
	}

	@Override
	public List<TBL_Deal> getPaginationDeal(int start, int size) {
		return dao.getPaginationDeal(start, size);
	}

	@Override
	public List<TBL_Deal> allDealSortByType(String element, int start, int size, String sortBy, Long id) {
		return dao.allDealSortByType(element, start, size, sortBy, id);
	}

	@Override
	public int getSizeDealByType(Long id) {
		return dao.getSizeDealByType(id);
	}

	@Override
	public List<ResultObject> getDataDraw(String labels, String type) {
		// TODO Auto-generated method stub
		return dao.getDataDraw(labels, type);
	}

	
}
