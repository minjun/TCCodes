package domain.map;

public final class Exit {
    public static enum DIR {
	north, south, east, west, northup, southup, eastup, westup, northdown, southdown, eastdown, westdown, northeast, northwest, southeast, southwest, up, down, out, enter, left, right, END
    };

    DIR direction;
    String countryId;
    String roomId;

    public Exit(DIR dir, String countryId, String roomId) {
	this.direction = dir;
	this.countryId = countryId;
	this.roomId = roomId;
    }
}
