package com.csc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.csc.model.TBL_Type;
import com.csc.dao.typeDAO;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	@Qualifier("typeDAO")
	private typeDAO dao;
	@Override
	public List<TBL_Type> getallType() {
		// TODO Auto-generated method stub
		System.out.println("Inservice..... service get all type ");
		return dao.getallType() ;
	}

	@Override
	public void updateType(TBL_Type type) {
		// TODO Auto-generated method stub
		System.out.println("Inservice..... service update type ");
		dao.updateType(type);
	}

	@Override
	public void insertType(TBL_Type type) {
		// TODO Auto-generated method stub
		System.out.println("Inservice..... service insert type ");
		dao.insertType(type);
	}

	@Override
	public void deleteType(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Inservice..... service delete type ");
		dao.deleteType(id);
	}

	@Override
	public int numberOfProduct(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Inservice .... service get number of product in type");
		return dao.numberOfProduct(id);
		
	}

	@Override
	public TBL_Type gettypeByID(Long id) {
		// TODO Auto-generated method stub
		System.out.println("Inservice..... service get one type by id type ");
		return dao.gettypeByID(id);
	}

}
