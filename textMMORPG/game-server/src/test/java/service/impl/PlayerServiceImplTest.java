package service.impl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.player.Player;

import service.PlayerService;

public class PlayerServiceImplTest {
	static ConfigurableApplicationContext context = null;

	@BeforeClass
	public static void setupClass() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSaveAndGetPlayer() {
		PlayerService service = (PlayerService) context.getBean("playerService");
		Player player = new Player("id", "name1", "password");
		service.move(player, "kezhan.c");
		System.out.println(service.look(player));
		service.savePlayer(player);
		Player playerGet = service.getPlayer("id");
		assertEquals(player.toString(), playerGet.toString());
	}
}
