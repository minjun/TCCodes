package SRM209.D1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class SortEntry implements Comparable<SortEntry> {
    String country;
    int[] m = new int[] { 0, 0, 0 };

    SortEntry(String country) {
	this.country = country;
    }

    public int compareTo(SortEntry e) {
	for (int i = 0; i < 3; i++) {
	    if (m[i] != e.m[i])
		return e.m[i] - m[i];
	}
	return country.compareTo(e.country);
    }
}

public class MedalTable {

    public String[] generate(String[] results) {
	Map<String, SortEntry> map = new HashMap<String, SortEntry>();
	for (int i = 0; i < results.length; i++) {
	    String[] items = results[i].split(" ");
	    for (int j = 0; j < items.length; j++) {
		if (!map.containsKey(items[j])) {
		    map.put(items[j], new SortEntry(items[j]));
		}
		SortEntry e = map.get(items[j]);
		e.m[j]++;
	    }
	}
	//Entry<String,SortEntry>[] e = map.entrySet().toArray(new Entry[0]);
	SortEntry[] se = (SortEntry[]) map.values().toArray(new SortEntry[0]);
	
	Arrays.sort(se);
	String[] res = new String[se.length];
	for (int i = 0; i < se.length; i++)
	    res[i] = se[i].country + " " + se[i].m[0] + " " + se[i].m[1] + " "
		    + se[i].m[2];
	return res;
    }
}
