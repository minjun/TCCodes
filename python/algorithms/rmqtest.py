"""Unit test for RMQ.py

"""

import rmq
import unittest

class KnownValues(unittest.TestCase):
	def testKnownValues(self):
		numbers = (2,4,3,1,6,7,8,9,1,7)
		self.assertEqual(rmq.getMinimumInRange(numbers,2,7), 3)

if __name__ == "__main__":
    unittest.main()
