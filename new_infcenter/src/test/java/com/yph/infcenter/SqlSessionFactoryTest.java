/**
 * 
 */
package com.yph.infcenter;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yph.infcenter.common.spring.Environment;

/**
 * @author ydw
 *
 */
public class SqlSessionFactoryTest {
	
	private Environment e;
	
	private SqlSessionFactory factory;
	
	private SqlSession session;

	@Before
	public void init(){
		e = Environment.getInstance();
		//1、创建SQLSessionFactory
		factory = (SqlSessionFactory) e.getBean("sqlSessionFactory");
		//2、创建SQLSessioin
	    session = factory.openSession();
	}
	
	@After
	public void close(){
		if (session != null) {
			session.close();
		}
	}
	
	@Test
	public void testLoad(){
//		Customer customer = (Customer)session.selectOne("com.yph.infcenter.mapper.CustomerMapper.selectByPrimaryKey", 57);
//		System.out.println(customer.getCustomerName());
	}
}
