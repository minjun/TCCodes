package utils.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import service.RoomService;
import domain.charactor.Npc;
import domain.item.Item;
import domain.map.Exit;
import domain.map.Room;

@Component("importRoom")
public class ImportRoom {
	private static final String NEWLINE = "\r\n";
	private static Logger logger = LoggerFactory.getLogger(ImportRoom.class);

	@Autowired
	private RoomService roomService;

	private static void printUsage() {
		System.out.println("Usage:ImportRoom dir suffix(.c/.h)");
	}

	private String cleanName(String name) {
		if (name == null)
			return name;
		return name.replaceAll("\"", "").trim();
	}

	private String regexFind(String str, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if (m.find()) {
			logger.debug("regex:" + m.group(0) + "[" + m.start() + "-" + m.end() + "]");
			return m.group(1);
		}
		return null;
	}

	private void getExits(String strExits, List<Exit> exits) {
		if (strExits == null)
			return;
		for (int i = 0; i < Exit.DIR.END.ordinal(); i++) {
			String regex = String.format("\"%s\"[^\"]+\"([\\s\\S]+?)\"", Exit.DIR.values()[i]);
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(strExits);
			if (m.find()) {
				logger.debug("regex:" + m.group(1) + "[" + m.start() + "-" + m.end() + "]");
				exits.add(new Exit(Exit.DIR.values()[i], m.group(1)));
			}
		}
	}

	private void getItems(String strItems, List<Npc> npcs, List<Item> items) {
		if (strItems == null)
			return;
		String regex = "\"([\\s\\S]+?)\"\\s*:\\s*(\\d+)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(strItems);
		while (m.find()) {
			String id = m.group(1);
			int number = Integer.parseInt(m.group(2));
			logger.info("id="+id+";number="+number);
			if (isNPC(id)) {
				Npc npc = new Npc(id);
				for (int i = 0; i < number; i++) {
					npcs.add(npc);
				}
			} else if (isItem(id)) {
				Item item = new Item(id);
				for (int i = 0; i < number; i++) {
					items.add(item);
				}
			}
		}
	}

	private boolean isNPC(String id) {
		id.replace("\\","/");
		return id.contains("npc/");
	}

	private boolean isItem(String id) {
		id.replace("\\","/");
		return id.contains("item/") || id.contains("misc/") || id.contains("obj/");
	}

	private void importNpc(String fileName) {

	}

	private void importItem(String fileName) {

	}

	private void importRoom(String fileName) throws IOException {
		// read from file
		File file = new File(fileName);
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			if (line.trim().equals(""))
				continue;
			logger.debug(line);
			sb.append(line).append(NEWLINE);
		}
		br.close();
		// convert to room object
		int index = fileName.indexOf("\\d\\");
		String id = null;
		if (index != -1) {
			id = fileName.substring(index);
			id = id.replace("\\", "/");
		}
		String str = sb.toString();
		String name = regexFind(str, "short\",([\\s\\S]+?)\\)");
		String desc = regexFind(str, "long\",([\\s\\S]+?)\\)");
		name = cleanName(name);
		desc = cleanName(desc);
		String strExits = regexFind(str, "exits\",\\s*\\(\\[([\\s\\S]+?)\\]\\)");
		String strItems = regexFind(str, "objects\",\\s*\\(\\[([\\s\\S]+?)\\]\\)");
		List<Exit> exits = new ArrayList<Exit>();
		List<Npc> npcs = new ArrayList<Npc>();
		List<Item> items = new ArrayList<Item>();
		getItems(strItems, npcs, items);
		getExits(strExits, exits);
		Room room = null;
		if (id == null || name == null || desc == null) {
			logger.error(String.format("Importing %s: failed - name:%s,desc:%s", fileName, name, desc));
		} else {
			if (exits.isEmpty()) {
				logger.warn(String.format("Importing %s: no exits", fileName));
			} else {
				logger.info(String.format("Importing %s: ok", fileName));
			}
			room = new Room(id, name, desc, exits, npcs, items);
		}
		if (room != null) {
			roomService.saveRoom(room);
		}
	}

	private void importDir(String strPath, String suffix) throws IOException {
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		if (files == null)
			return;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				importDir(files[i].getAbsolutePath(), suffix);
			} else {
				String path = files[i].getAbsolutePath();
				if (path.endsWith(suffix)) {
					if (isItem(path)) {
						importItem(path);
					} else if (isNPC(path)) {
						importNpc(path);
					} else {
						importRoom(path);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		if (args.length < 2) {
			printUsage();
			return;
		}
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ImportRoom importRoom = (ImportRoom) context.getBean("importRoom");
		importRoom.importDir(args[0], args[1]);
		//importRoom.importRoom("C:\\Users\\minjun.wang\\Downloads\\dtxy2009\\d\\city\\ziyanglou.c");
		context.close();
	}
}
