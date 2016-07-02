package com.csc.dao;
import java.util.List;

import com.csc.model.TBL_Type;;
public interface typeDAO {
	public List<TBL_Type> getallType();
	public void  updateType(TBL_Type type);
	public void  insertType(TBL_Type type);
	public void 	deleteType(Long id );
	public TBL_Type gettypeByID(Long id);
	public int numberOfProduct(Long id); 
}
