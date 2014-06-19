package utils.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import service.impl.WorldServiceImpl;
import static utils.Ansi.*;
import domain.map.World;

@Component("importWorld")
public class ImportWorld {
	private static Logger logger = LoggerFactory.getLogger(ImportRoom.class);
	@Autowired
	private WorldServiceImpl worldService;

	private void importWorld() throws IOException {
		// read from configuration file
		String filename = "world.properties";
		InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
		if (input == null) {
			logger.error("Sorry, unable to find " + filename);
			return;
		}
		Properties prop = new Properties();
		prop.load(new InputStreamReader(input, "UTF-8"));
		// write into database
		World world = worldService.getWorld();
		if (world == null) {
			world = new World("world");
		}
		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			logger.info("Key : " + key + ", Value : " + value);
			world.setProperties(key, value);
		}
		worldService.saveWorld(world);
	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ImportWorld importWorld = (ImportWorld) context.getBean("importWorld");
		importWorld.importWorld();
		context.close();
		System.exit(0);
	}
}
