package utils;

import java.util.HashMap;
import java.util.Map;

public class InputMapper {
	private final static Map<String, String> map = new HashMap<String, String>();
	static {
		// map directions
		map.put("e", "east");
		map.put("w", "west");
		map.put("n", "north");
		map.put("s", "south");
		map.put("nu", "northup");
		map.put("su", "southup");
		map.put("eu", "eastup");
		map.put("wu", "westup");
		map.put("nd", "northdown");
		map.put("ed", "eastdown");
		map.put("sd", "southdown");
		map.put("wd", "westdown");
		map.put("nw", "northwest");
		map.put("ne", "northeast");
		map.put("sw", "southwest");
		map.put("se", "southeast");
		map.put("u", "up");
		map.put("d", "down");
		map.put("o", "out");
		map.put("et", "enter");
		// map commands
		map.put("l", "look");
	}

	public static String getInputMap(String key) {
		String value = map.get(key);
		return value == null ? key : value;
	}
}
