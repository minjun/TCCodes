package domain.charactor;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Char {
	@Id
	String key;
	private Map<String, String> sets;
	private Map<String, String> skills;
	private Map<String, String> mapSkills;

	public Char(String key) {
		this.key = key;
	}

	public String getSet(String key) {
		return sets.get(key);
	}

	public void setSets(Map<String, String> sets) {
		this.sets = sets;
	}

	public String getSkills(String key) {
		return skills.get(key);
	}

	public void setSkills(Map<String, String> skills) {
		this.skills = skills;
	}

	public String getMapSkills(String key) {
		return mapSkills.get(key);
	}

	public void setMapSkills(Map<String, String> mapSkills) {
		this.mapSkills = mapSkills;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
