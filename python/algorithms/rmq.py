"""Range Minimum Query.py

"""
from math import ceil
from math import sqrt
from math import floor

def getMinimumInRange(numbers,start,end):
	assert(numbers)
	# get sqrt(length) min values
	minSqrt = []
	isqrt = sqrt(len(numbers))
	ifloor = int(floor(isqrt))
	iceil = int(ceil(isqrt))
	for i in range(0,iceil):
		minIdx = -1
		for j in range(0,ifloor):
			idx = i*ifloor+j
			if idx+1 > len(numbers):
				break
			if minIdx < 0 or numbers[idx] < numbers[minIdx]:
				minIdx = idx
		minSqrt.append(minIdx)				
	print minSqrt
	# compute min value
	startSpan = start / ifloor
	endSpan = end / ifloor
	minIdx = -1
	for i in range(start,(startSpan+1)*ifloor):
		if minIdx <0 or numbers[i] < numbers[minIdx]:
			minIdx = i
	for i in range(endSpan*ifloor,end):
		if minIdx <0 or numbers[i] < numbers[minIdx]:
			minIdx = i
	for i in range(startSpan+1,endSpan):
		if minIdx <0 or numbers[minSqrt[i]] < numbers[minIdx]:
			minIdx = minSqrt[i]
	return minIdx
				
				
if __name__ == "__main__":
	pass


	