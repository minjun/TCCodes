package domain.charactor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import utils.Utils;

@Document
public class Char {
	@Id
	private String id;
	private Map<String, String> strSets = new HashMap<String, String>();
	private Map<String, Long> numSets = new HashMap<String, Long>();
	private Map<String, Long> skills = new HashMap<String, Long>();
	private Map<String, String> mapSkills = new HashMap<String, String>();
	private Map<String, String> objs = new HashMap<String, String>();
	private String[] family = new String[2];

	public Char(String id) {
		this.id = id;
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

	public long getNumSet(String key) {
		if (numSets.containsKey(key))
			return numSets.get(key);
		else
			return 0;
	}

	public void setNumSet(String key, long value) {
		numSets.put(key, value);
	}

	public String getStrSet(String key) {
		return strSets.get(key);
	}

	public void setStrSet(String key, String value) {
		strSets.put(key, value);
	}

	public void setSets(Map<String, String> sets) {
		Utils.setSets(sets, strSets, numSets);
	}

	public long getSkill(String key) {
		return skills.get(key);
	}

	public void setSkills(Map<String, String> skills) {
		Utils.setSets(skills, null, this.skills);
	}

	public String getMapSkill(String key) {
		return mapSkills.get(key);
	}

	public void setMapSkills(Map<String, String> mapSkills) {
		this.mapSkills = mapSkills;
	}

}
