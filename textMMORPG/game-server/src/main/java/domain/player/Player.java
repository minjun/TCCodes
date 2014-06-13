package domain.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import domain.item.Armor;

@Document
public class Player {
	public static final String PREFIX = "user_";
	public static enum PSTATUS {
		IDINPUT, IDCONFIRMED, NAMEINPUT, NORMAL, LOCKED, DELETED, END
	};
	public static final String SET_BRIEF = "brief";
	@Id
	String id;
	@Field
	String name;
	@Field
	String password;
	@Field
	List<Armor> armors = new ArrayList<Armor>();
	@Field
	String roomId;
	@Field
	Bag bag;
	@Field
	PSTATUS status;
	@Field
	Map<String, String> settings = new HashMap<String, String>();
	
	@Transient
	boolean connected = true;

	@Transient
	boolean inStore = false;

	
	public Player(String id, String name, String password) {
		this.id = PREFIX+id;
		this.name = name;
		this.password = password;
		this.status = PSTATUS.END;
		this.roomId = "city_kezhan.c";
		// armors.add(new Armor(Armor.KIND.BOOT,"boots"));
	}
	
	public boolean isInStore() {
		return inStore;
	}

	public void setInStore(boolean inStore) {
		this.inStore = inStore;
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public boolean needSave() {
		return status.ordinal() >= PSTATUS.NORMAL.ordinal() && status.ordinal() < PSTATUS.END.ordinal();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
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

	public PSTATUS getStatus() {
		return status;
	}

	public void setStatus(PSTATUS status) {
		this.status = status;
	}
	
	public void setSettings(String key, String value) {
		settings.put(key, value);
	}
	
	public String getSettings(String key) {
		return settings.get(key);
	}

	@Override
	public String toString() {
		return "id=" + id + ";name=" + name + ";password=" + password + ";status=" + status;
	}
}
