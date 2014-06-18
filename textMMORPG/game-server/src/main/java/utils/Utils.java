package utils;

public class Utils {
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
}
