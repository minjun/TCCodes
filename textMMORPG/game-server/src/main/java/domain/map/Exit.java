package domain.map;

import java.util.HashMap;
import java.util.Map;

public final class Exit {
	public static enum DIR {
		north, south, east, west, northup, southup, eastup, westup, northdown, southdown, eastdown, westdown, northeast, northwest, southeast, southwest, up, down, out, enter, left, right, END
	};

	private final static Map<String, String> dirs = new HashMap<String, String>();
	static {
		dirs.put("e", "east");
		dirs.put("w", "west");
		dirs.put("n", "north");
		dirs.put("s", "south");
		dirs.put("nu", "northup");
		dirs.put("su", "southup");
		dirs.put("eu", "eastup");
		dirs.put("wu", "westup");
		dirs.put("nd", "northdown");
		dirs.put("ed", "eastdown");
		dirs.put("sd", "southdown");
		dirs.put("wd", "westdown");
		dirs.put("nw", "northwest");
		dirs.put("ne", "northeast");
		dirs.put("sw", "southwest");
		dirs.put("se", "southeast");
		dirs.put("u", "up");
		dirs.put("d", "down");
		dirs.put("o", "out");
		dirs.put("et", "enter");
	}
	DIR dir;
	// String countryId;
	String id;

	public Exit(DIR dir, String id) {
		this.dir = dir;
		// this.countryId = countryId;
		this.id = id;
	}

	public DIR getDir() {
		return dir;
	}

	public String getRoomId() {
		return id;
	}

	public static String getExit(String dir) {
		int i = 0;
		for (; i < DIR.END.ordinal(); i++) {
			String exit = DIR.values()[i].toString();
			if (dir.equalsIgnoreCase(exit)) {
				break;
			}
		}
		if (i < DIR.END.ordinal()) {
			return dir;
		} else {
			return dirs.get(dir);
		}
	}
}
