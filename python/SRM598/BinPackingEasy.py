'''
Created on 2013-12-8

@author: Administrator
'''

class BinPackingEasy:
    def minBins(self, item):
        item.sort(key=int)
        i = 0
        j = len(item) - 1
        binnum = 0
        while (i < j):
            if item[i] + item[j] <= 300:
                i += 1
                j -= 1
                binnum += 1
            else:
                j -= 1
                binnum += 1
        if i == j:
            binnum += 1
        return binnum
       
if __name__ == '__main__':
    bp = BinPackingEasy()
    assert bp.minBins([150, 150, 150, 150, 150]) == 3
    assert bp.minBins([130, 140, 150, 160]) == 2
    assert bp.minBins([101, 101, 101, 101, 101, 101, 101, 101, 101]) == 5
    assert bp.minBins([101, 200, 101, 101, 101, 101, 200, 101, 200]) == 6
    assert bp.minBins([123, 145, 167, 213, 245, 267, 289, 132, 154, 176, 198]) == 8
else:
    pass
