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

import domain.map.Exit;
import domain.map.Room;

@Component("importRoom")
public class ImportRoom {
	private static Logger logger = LoggerFactory.getLogger(ImportRoom.class);

	@Autowired
	private RoomService roomService;

	private static void printUsage() {
		System.out.println("Usage:ImportRoom dir suffix(.c/.h)");
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

	private List<Exit> getExits(String strExits, String countryId) {
		List<Exit> exits = new ArrayList<Exit>();
		if (strExits == null)
			return exits;
		for (int i = 0; i < Exit.DIR.END.ordinal(); i++) {
			String regex = String.format("\"%s\"[^\"]+\"(.+?)\"", Exit.DIR.values()[i]);
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(strExits);
			if (m.find()) {
				logger.debug("regex:" + m.group(1) + "[" + m.start() + "-" + m.end() + "]");
				exits.add(new Exit(Exit.DIR.values()[i], countryId, m.group(1)));
			}
		}
		return exits;
	}

	private String cleanName(String name) {
		return name.replaceAll("\"", "").trim();
	}

	public Room findRoom(String fileName) throws IOException {
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
			sb.append(line);
		}
		br.close();
		// convert to room object
		String str = sb.toString();
		String countryId = null;
		String roomId = null;
		String[] ss = fileName.split("\\\\");
		int i = 0;
		for (i = 0; i < ss.length; i++) {
			if (ss[i].equals("d"))
				break;
		}
		if (i < ss.length - 1) {
			countryId = ss[i + 1];
		}
		roomId = ss[ss.length - 1];
		String name = regexFind(str, "short\",(.+?)\\)");
		String desc = regexFind(str, "long\",(.+?)\\)");
		name = cleanName(name);
		desc = cleanName(desc);
		String strExits = regexFind(str, "exits\",\\s*\\(\\[(.+?)\\]\\)");
		// String strItems = regexFind(str, "objects\",\\s*\\(\\[(.+?)\\]\\)");
		List<Exit> exits = getExits(strExits, countryId);
		Room room = null;
		if (roomId == null || countryId == null || name == null || desc == null) {
			logger.error(String.format("Importing %s: failed - country:%s,room:%s,name:%s,desc:%s", fileName, countryId, roomId, name, desc));
		} else if (exits.isEmpty()) {
			logger.warn(String.format("Importing %s: no exits", fileName));
			room = new Room(countryId, roomId, name, desc, exits, null, null);
		} else {
			logger.info(String.format("Importing %s: ok", fileName));
			room = new Room(countryId, roomId, name, desc, exits, null, null);
		}
		return room;
	}

	private void importNpc(String fileName) {

	}

	private void importObj(String fileName) {

	}

	private void importRoom(String fileName) throws IOException {
		Room room = findRoom(fileName);
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
					if (path.contains("\\item\\") || path.contains("\\misc\\") || path.contains("\\obj\\")) {
						importObj(path);
					} else if (path.contains("\\npc\\")) {
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
		context.close();
	}
}
