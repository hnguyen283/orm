package com.csc.test.type;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.csc.dao.typeDAO;
import com.csc.dao.typeDaoImpl;
import com.csc.model.TBL_Type;


public class TypeDAOTest {
	@AfterClass
	public static void afterTestTypeDAO() {
		System.out.println("Tested TypeDAO Test");
	}
	
	@Test 
	public void testGetAllType()
	{
		typeDaoImpl typeDAO = Mockito.mock(typeDaoImpl.class);
		List<TBL_Type> listtype = new ArrayList<TBL_Type>();
		TBL_Type type1 = new TBL_Type();
		type1.setType_id(1l);
		type1.setType_name("underware");
		type1.setType_icon("fa fa-bolt");
		type1.setType_description("that is close sexy for women and men");
		
		TBL_Type type2 = new TBL_Type();
		type2.setType_id(2l);
		type2.setType_name("toy");
		type2.setType_icon("fa fa-bolt");
		type2.setType_description("that is something fun for child");
		
		listtype.add(type1);
		listtype.add(type2);
		
		TBL_Type typ = Mockito.mock(TBL_Type.class);
		
		Mockito.when(typeDAO.getallType()).thenReturn(listtype);
		
		List<TBL_Type> result= typeDAO.getallType();
		
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("underware", result.get(0).getType_name());
		Assert.assertEquals("toy", result.get(1).getType_name());
	}
	
	@Test 
	public void testUpdateType()
	{
		typeDaoImpl typeDAO = Mockito.mock(typeDaoImpl.class);
		
		TBL_Type type1 = new TBL_Type();
		type1.setType_id(1l);
		type1.setType_name("underware");
		type1.setType_icon("fa fa-bolt");
		type1.setType_description("that is close sexy for women and men");
		
		TBL_Type type2 = new TBL_Type();
		type2.setType_id(1l);
		type2.setType_name("UnderWare");
		type2.setType_icon("fa fa-bolt");
		type2.setType_description("fuck");
		
		TBL_Type typ = Mockito.mock(TBL_Type.class);
		
		
		
		List<TBL_Type> result= typeDAO.getallType();
		
		Assert.assertEquals(2, result.size());
		Assert.assertEquals("underware", result.get(0).getType_name());
		Assert.assertEquals("toy", result.get(1).getType_name());
	}
}
