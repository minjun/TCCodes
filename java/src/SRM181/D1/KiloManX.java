package SRM181.D1;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
	int weapons;
	int shots;

	Node(int weapons, int shots) {
		this.weapons = weapons;
		this.shots = shots;
	}
}

class NodeComparator implements Comparator<Node> {
	public int compare(Node obj1, Node obj2) {
		return obj1.shots - obj2.shots;
	}
}

public class KiloManX {
	public int leastShots(String[] damageChart, int[] bossHealth) {
		boolean[] visited = new boolean[(int) Math.pow(2, 15)];
		int n = damageChart.length;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(n,
				new NodeComparator());
		pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node node = pq.remove();
			if (visited[node.weapons])
				continue;
			visited[node.weapons] = true;
			if (node.weapons == ((1 << n) - 1)) {
				return node.shots;
			}
			for (int i = 0; i < n; i++) {
				if (((node.weapons >> i) & 1) > 0)
					continue;

				int best = bossHealth[i];
				for (int j = 0; j < damageChart.length; j++) {
					if (i == j)
						continue;
					int damage = damageChart[j].charAt(i);
					if (((node.weapons >> j) & 1) > 0 && damage != '0') {
						int shotsNeeded = bossHealth[i] / damage;
						if (bossHealth[i] % damage != 0)
							shotsNeeded++;
						best = Math.min(best, shotsNeeded);
					}
				}
				pq.add(new Node(node.weapons | (1 << i), node.shots + best));
			}
		}
		return -1;
	}
}
