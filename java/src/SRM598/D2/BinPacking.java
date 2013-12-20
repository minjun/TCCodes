package SRM598.D2;

import java.util.LinkedList;
import java.util.List;

import SRM598.D1.BinPackingEasy;

public class BinPacking {
	public int minBins(int[] item) {
		List<Integer> list = new LinkedList<Integer>();
		int num100 = 0;
		for (int i=0;i<item.length;i++) {
			if (item[i] == 100) {
				num100++;
			} else {
				list.add(item[i]);
			}
		}
		int binnum = item.length;
		BinPackingEasy bpe = new BinPackingEasy();
		for (int i=0;i<=num100/3;i++) {
			int[] itemnew = new int[list.size()+num100-i*3];
			for (int j=0;j<list.size();j++) {
				itemnew[j] = list.get(j).intValue();
			}
			for (int j=0;j<num100-i*3;j++) {
				itemnew[list.size()+j] = 100;
			}
			binnum = Math.min(binnum, i+bpe.minBins(itemnew));
		}
		return binnum;
	}
}
