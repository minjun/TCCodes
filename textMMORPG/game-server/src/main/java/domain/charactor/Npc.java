package domain.charactor;

import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Npc extends Char {
	String ids;
	String name;
	String inherits;
	@Transient
	String roomId;
	@Transient
	int numberInRoom;

	public Npc(String id, String name, String ids, String inherits) {
		super(id);
		this.name = name;
		this.ids = ids;
		this.inherits = inherits;
	}

	public int getNumberInRoom() {
		return numberInRoom;
	}

	public void setNumberInRoom(int numberInRoom) {
		this.numberInRoom = numberInRoom;
	}

	public String getName() {
		return name;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getInherits() {
		return inherits;
	}

}
