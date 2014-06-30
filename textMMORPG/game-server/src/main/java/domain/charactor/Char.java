package domain.charactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.couchbase.core.mapping.Document;

import domain.item.Item;
import service.impl.ItemServiceImpl;
import utils.Utils;

@Document
public class Char {

	@Id
	protected String id;
	protected Map<String, String> strSets = new HashMap<String, String>();
	protected Map<String, Long> numSets = new HashMap<String, Long>();
	protected Map<String, Long> skills = new HashMap<String, Long>();
	protected Map<String, String> mapSkills = new HashMap<String, String>();
	protected Map<String, Integer> objs = new HashMap<String, Integer>();
	protected String[] family = new String[2];
	@Transient
	protected List<Item> items = new ArrayList<Item>();
	@Transient
	protected long tmpAttack, tmpDamage, tmp;

	public Char(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public int getObj(String key) {
		if (objs.containsKey(key))
			return objs.get(key);
		else
			return 0;
	}

	public Map<String, Integer> getObjs() {
		return objs;
	}

	public void setObjs(Map<String, String> objs) {
		Iterator<Map.Entry<String, String>> iter = objs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = iter.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (value.contains("wield") || value.contains("wear")) {
				this.objs.put(key, Item.EQUIPPED);
			} else {
				this.objs.put(key, Item.NOTEQUIPPED);
			}
		}
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

	public void addItem(Item e) {
		items.add(e);
	}

	public void removeItem(Item e) {
		items.remove(e);
	}

	public void equip(Item e) {

	}

	public void loadRegularItem(ItemServiceImpl itemService) {
		Iterator<Map.Entry<String, Integer>> iter = objs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			String key = entry.getKey();
			int value = entry.getValue();
			Item item = itemService.load(key);
			item.setEquipped(value == Item.EQUIPPED);
			equip(item);
			items.add(item);
		}
	}
}
