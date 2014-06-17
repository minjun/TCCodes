package utils.main;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import repo.RoomRepository;

@Component("DeleteData")
public class DeleteData {
	@Autowired
	RoomRepository roomRepo;

	public void deleteAll() {
		roomRepo.deleteAll();
	}

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DeleteData component = (DeleteData) context.getBean("DeleteData");
		component.deleteAll();
		context.close();
		System.exit(0);
	}
}
