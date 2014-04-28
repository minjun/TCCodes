package domain.map;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import domain.item.Item;

@Document
public class Room {
    @Id
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
    @Field
    List<Item> items = new ArrayList<Item>();

    public Room(String countryId, String roomId, String shortName, String longName, List<Exit> exits, List<Npc> npcs, List<Item> items) {
	this.roomId = roomId;
	this.countryId = countryId;
	this.shortName = shortName;
	this.longName = longName;
	this.exits = exits;
	this.npcs = npcs;
	this.items = items;
    }
}
