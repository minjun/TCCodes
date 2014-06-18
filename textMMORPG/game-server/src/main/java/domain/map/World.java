package domain.map;

import java.util.HashMap;
import java.util.Map;

import static utils.Utils.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class World {
	@Id
	String worldName;
	Map<String, String> properties = new HashMap<String, String>();

	public World(String worldName) {
		this.worldName = worldName;
	}

	public String getProperties(String key) {
		String msg = properties.get(key);
		if (msg.charAt(msg.length() - 1) == '-') {
			return msg.substring(0, msg.length() - 1);
		}
		return msg + NEWLINE;
	}

	public void setProperties(String key, String value) {
		properties.put(key, value);
	}
}
