package domain.map;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

@Document
public class Room {
	@Field
	String roomId;
	@Field
	String countryId;
	@Field
	String shortName;
	@Field
	String longName;
	@Field
	List<Exit> exits = new ArrayList<Exit>();
	@Field
	List<Npc> npcs = new ArrayList<Npc>();

	public Room(String roomId, String countryId, String shortName, String longName, List<Exit> exits, List<Npc> npcs) {
		this.roomId = roomId;
		this.countryId = countryId;
		this.shortName = shortName;
		this.longName = longName;
		this.exits = exits;
		this.npcs = npcs;
	}
}
