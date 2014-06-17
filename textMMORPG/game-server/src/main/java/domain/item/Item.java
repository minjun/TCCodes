package domain.item;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Item {
	@Id
	String id;
	String name;
	String ids;
	String inherits;
	Map<String,String> sets;
	@Transient
	int numberInRoom;
	
	
	public Item(String id,String name,String ids,String inherits) {
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
	public void setSets(Map<String,String> sets) {
		this.sets = sets;
	}
	public String getSet(String key) {
		return sets.get(key);
	}
}
