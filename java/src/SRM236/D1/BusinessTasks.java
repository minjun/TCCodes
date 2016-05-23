package SRM236.D1;

import java.util.LinkedList;
import java.util.List;

public class BusinessTasks {
	public String getTask(String[] list, int n) {
		List<String> l = new LinkedList<String>();
		for (int i = 0; i < list.length; i++) {
			l.add(list[i]);
		}
		int start = 0;
		while (l.size() > 1) {
			start = (n - 1 + start) % l.size();
			l.remove(start);
		}
		return l.get(0);
	}
}
