package domain.map;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import domain.charactor.Player;

@Document
public class Room {

	@Id
	String id;
	String inherits;
	Map<String, String> sets;
	Map<String, String> exits;
	Map<String, String> objs;
	@Transient
	Map<String, Player> players;

	public Room(String id, String inherits) {
		this.id = id;
		this.inherits = inherits;
	}

	public void addPlayer(Player player) {
		players.put(player.getKey(), player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public String getSets(String key) {
		return sets.get(key);
	}

	public void setSets(Map<String, String> sets) {
		this.sets = sets;
	}

	public void setExits(Map<String, String> exits) {
		this.exits = exits;
	}

	public void setObjs(Map<String, String> objs) {
		this.objs = objs;
	}

}
