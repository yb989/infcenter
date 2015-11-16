package com.yph.infcenter.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yph.infcenter.entity.InfcenterInformation;
import com.yph.infcenter.service.InfcenterInformationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-base.xml","classpath:spring-security.xml"})
public class InfcenterInformationServiceImplTest {
	@Autowired
	private InfcenterInformationService infcenterInformationService;

	@Test
	public void testQueryAllByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEntityByInformationId() {
		InfcenterInformation entity = infcenterInformationService.findEntityByInformationId(30);
		System.out.println(entity.toString());
	}

	@Test
	public void testFindMapByInformationId() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindWebsitInfoById() {
		fail("Not yet implemented");
	}

}
