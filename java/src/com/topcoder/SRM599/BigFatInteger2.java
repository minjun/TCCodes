package com.topcoder.SRM599;

public class BigFatInteger2 {

    private int primeNumber(int a, int x) {
	int num = 0;
	while (a % x == 0) {
	    a /= x;
	    num++;
	}
	return num;
    }

    public boolean isDivisible(int a, int b, int c, int d) {
	int i = 2;
	while (c > 1) {
	    int num = 0;
	    while (c % i == 0) {
		c /= i;
		num++;
	    }
	    if (num * d > primeNumber(a, i) * b)
		return false;
	    i++;
	    if (i * i > c) {
		if (c > 1) {
		    if (1 * d > primeNumber(a, i) * b)
			return false;
		}

		break;
	    }
	}
	return true;
    }
}
