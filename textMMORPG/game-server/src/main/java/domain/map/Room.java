package domain.map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import domain.charactor.Npc;
import domain.charactor.Player;
import domain.item.Item;

@Document
public class Room {

	@Id
	String id;
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

	public Room(String id, String name, String desc, List<Exit> exits, List<Npc> npcs, List<Item> items) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.exits = exits;
		this.npcs = npcs;
		this.items = items;
	}

	public List<Exit> getExits() {
		return exits;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void removePlayer(Player player) {
		players.remove(player);
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc.replace("@LONG", "").replace("LONG", "");
	}

}
