package domain.item;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import utils.Utils;

@Document
public class Item {
	public static enum ItemKind {
		weapon, armor, END
	};

	public static int EQUIPPED = -1;
	public static int NOTEQUIPPED = 0;

	@Id
	String id;
	String name;
	String ids;
	String inherits;
	ItemKind itemKind;

	Map<String, Long> numSets = new HashMap<String, Long>();
	Map<String, String> strSets = new HashMap<String, String>();
	@Transient
	int numberInRoom;
	@Transient
	boolean isRegular, isEquipped;

	public Item(String id, String name, String ids, String inherits) {
		this.id = id;
		this.name = name;
		this.ids = ids;
		this.inherits = inherits;
	}

	public String getId() {
		return id;
	}

	public int getNumberInRoom() {
		return numberInRoom;
	}

	public void setNumberInRoom(int numberInRoom) {
		this.numberInRoom = numberInRoom;
	}

	public void setSets(Map<String, String> sets) {
		Utils.setSets(sets, strSets, numSets);
	}

	public String getStrSet(String key) {
		return strSets.get(key);
	}

	public long getNumSet(String key) {
		return numSets.get(key);
	}

	public void setStrSet(String key, String value) {
		strSets.put(key, value);
	}

	public void setNumSet(String key, long value) {
		numSets.put(key, value);
	}

	public void setKind(ItemKind kind) {
		this.itemKind = kind;
	}

	public boolean isRegular() {
		return isRegular;
	}

	public void setRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}
	public boolean getEquipped() {
		return isEquipped;
	}
	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}
}
