package com.yph.infcenter.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yph.infcenter.service.InfcenterPilotService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-base.xml","classpath:spring-security.xml"})
public class InfcenterPilotServiceImplTest {
	
	@Autowired
	private InfcenterPilotService infcenterPilotService;
	
	@Test
	public void testQueryDirectionPilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryFirstPilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertPilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxFirstPilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindFirstPilotInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSubWorkPilotInfoById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindVelocityNameById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindIdByIdColumnZhName() {
		Integer id = infcenterPilotService.findIdByIdColumnZhName("亿普惠官网");
		System.out.println(id);
	}

}
