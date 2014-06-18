package domain.map;

public final class Exit {
	public static enum DIR {
		north, south, east, west, northup, southup, eastup, westup, northdown, southdown, eastdown, westdown, northeast, northwest, southeast, southwest, up, down, out, enter, left, right, END
	};

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

	public static boolean isValidExit(String dir) {
		int i = 0;
		for (; i < DIR.END.ordinal(); i++) {
			String exit = DIR.values()[i].toString();
			if (dir.equalsIgnoreCase(exit)) {
				break;
			}
		}
		return i < DIR.END.ordinal() ? true : false;
	}
}
