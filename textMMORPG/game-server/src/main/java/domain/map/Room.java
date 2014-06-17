package domain.map;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import domain.charactor.Npc;
import domain.charactor.Player;
import domain.item.Item;

@Document
public class Room {

	@Id
	String id;
	String inherits;
	Map<String, String> sets;
	Map<String, String> exits;
	Map<String, String> objs;
	@Transient
	Map<String, Player> players = new HashMap<String, Player>();
	@Transient
	Map<String, Npc> npcs = new HashMap<String, Npc>();
	@Transient
	Map<String, Item> items = new HashMap<String, Item>();

	public Room(String id, String inherits) {
		this.id = id;
		this.inherits = inherits;
	}

	public String getId() {
		return id;
	}
	
	public void addNpc(Npc npc) {
		npcs.put(npc.getId(), npc);
	}
	public void addItem(Item item) {
		items.put(item.getId(), item);
	}

	public void addPlayer(Player player) {
		players.put(player.getId(), player);
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

	public Map<String, String> getExits() {
		return exits;
	}

	public void setObjs(Map<String, String> objs) {
		this.objs = objs;
	}

	public Map<String, String> getObjs() {
		return objs;
	}

	public Map<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(Map<String, Player> players) {
		this.players = players;
	}

	public Map<String, Npc> getNpcs() {
		return npcs;
	}

	public void setNpcs(Map<String, Npc> npcs) {
		this.npcs = npcs;
	}

	public Map<String, Item> getItems() {
		return items;
	}

	public void setItems(Map<String, Item> items) {
		this.items = items;
	}
	
}
