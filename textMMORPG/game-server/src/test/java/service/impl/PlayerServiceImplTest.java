package service.impl;

import static org.junit.Assert.*;



import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.Player;

import service.PlayerService;

public class PlayerServiceImplTest {
    static ConfigurableApplicationContext context = null;

    @BeforeClass
    public static void setupClass() {
	context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testSaveAndGetPlayer() {
	PlayerService service = (PlayerService)context.getBean("playerService");
	Player player = new Player("id","name1","password");
	List<Player> players = new ArrayList<Player>();
	players.add(player);
	service.savePlayers(players);
	Player playerGet = service.getPlayer("id");
	assertEquals(player.toString(),playerGet.toString());
    }	

}
