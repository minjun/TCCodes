package domain.charactor;

import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Npc extends Char {
	String inherits;
	String ids;
	String name;

	public Npc(String key, String name, String ids, String inherits) {
		super(key);
		this.name = name;
		this.ids = ids;
		this.inherits = inherits;
	}

	public String getName() {
		return name;
	}

	public String getInherits() {
		return inherits;
	}
}
