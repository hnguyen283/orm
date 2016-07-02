/*
 *
 * author : Nguyen Dong Hung, Nguyen Hong Nhut 
 * 
 * 
*/
package com.csc.service;

import java.util.List;

import com.csc.model.ResultObject;
import com.csc.model.TBL_Deal;
import com.csc.model.TBL_Item;
import com.csc.model.TBL_User;

public interface DealService {
	public TBL_Deal insertDeal(TBL_Deal deal);
	public void deleteDeal(long dealId);
	public void updateDeal(TBL_Deal deal);
	public List<TBL_Deal> allDeal();
	public TBL_Deal getDealById(Long id);
	
	public List<TBL_Deal> allDealSort(String element,int  start,int size, String sortby,String status);
	public List<TBL_Deal> allDealSortByType(String element,int  start,int size, String sortBy, Long id);
	
	public List<TBL_User> getListUser(TBL_Deal deal);
	public List<TBL_Deal> searchDealByName(String name);
	public List<TBL_Deal> getDealbyItem(Long item_id);
	public List<TBL_Deal> getDealbyType(Long id);
	public int getSizeDeal();
	public int getSizeDealByType(Long id);
	public List<TBL_Deal> getPaginationDeal(int start, int size);
	public List<ResultObject>getDataDraw(String labels, String type);
}
