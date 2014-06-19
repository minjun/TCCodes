package domain.charactor;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Char {
	@Id
	private String id;
	private Map<String, String> sets;
	private Map<String, String> skills;
	private Map<String, String> mapSkills;
	private String[] family;
	private Map<String, String> objs;

	public Char(String id) {
		this.id = id;
	}

	public String getHP() {
		return "";
	}

	public String getId() {
		return id;
	}

	public Map<String, String> getObjs() {
		return objs;
	}

	public void setObjs(Map<String, String> objs) {
		this.objs = objs;
	}

	public void setFamily(String[] family) {
		if (family[0] != null && family[1] != null)
			this.family = family;
	}

	public String[] getFamily() {
		return family;
	}

	public String getSet(String key) {
		return sets.get(key);
	}

	public int getSetInt(String key) {
		return Integer.parseInt(sets.get(key));
	}

	public void setSet(String key, String value) {
		sets.put(key, value);
	}

	public void setSet(String key, int value) {
		sets.put(key, "" + value);
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

}
