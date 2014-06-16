package utils.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import service.RoomService;
import service.impl.NpcServiceImpl;
import domain.charactor.Npc;
import domain.map.Room;

@Component("importRoom")
public class ImportRoom {
	private static final String NEWLINE = "\r\n";
	private static Logger logger = LoggerFactory.getLogger(ImportRoom.class);

	@Autowired
	private RoomService roomService;
	@Autowired
	private NpcServiceImpl npcService;

	private static void printUsage() {
		System.out.println("Usage:ImportRoom dir suffix(.c/.h)");
	}

	private String cleanName(String name) {
		if (name == null)
			return name;
		return name.replaceAll("\"", "").replaceAll("\\(\\[", "").replace("__DIR__", "").trim();
	}

	private boolean isRoom(String inherits) {
		return inherits.contains("ROOM;");
	}

	private boolean isNPC(String inherits) {
		return inherits.contains("NPC");
	}
	
	private Map<String, String> regexFind(String str, String regex) {
		Map<String, String> map = new HashMap<String, String>();
		if (str != null) {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			while (m.find()) {
				String key = cleanName(m.group(1));
				String value = cleanName(m.group(2));
				map.put(key, value);
			}
		}
		return map;
	}

	private String getInherits(String str) {
		String regex = "inherit\\s+(.*)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			sb.append(m.group(1));
		}
		return sb.toString();
	}

	private String getId(String fileName) {
		// id = unique file name
		int index = fileName.indexOf("\\d\\");
		String id = null;
		if (index != -1) {
			id = fileName.substring(index);
			id = id.replace("\\", "/");
		}
		return id;
	}

	private void printMap(Map<String, String> map) {
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			logger.info("key=" + key + ";value=" + val);
		}
	}

	private void importRoom(String fileName, String src, String inherits) {
		String id = getId(fileName);
		Map<String, String> sets = regexFind(src, "(?s)set\\s*\\((.+?),(.+?)\\)");
		Room room = null;
		if (id == null || sets.get("short") == null || sets.get("long") == null || inherits == null) {
			logger.error(String.format("Importing room:%s: failed - name:%s,desc:%s,inherits:%s", fileName, sets.get("short"), sets.get("long"), inherits));
		} else {
			String exits = sets.get("exits");
			sets.remove("exits");
			Map<String, String> exitMap = regexFind(exits, "(?s)(.+?):(.+?),");
			String objects = sets.get("objects");
			sets.remove("objects");
			Map<String, String> objMap = regexFind(objects, "(?s)(.+?):(.+?),");
			if (exitMap.isEmpty()) {
				logger.warn(String.format("Importing room:%s: no exits", fileName));
			} else {
				logger.info(String.format("Importing room:%s: ok", fileName));
			}
			room = new Room(id, inherits);
			room.setExits(exitMap);
			room.setObjs(objMap);
			room.setSets(sets);
		}
		if (room != null) {
			roomService.saveRoom(room);
		}
	}

	private void importNpc(String fileName, String src, String inherits) {
		String id = getId(fileName);
		// get name, ids
		String name = null, ids = null;
		Map<String, String> nameids = regexFind(src, "set_name\\(\"(.+?)\".+\\{(.+)\\}");
		Iterator<Map.Entry<String, String>> iter = nameids.entrySet().iterator();
		if (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			name = entry.getKey();
			ids = entry.getValue();
		}
		Npc npc = null;
		if (id == null || name == null || ids == null || inherits == null) {
			logger.error(String.format("Importing npc:%s: failed - name:%s,ids:%s,inherits:%s", fileName, name, ids, inherits));
		} else {
			logger.info(String.format("Importing npc:%s: ok", fileName));
			npc = new Npc(id, name, ids, inherits);
			npc.setSets(regexFind(src, "(?s)set\\s*\\((.+?),(.+?)\\)"));
			npc.setSkills(regexFind(src, "(?s)set_skill\\s*\\((.+?),(.+?)\\)"));
			npc.setMapSkills(regexFind(src, "(?s)map_skill\\s*\\((.+?),(.+?)\\)"));
		}
		if (npc != null) {
			npcService.saveNpc(npc);
		}
	}

	private void importItem(String fileName, String src, String inherits) {

	}

	private void importSrc(String fileName) throws IOException {
		// read from file
		File file = new File(fileName);
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line;
		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			line = line.replaceAll("//.*", "");
			if (line.trim().equals(""))
				continue;
			sb.append(line).append(NEWLINE);
		}
		br.close();
		String src = sb.toString();
		src = src.replaceAll("(?s)/\\*.*\\*/", "");
		logger.debug("filename=" + fileName + ";content=" + src + NEWLINE);
		String inherits = getInherits(src);
		if (isNPC(inherits)) {
			importNpc(fileName, src, inherits);
		} else if (isRoom(inherits)) {
			importRoom(fileName, src, inherits);
		} else {
			importItem(fileName, src, inherits);
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
					importSrc(path);
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
		//importRoom.importDir(args[0], args[1]);
		//importRoom.importSrc("C:\\Users\\minjun.wang\\Downloads\\dtxy2009\\d\\city\\ziyanglou.c");
		importRoom.importSrc("C:\\Users\\minjun.wang\\Downloads\\dtxy2009\\d\\city\\misc\\npc_scorekeeper.c");
		context.close();
	}
}
