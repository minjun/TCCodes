package domain.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import domain.item.Item;
import domain.player.Player;

@Document
public class Room {
	@Id
	String roomId;
	@Field
	String countryId;
	@Field
	String name;
	@Field
	String desc;
	@Field
	List<Exit> exits = new ArrayList<Exit>();
	@Field
	List<Npc> npcs = new ArrayList<Npc>();
	@Field
	List<Item> items = new ArrayList<Item>();
	@Transient
	List<Player> players = new LinkedList<Player>();

	public Room(String countryId, String roomId, String name, String desc, List<Exit> exits, List<Npc> npcs, List<Item> items) {
		this.roomId = roomId;
		this.countryId = countryId;
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.npcs = npcs;
		this.items = items;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public String getMessage(boolean shortFlag) {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		if (!shortFlag) {
			sb.append(desc);
		}
		return sb.toString();
	}
}
