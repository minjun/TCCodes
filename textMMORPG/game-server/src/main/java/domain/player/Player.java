package domain.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import domain.item.Armor;

@Document
public class Player {
	@Id
	final String id;
	@Field
	final String name;
	@Field
	String password;
	@Field
	List<Armor> armors = new ArrayList<Armor>();
	@Field
	String roomId;
	@Field
	Bag bag;
	@Field
	Map<String, String> settings = new HashMap<String, String>();

	public Player(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		// armors.add(new Armor(Armor.KIND.BOOT,"boots"));
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "id=" + id + ";" + "name=" + name + ";" + "password=" + password + ";";
	}
}
