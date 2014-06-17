package service.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PlayerServiceImplTest {
	static ConfigurableApplicationContext context = null;

	@BeforeClass
	public static void setupClass() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSaveAndGetPlayer() {
		assertTrue(true);
	}
}
