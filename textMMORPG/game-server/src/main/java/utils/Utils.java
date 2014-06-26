package utils;

import java.util.Iterator;
import java.util.Map;

public class Utils {
	public final static char chComma = '¡¢';
	public final static char chPeriod = '¡£';
	public final static String NEWLINE = "\r\n";

	public static String getFullId(String id, String currentId) {
		if (id == null)
			return id;
		if (!id.startsWith("/d/")) {
			int index = currentId.lastIndexOf("/");
			id = currentId.substring(0, index + 1) + id;
		}
		if (!id.endsWith(".c")) {
			id = id + ".c";
		}
		return id;
	}

	public static boolean isRoom(String inherits) {
		return inherits.contains("ROOM;");
	}

	public static boolean isNPC(String inherits) {
		return inherits.contains("NPC");
	}

	public static String nullStringtoEmpty(String str, boolean addTrailEmpty) {
		if (str == null) {
			return "";
		} else {
			return str + (addTrailEmpty ? " " : "");
		}
	}

	public static void setSets(Map<String, String> sets, Map<String, String> strSets, Map<String, Long> numSets) {
		Iterator<Map.Entry<String, String>> iter = sets.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			long iValue = -1;
			if (value.matches("^-?\\d+$")) {
				iValue = Long.parseLong(value);
			}
			if (iValue == -1) {
				if (strSets != null)
					strSets.put(key, value);
			} else {
				numSets.put(key, iValue);
			}
		}
	}
}
