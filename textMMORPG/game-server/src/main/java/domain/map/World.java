package domain.map;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class World {
	@Id
	String worldName;
	Map<String,String> properties = new HashMap<String,String>();
	
	public World(String worldName) {
		this.worldName = worldName;
	}

	public String getProperties(String key) {
		return properties.get(key);
	}

	public void setProperties(String key, String value) {
		properties.put(key,value);
	}
}
